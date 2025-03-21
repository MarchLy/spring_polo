package marchly.datn.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "chuc_vu")
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 10)
    @Nationalized
    @Column(name = "ma_chuc_vu", length = 10)
    private String maChucVu;

    @Size(max = 50)
    @Nationalized
    @Column(name = "ten_chuc_vu", length = 50)
    private String tenChucVu;

    @Column(name = "trang_thai")
    private Boolean trangThai;

}