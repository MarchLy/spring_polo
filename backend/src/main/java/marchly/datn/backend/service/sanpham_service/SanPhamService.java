package marchly.datn.backend.service.sanpham_service;

import marchly.datn.backend.entity.SanPham;
import marchly.datn.backend.repository.sanpham_repo.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SanPhamService {
    @Autowired
    SanPhamRepo sanPhamRepo;

    public Page<SanPham> getAllSanPham(int page, int size) {
        return sanPhamRepo.findAll(PageRequest.of(page, size));
    }
}
