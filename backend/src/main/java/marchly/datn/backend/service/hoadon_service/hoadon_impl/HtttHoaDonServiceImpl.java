package marchly.datn.backend.service.hoadon_service.hoadon_impl;

import marchly.datn.backend.entity.HtttHoaDon;
import marchly.datn.backend.repository.hoadon_repo.HtttHoaDonRepo;
import marchly.datn.backend.service.hoadon_service.HtttHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HtttHoaDonServiceImpl implements HtttHoaDonService {
    @Autowired
    HtttHoaDonRepo htttHoaDonRepo;

    @Override
    public List<HtttHoaDon> getListHtttHoaDon() {
        return htttHoaDonRepo.findAll();
    }
}
