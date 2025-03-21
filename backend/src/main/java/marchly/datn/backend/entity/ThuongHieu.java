package marchly.datn.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "thuong_hieu")
public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "ma_thuong_hieu", nullable = false, length = 50)
    private String maThuongHieu;

    @Size(max = 255)
    @NotNull
    @Nationalized
    @Column(name = "ten_thuong_hieu", nullable = false)
    private String tenThuongHieu;

    @NotNull
    @Column(name = "trang_thai", nullable = false)
    private Boolean trangThai = false;

}