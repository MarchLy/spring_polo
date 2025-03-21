package marchly.datn.backend.repository.hoadon_repo;

import marchly.datn.backend.entity.LichSuHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichSuHoaDonRepo extends JpaRepository<LichSuHoaDon, Integer> {
}
