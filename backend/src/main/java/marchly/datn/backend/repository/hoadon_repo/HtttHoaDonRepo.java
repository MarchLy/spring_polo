package marchly.datn.backend.repository.hoadon_repo;

import marchly.datn.backend.entity.HtttHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HtttHoaDonRepo extends JpaRepository<HtttHoaDon, Integer> {
    List<HtttHoaDon> findAllByHoaDonId(Integer id);
}
