package marchly.datn.backend.service.sanpham_service;

import marchly.datn.backend.entity.SanPham;
import marchly.datn.backend.repository.sanpham_repo.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepo sanPhamRepo;

    // Lấy danh sách tất cả sản phẩm
    public List<SanPham> getAllSanPham() {
        return sanPhamRepo.findAll();
    }

    // Lấy danh sách sản phẩm có phân trang
    public Page<SanPham> getSanPhamByPage(int page, int size) {
        return sanPhamRepo.findAll(PageRequest.of(page, size));
    }

    // Lấy thông tin sản phẩm theo ID
    public Optional<SanPham> getSanPhamById(int id) {
        return sanPhamRepo.findById(id);
    }

    // Thêm mới hoặc cập nhật sản phẩm
    public SanPham saveSanPham(SanPham sanPham) {
        return sanPhamRepo.save(sanPham);
    }

    // Xóa sản phẩm theo ID
    public void deleteSanPham(int id) {
        sanPhamRepo.deleteById(id);
    }
}