package marchly.datn.backend.repository.sanpham_repo;

import marchly.datn.backend.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, Integer> {
    Page<SanPham> findAll(Pageable pageable);

}
