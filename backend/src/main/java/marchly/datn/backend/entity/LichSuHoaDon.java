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
@Table(name = "lich_su_hoa_don")
public class LichSuHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDon hoaDon;

    @Size(max = 10)
    @Nationalized
    @Column(name = "ma_lshd", length = 10)
    private String maLshd;

    @Size(max = 100)
    @Nationalized
    @Column(name = "hanh_dong_nguoi_thao_tac", length = 100)
    private String hanhDongNguoiThaoTac;

    @Size(max = 100)
    @Nationalized
    @Column(name = "ly_do_huy", length = 100)
    private String lyDoHuy;

    @Column(name = "ngay_cap_nhat")
    private Instant ngayCapNhat;

    @Size(max = 100)
    @Nationalized
    @Column(name = "ghi_chu", length = 100)
    private String ghiChu;

    @Column(name = "trang_thai")
    private Boolean trangThai;

}