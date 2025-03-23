package marchly.datn.backend.controller.sanpham_controller;

import marchly.datn.backend.entity.SanPham;
import marchly.datn.backend.service.sanpham_service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/san-pham")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    // Lấy danh sách tất cả sản phẩm (không phân trang)
    @GetMapping("/all")
    public List<SanPham> getAll() {
        return sanPhamService.getAllSanPham();
    }

    // Lấy danh sách sản phẩm có phân trang
    @GetMapping("/page")
    public Page<SanPham> getSanPhamByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return sanPhamService.getSanPhamByPage(page, size);
    }

    // Lấy thông tin sản phẩm theo ID
    @GetMapping("/{id}")
    public Optional<SanPham> getSanPhamById(@PathVariable int id) {
        return sanPhamService.getSanPhamById(id);
    }

    // Thêm hoặc cập nhật sản phẩm
    @PostMapping("/save")
    public SanPham saveSanPham(@RequestBody SanPham sanPham) {
        return sanPhamService.saveSanPham(sanPham);
    }

    // Xóa sản phẩm theo ID
    @DeleteMapping("/delete/{id}")
    public void deleteSanPham(@PathVariable int id) {
        sanPhamService.deleteSanPham(id);
    }
}