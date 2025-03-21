package marchly.datn.backend.service.hoadon_service.hoadon_impl;

import marchly.datn.backend.entity.HoaDon;
import marchly.datn.backend.repository.hoadon_repo.HoaDonRepo;
import marchly.datn.backend.service.hoadon_service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRepo hoaDonRepo;

    @Override
    public Page<HoaDon> searchHoaDon(String maHoaDon, String trangThai, Date fromDate, Date toDate, Pageable pageable) {


        Integer trangThaiInt = null;
        if (trangThai != null && !trangThai.isEmpty()) {
            try {
                trangThaiInt = Integer.parseInt(trangThai);
            } catch (NumberFormatException e) {
                trangThaiInt = null; // Xử lý lỗi nếu cần
            }
        }

//        log.info("maHoaDon: {}, trangThai: {}, fromDate: {}, toDate: {}", maHoaDon, trangThai, fromDate, toDate);

//        return hoaDonRepo.searchHoaDon(maHoaDon, trangThaiInt, fromDate, toDate, pageable);

        return hoaDonRepo.searchHoaDon(maHoaDon != null ? maHoaDon : "", trangThaiInt, fromDate, toDate, pageable);

    }

    @Override
    public HoaDon detailHoaDon(Integer id) {
        return hoaDonRepo.findById(id).orElse(null);
    }

    @Override
    public void updateHoaDon(HoaDon hoaDon) {
        hoaDonRepo.save(hoaDon);
    }
}
