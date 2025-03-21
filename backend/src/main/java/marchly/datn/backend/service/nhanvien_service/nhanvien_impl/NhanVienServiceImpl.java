package marchly.datn.backend.service.nhanvien_service.nhanvien_impl;

import marchly.datn.backend.entity.NhanVien;
import marchly.datn.backend.repository.nhanvien_repo.NhanVienRepo;
import marchly.datn.backend.service.nhanvien_service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    NhanVienRepo nhanVienRepo;

    @Override
    public List<NhanVien> getListNhanVien(){
        return nhanVienRepo.findAll();
    };
}
