package marchly.datn.backend.repository.sanpham_repo;

import marchly.datn.backend.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepo extends JpaRepository<MauSac, Integer> {
    Page<MauSac> findAll(Pageable pageable);
}
