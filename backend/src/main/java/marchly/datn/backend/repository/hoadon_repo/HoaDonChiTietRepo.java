package marchly.datn.backend.repository.hoadon_repo;

import marchly.datn.backend.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonChiTietRepo extends JpaRepository<HoaDonChiTiet, Integer> {

}
