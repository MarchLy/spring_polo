package marchly.datn.backend.service.khachhang__service.khachhang_impl;

import marchly.datn.backend.entity.KhachHang;
import marchly.datn.backend.repository.khachhang_repo.KhachHangRepo;
import marchly.datn.backend.service.khachhang__service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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


    @Override
    public KhachHang addKhachHang(KhachHang khachHang) {
        return khachHangRepo.save(khachHang);
    }

    @Override
    public KhachHang updateKhachHang(KhachHang khachHang) {
        if (khachHangRepo.existsById(khachHang.getId())) {
            return khachHangRepo.save(khachHang);
        }
        throw new RuntimeException("Khach hang khong ton tai");
    }

    @Override
    public void deleteKhachHang(Integer id) {
        if (khachHangRepo.existsById(id)) {
            khachHangRepo.deleteById(id);
        } else {
            throw new RuntimeException("Khach hang khong ton tai");
        }
    }

    @Override
    public Page<KhachHang> getClients(PageRequest pageRequest) {
        return khachHangRepo.findAll(pageRequest);
    }
}