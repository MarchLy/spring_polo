package marchly.datn.backend.service.hoadon_service;



import marchly.datn.backend.entity.ChiTietSanPham;
import marchly.datn.backend.entity.ChiTietSanPhamDto;

import java.util.List;

public interface ChiTietSanPhamService {
    List<ChiTietSanPham> getListChiTietSanPham();
    List<ChiTietSanPhamDto> getDanhSachSanPham(int id);

}
