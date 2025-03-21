package marchly.datn.backend.repository.sanpham_repo;

import marchly.datn.backend.entity.Hang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangRepo extends JpaRepository<Hang, Integer> {
}
