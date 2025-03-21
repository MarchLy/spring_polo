package marchly.datn.backend.controller.sanpham_controller;

import marchly.datn.backend.entity.SanPham;
import marchly.datn.backend.service.sanpham_service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {

    @Autowired
    SanPhamService sanPhamService;

    @GetMapping("/hien-thi")
    public String listSanPham(Model model,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size) {
        Page<SanPham> pageSanPham = sanPhamService.getAllSanPham(page, size);
        model.addAttribute("listSanPham", pageSanPham.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageSanPham.getTotalPages());
        return "/pages/QuanLySanPham/QuanLySanPham";
    }
}
