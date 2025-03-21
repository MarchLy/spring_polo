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
@Table(name = "phieu_giam_gia")
public class PhieuGiamGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 10)
    @Nationalized
    @Column(name = "ma_phieu_giam_gia", length = 10)
    private String maPhieuGiamGia;

    @Size(max = 50)
    @Nationalized
    @Column(name = "ten_phieu_giam_gia", length = 50)
    private String tenPhieuGiamGia;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "ngay_bat_dau")
    private Instant ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private Instant ngayKetThuc;

    @Column(name = "dieu_kien")
    private Integer dieuKien;

    @Column(name = "loai")
    private Integer loai;

    @Column(name = "kieu")
    private Boolean kieu;

    @Column(name = "gia_tri_toi_thieu", precision = 18, scale = 2)
    private BigDecimal giaTriToiThieu;

    @Column(name = "gia_tri_toi_da", precision = 18, scale = 2)
    private BigDecimal giaTriToiDa;

    @Column(name = "trang_thai")
    private Boolean trangThai;

}