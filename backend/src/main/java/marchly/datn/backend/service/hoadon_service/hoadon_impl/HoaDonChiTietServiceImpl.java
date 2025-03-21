package marchly.datn.backend.service.hoadon_service.hoadon_impl;


import marchly.datn.backend.entity.HoaDonChiTiet;
import marchly.datn.backend.repository.hoadon_repo.HoaDonChiTietRepo;
import marchly.datn.backend.service.hoadon_service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    @Autowired
    HoaDonChiTietRepo hoaDonChiTietRepo;

    @Override
    public List<HoaDonChiTiet> getListHoaDonChiTiet() {
        return hoaDonChiTietRepo.findAll();
    }
}
