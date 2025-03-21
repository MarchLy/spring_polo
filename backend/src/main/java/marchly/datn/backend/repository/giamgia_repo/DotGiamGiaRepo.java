package marchly.datn.backend.repository.giamgia_repo;

import marchly.datn.backend.entity.DotGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DotGiamGiaRepo extends JpaRepository<DotGiamGia, Integer> {
    @Query("SELECT p FROM DotGiamGia p WHERE p.trangThai = 1")
    List<DotGiamGia> findAllActive();
}
