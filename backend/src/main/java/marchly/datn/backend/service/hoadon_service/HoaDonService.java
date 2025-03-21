package marchly.datn.backend.service.hoadon_service;

import marchly.datn.backend.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface HoaDonService {

    //    Page<HoaDon> getListHoaDon(int page, int size);
    Page<HoaDon> searchHoaDon(String maHoaDon, String trangThai, Date fromDate, Date toDate, Pageable pageable);

    HoaDon detailHoaDon(Integer id);

    void updateHoaDon(HoaDon hoaDon);

}
