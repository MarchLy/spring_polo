package marchly.datn.backend.controller.hoadon_controller;

import marchly.datn.backend.entity.ChiTietSanPhamDto;
import marchly.datn.backend.entity.HoaDon;
import marchly.datn.backend.entity.LichSuHoaDonDto;
import marchly.datn.backend.service.khachhang__service.KhachHangService;
import marchly.datn.backend.service.nhanvien_service.NhanVienService;
import marchly.datn.backend.service.hoadon_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController  // ✅ Đổi từ @Controller thành @RestController
@RequestMapping("/api/hoa-don") // ✅ Định nghĩa API
public class HoaDonController {

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @Autowired
    private HtttHoaDonService htttHoaDonService;

    @Autowired
    private LichSuHoaDonService lichSuHoaDonService;

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping("/hien-thi")
    public Page<HoaDon> hienThi(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "5") int size,
                                @RequestParam(required = false, defaultValue = "") String maHoaDon,
                                @RequestParam(required = false) String trangThai,
                                @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
                                @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {

        Pageable pageable = PageRequest.of(page, size);
        return hoaDonService.searchHoaDon(maHoaDon, trangThai, fromDate, toDate, pageable);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Map<String, Object>> detail(@PathVariable("id") int id) {
        HoaDon hoaDon = hoaDonService.detailHoaDon(id);
        List<LichSuHoaDonDto> listLichSuHoaDonDto = lichSuHoaDonService.getListLichSuHoaDonDto(id);
        List<ChiTietSanPhamDto> listDanhSachSanPham = chiTietSanPhamService.getDanhSachSanPham(id);

        Map<String, Object> response = new HashMap<>();
        response.put("hoaDon", hoaDon);
        response.put("listLichSuHoaDonDto", listLichSuHoaDonDto);
        response.put("listDanhSachSanPham", listDanhSachSanPham);

        return ResponseEntity.ok(response);
    }
}
