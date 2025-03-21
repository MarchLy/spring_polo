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
@Table(name = "danh_muc")
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 10)
    @Nationalized
    @Column(name = "ma_danh_muc", length = 10)
    private String maDanhMuc;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "ten_danh_muc", nullable = false, length = 50)
    private String tenDanhMuc;

    @Size(max = 100)
    @Nationalized
    @Column(name = "mo_ta", length = 100)
    private String moTa;

    @Column(name = "trang_thai")
    private Boolean trangThai;

}