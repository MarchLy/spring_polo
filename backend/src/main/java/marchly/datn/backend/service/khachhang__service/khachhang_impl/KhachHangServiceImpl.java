package marchly.datn.backend.service.khachhang__service.khachhang_impl;

import marchly.datn.backend.entity.KhachHang;
import marchly.datn.backend.repository.khachhang_repo.KhachHangRepo;
import marchly.datn.backend.service.khachhang__service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    KhachHangRepo khachHangRepo;

    @Override
    public List<KhachHang> getListKhachHang() {
        return khachHangRepo.findAll();
    }
}
