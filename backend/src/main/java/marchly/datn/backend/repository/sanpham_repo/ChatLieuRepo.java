package marchly.datn.backend.repository.sanpham_repo;

import marchly.datn.backend.entity.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatLieuRepo extends JpaRepository<ChatLieu, Integer> {
}
