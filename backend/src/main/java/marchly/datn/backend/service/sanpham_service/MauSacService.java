package marchly.datn.backend.service.sanpham_service;

import marchly.datn.backend.entity.MauSac;
import marchly.datn.backend.repository.sanpham_repo.MauSacRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MauSacService {
    @Autowired
    MauSacRepo mauSacRepo;

    public Page<MauSac> getAllMauSac(int page, int size) {
        return mauSacRepo.findAll(PageRequest.of(page, size));
    }
}
