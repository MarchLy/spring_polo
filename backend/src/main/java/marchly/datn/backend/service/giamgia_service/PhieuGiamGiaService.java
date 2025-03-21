package marchly.datn.backend.service.giamgia_service;

import marchly.datn.backend.entity.PhieuGiamGia;
import marchly.datn.backend.repository.giamgia_repo.PhieuGiamGiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhieuGiamGiaService {
    @Autowired
    private PhieuGiamGiaRepo phieuGiamGiaRepo;

    //findAll trangThai = 1
    public List<PhieuGiamGia> findAll() {
        return phieuGiamGiaRepo.findAllActive();
    }

    //Xoa mem pgg
    public boolean deletePgg(Integer id) {
        return phieuGiamGiaRepo.deletePgg(id) > 0;
    }

    public void addPgg(PhieuGiamGia phieuGiamGia){
        phieuGiamGiaRepo.save(phieuGiamGia);
    }
}

