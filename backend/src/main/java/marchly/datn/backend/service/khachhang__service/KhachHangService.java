package marchly.datn.backend.service.khachhang__service;
import marchly.datn.backend.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface KhachHangService {
    List<KhachHang> getListKhachHang();
    KhachHang addKhachHang(KhachHang khachHang);
    KhachHang updateKhachHang(KhachHang khachHang);
    void deleteKhachHang(Integer id);
    Page<KhachHang> getClients(PageRequest pageRequest);
}