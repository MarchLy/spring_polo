package marchly.datn.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "khach_hang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 10)
    @Nationalized
    @Column(name = "ma_khach_hang", length = 10)
    private String maKhachHang;

    @Size(max = 50)
    @Nationalized
    @Column(name = "ho_ten", length = 50)
    private String hoTen;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Size(max = 13)
    @Nationalized
    @Column(name = "sdt", length = 13)
    private String sdt;

    @Size(max = 20)
    @Nationalized
    @Column(name = "cccd", length = 20)
    private String cccd;

    @Size(max = 100)
    @Nationalized
    @Column(name = "dia_chi", length = 100)
    private String diaChi;

    @Size(max = 100)
    @Nationalized
    @Column(name = "email", length = 100)
    private String email;

    @Size(max = 255)
    @Nationalized
    @Column(name = "hinh_anh")
    private String hinhAnh;

    @Column(name = "ngay_sinh")
    private Instant ngaySinh;

    @Column(name = "trang_thai")
    private Boolean trangThai;

}