package marchly.datn.backend.repository.sanpham_repo;

import marchly.datn.backend.entity.CoAo;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

@Repository
public interface CoAoRepo extends JpaAttributeConverter<CoAo, Integer> {
}
