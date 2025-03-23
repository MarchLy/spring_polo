package marchly.datn.backend.controller.khachhang_controller;

import marchly.datn.backend.entity.KhachHang;
import marchly.datn.backend.service.khachhang__service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khach-hang")
@CrossOrigin(origins = "*") // Cho phép frontend gọi API
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/all")
    public List<KhachHang> getAll() {
        return khachHangService.getListKhachHang();
    }
    @GetMapping
    public ResponseEntity<Page<KhachHang>> getClients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(khachHangService.getClients(pageRequest));
    }
    @PostMapping("/add")
    public ResponseEntity<KhachHang> addKhachHang(@RequestBody KhachHang khachHang) {
        return ResponseEntity.ok(khachHangService.addKhachHang(khachHang));
    }

    @PutMapping("/update")
    public ResponseEntity<KhachHang> updateKhachHang(@RequestBody KhachHang khachHang) {
        return ResponseEntity.ok(khachHangService.updateKhachHang(khachHang));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteKhachHang(@PathVariable Integer id) {
        khachHangService.deleteKhachHang(id);
        return ResponseEntity.noContent().build();
    }
}