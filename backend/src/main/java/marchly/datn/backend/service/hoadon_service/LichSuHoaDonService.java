package marchly.datn.backend.service.hoadon_service;


import marchly.datn.backend.entity.LichSuHoaDon;
import marchly.datn.backend.entity.LichSuHoaDonDto;

import java.util.List;

public interface LichSuHoaDonService {

    List<LichSuHoaDon> getListLichSuHoaDon();
    List<LichSuHoaDonDto> getListLichSuHoaDonDto(int id); // Thay đổi từ getLichSuHoaDonById
}
