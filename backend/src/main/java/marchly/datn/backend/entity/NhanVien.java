package marchly.datn.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_chuc_vu")
    private ChucVu chucVu;

    @Size(max = 10)
    @Nationalized
    @Column(name = "ma_nhan_vien", length = 10)
    private String maNhanVien;

    @Size(max = 100)
    @Nationalized
    @Column(name = "ho_ten", length = 100)
    private String hoTen;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "ngay_sinh")
    private Instant ngaySinh;

    @Size(max = 100)
    @Nationalized
    @Column(name = "email", length = 100)
    private String email;

    @Size(max = 20)
    @Nationalized
    @Column(name = "cccd", length = 20)
    private String cccd;

    @Size(max = 13)
    @Nationalized
    @Column(name = "sdt", length = 13)
    private String sdt;

    @Size(max = 50)
    @Nationalized
    @Column(name = "mat_khau", length = 50)
    private String matKhau;

    @Column(name = "luong", precision = 18, scale = 2)
    private BigDecimal luong;

    @Size(max = 100)
    @Nationalized
    @Column(name = "dia_chi", length = 100)
    private String diaChi;

    @Size(max = 255)
    @Nationalized
    @Column(name = "hinh_anh")
    private String hinhAnhNV;

    @Column(name = "trang_thai")
    private Boolean trangThai;

}