package marchly.datn.backend.service.giamgia_service;

import marchly.datn.backend.entity.DotGiamGia;
import marchly.datn.backend.repository.giamgia_repo.DotGiamGiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DotGiamGiaService {
    @Autowired
    private DotGiamGiaRepo dotGiamGiaRepo;

    //findAll trangThai = 1
    public List<DotGiamGia> findAll() {
        return dotGiamGiaRepo.findAllActive();
    }
}
