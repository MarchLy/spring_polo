package marchly.datn.backend.service.hoadon_service.hoadon_impl;


import marchly.datn.backend.entity.ChiTietSanPham;
import marchly.datn.backend.entity.ChiTietSanPhamDto;
import marchly.datn.backend.repository.hoadon_repo.ChiTietSanPhamDtoRepo;
import marchly.datn.backend.repository.hoadon_repo.ChiTietSanPhamRepo;
import marchly.datn.backend.service.hoadon_service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    ChiTietSanPhamRepo chiTietSanPhamRepo;

    @Autowired
    ChiTietSanPhamDtoRepo chiTietSanPhamDtoRepo;

    @Override
    public List<ChiTietSanPham> getListChiTietSanPham() {
        return chiTietSanPhamRepo.findAll();
    }

    @Override
    public List<ChiTietSanPhamDto> getDanhSachSanPham(int id){
        return chiTietSanPhamDtoRepo.getDanhSachSanPham(id);
    }
}
