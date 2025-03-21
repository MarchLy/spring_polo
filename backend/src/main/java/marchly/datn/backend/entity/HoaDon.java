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
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "id_nhan_vien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "id_phieu_giam_gia")
    private PhieuGiamGia phieuGiamGia;

    @Size(max = 10)
    @Nationalized
    @Column(name = "ma_hoa_don", length = 10)
    private String maHoaDon;

    @Column(name = "ngay_tao")
    private Instant ngayTao;

    @Column(name = "ngay_thanh_toan")
    private Instant ngayThanhToan;

    @Column(name = "tong_tien", precision = 18, scale = 2)
    private BigDecimal tongTien;

    @Column(name = "so_tien_giam", precision = 18, scale = 2)
    private BigDecimal soTienGiam;

    @Column(name = "phi_van_chuyen", precision = 18, scale = 2)
    private BigDecimal phiVanChuyen;

    @Column(name = "loai_hoa_don")
    private Boolean loaiHoaDon;

    @Column(name = "ngay_giao_hang")
    private Instant ngayGiaoHang;

    @Column(name = "ngay_du_kien_nhan_hang")
    private Instant ngayDuKienNhanHang;

    @Column(name = "ngay_mong_muon_nhan_hang")
    private Instant ngayMongMuonNhanHang;

    @Column(name = "trang_thai")
    private Integer trangThai;

}