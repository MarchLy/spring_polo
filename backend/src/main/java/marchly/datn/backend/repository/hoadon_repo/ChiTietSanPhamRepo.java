package marchly.datn.backend.repository.hoadon_repo;

import marchly.datn.backend.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietSanPhamRepo extends JpaRepository<ChiTietSanPham, Integer> {

}
