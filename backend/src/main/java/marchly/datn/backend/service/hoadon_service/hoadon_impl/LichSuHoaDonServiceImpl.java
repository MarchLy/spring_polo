package marchly.datn.backend.service.hoadon_service.hoadon_impl;

import marchly.datn.backend.entity.LichSuHoaDon;
import marchly.datn.backend.entity.LichSuHoaDonDto;
import marchly.datn.backend.repository.hoadon_repo.LichSuHoaDonDtoRepo;
import marchly.datn.backend.repository.hoadon_repo.LichSuHoaDonRepo;
import marchly.datn.backend.service.hoadon_service.LichSuHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LichSuHoaDonServiceImpl implements LichSuHoaDonService {

    @Autowired
    LichSuHoaDonRepo lichSuHoaDonRepo;

    @Autowired
    LichSuHoaDonDtoRepo lichSuHoaDonDtoRepo;

    @Override
    public List<LichSuHoaDon> getListLichSuHoaDon() {
        return lichSuHoaDonRepo.findAll();
    }

//    @Override
//    public List<LichSuHoaDonDto> getListLichSuHoaDonDto(int id) {
//        return lichSuHoaDonDtoRepo.getListLichSuHoaDonDto(id);
//    }

    @Override
    public List<LichSuHoaDonDto> getListLichSuHoaDonDto(int id) {
        List<LichSuHoaDonDto> result = lichSuHoaDonDtoRepo.getListLichSuHoaDonDto(id);
        System.out.println("Số lượng lịch sử thanh toán: " + result.size());
        if (result.isEmpty()) {
            System.out.println("Không có dữ liệu lịch sử thanh toán cho hóa đơn ID: " + id);
        }
        return result;
    }
}
