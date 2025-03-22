
<template>
  <div class="container mt-4">
    <h4>Danh sách hóa đơn</h4>

    <!-- Bộ lọc và tìm kiếm -->
    <form @submit.prevent="fetchHoaDon">
      <div class="row mb-3">
        <div class="col-md-3">
          <input
              type="text"
              class="form-control"
              v-model="filters.maHoaDon"
              placeholder="Mã hóa đơn"
          />
        </div>
        <div class="col-md-2">
          <select class="form-select" v-model="filters.trangThai">
            <option value="">Tất cả</option>
            <option value="0">Chờ xác nhận</option>
            <option value="1">Đang vận chuyển</option>
            <option value="2">Hoàn thành</option>
            <option value="3">Đã hủy</option>
            <option value="4">Trả hàng</option>
          </select>
        </div>
        <div class="col-md-3">
          <input type="date" class="form-control" v-model="filters.fromDate" />
        </div>
        <div class="col-md-3">
          <input type="date" class="form-control" v-model="filters.toDate" />
        </div>
        <div class="col-md-1">
          <button type="submit" class="btn btn-primary w-100">Tìm kiếm</button>
        </div>
      </div>
    </form>

    <!-- Tabs trạng thái -->
    <ul class="nav nav-tabs">
      <li class="nav-item">
        <a class="nav-link active" href="#">Tất cả</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"
        >Chờ xác nhận <span class="badge bg-danger">2</span></a
        >
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"
        >Đang vận chuyển <span class="badge bg-danger">2</span></a
        >
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"
        >Hoàn thành <span class="badge bg-danger">17</span></a
        >
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"
        >Đã hủy <span class="badge bg-danger">7</span></a
        >
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"
        >Trả hàng <span class="badge bg-danger">9</span></a
        >
      </li>
    </ul>

    <!-- Bảng danh sách hóa đơn -->
    <table class="table table-hover mt-3">
      <thead class="table-light">
      <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Khách hàng</th>
        <th>Nhân viên</th>
        <th>SDT</th>
        <th>Tổng tiền</th>
        <th>Trạng thái</th>
        <th>Ngày tạo</th>
        <th>Loại đơn hàng</th>
        <th>Hành động</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(hd, index) in listHoaDon" :key="hd.id">
        <td>{{ index + 1 }}</td>
        <td>{{ hd.maHoaDon }}</td>
        <td>{{ hd.khachHang.hoTen }}</td>
        <td>{{ hd.nhanVien.hoTen }}</td>
        <td>{{ hd.khachHang.sdt }}</td>
        <td>{{ formatCurrency(hd.tongTien) }}</td>
        <td>
            <span
                :class="getStatusClass(hd.trangThai)"
                class="status-card badge"
            >
              {{ getStatusText(hd.trangThai) }}
            </span>
        </td>
        <td>{{ formatDate(hd.ngayTao) }}</td>
        <td>
            <span
                :class="hd.loaiHoaDon ? 'status-card badge bg-success' : 'status-card badge bg-danger'"
            >
              {{ hd.loaiHoaDon ? "Online" : "Tại quầy" }}
            </span>
        </td>
        <td>
          <button
              class="btn btn-sm btn-outline-primary"
              @click="viewDetail(hd.id)"
              title="chi tiết"
          >
            📄
          </button>
          <button class="btn btn-sm btn-outline-primary" title="In hóa đơn">
            🖨️
          </button>
        </td>
      </tr>
      </tbody>
    </table>

    <!-- Phân trang -->
    <nav aria-label="Page navigation">
      <ul class="pagination justify-content-center">
        <li class="page-item" :class="{ disabled: currentPage === 0 }">
          <a class="page-link" href="#" @click.prevent="prevPage">&lt;</a>
        </li>
        <li
            v-for="pageNum in totalPages"
            :key="pageNum"
            class="page-item"
            :class="{ active: pageNum - 1 === currentPage }"
        >
          <a
              class="page-link"
              href="#"
              @click.prevent="goToPage(pageNum - 1)"
          >
            {{ pageNum }}
          </a>
        </li>
        <li class="page-item" :class="{ disabled: currentPage + 1 >= totalPages }">
          <a class="page-link" href="#" @click.prevent="nextPage">&gt;</a>
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>
// import PaymentCard from "./components/PaymentCard.vue";
// import InvoiceCard from "./components/InvoiceCard.vue";
// import BillingCard from "./components/BillingCard.vue";
// import TransactionCard from "./components/TransactionCard.vue";

import api from "@/services/api";

export default {
  data() {
    return {
      listHoaDon: [], // Danh sách hóa đơn
      filters: {
        maHoaDon: "",
        trangThai: "",
        fromDate: "",
        toDate: "",
      },
      currentPage: 0, // Trang hiện tại
      size: 5, // Số lượng bản ghi mỗi trang
      totalPages: 0, // Tổng số trang
    };
  },
  methods: {
    // Lấy dữ liệu hóa đơn từ API
    async fetchHoaDon() {
      try {
        const response = await api.get("/hoa-don/hien-thi", {
          params: {
            page: this.currentPage,
            size: this.size,
            ...this.filters,
          },
        });
        this.listHoaDon = response.data.content;
        this.totalPages = response.data.totalPages;
      } catch (error) {
        console.error("Lỗi khi tải dữ liệu hóa đơn:", error);
      }
    },
    // Chuyển đến trang trước
    prevPage() {
      if (this.currentPage > 0) {
        this.currentPage--;
        this.fetchHoaDon();
      }
    },
    // Chuyển đến trang tiếp theo
    nextPage() {
      if (this.currentPage + 1 < this.totalPages) {
        this.currentPage++;
        this.fetchHoaDon();
      }
    },
    // Chuyển đến trang cụ thể
    goToPage(pageNum) {
      this.currentPage = pageNum;
      this.fetchHoaDon();
    },
    // Định dạng tiền tệ
    formatCurrency(value) {
      return new Intl.NumberFormat("vi-VN", {
        style: "currency",
        currency: "VND",
      }).format(value);
    },
    // Định dạng ngày tháng
    formatDate(date) {
      return new Date(date).toLocaleDateString("vi-VN");
    },
    // Lấy class trạng thái
    getStatusClass(status) {
      switch (status) {
        case 0:
          return "bg-warning text-dark";
        case 1:
          return "bg-info text-dark";
        case 2:
          return "bg-success";
        case 3:
          return "bg-danger";
        case 4:
          return "bg-secondary";
        default:
          return "bg-dark";
      }
    },
    // Lấy văn bản trạng thái
    getStatusText(status) {
      switch (status) {
        case 0:
          return "Chờ xác nhận";
        case 1:
          return "Đang vận chuyển";
        case 2:
          return "Hoàn thành";
        case 3:
          return "Đã hủy";
        case 4:
          return "Trả hàng";
        default:
          return "Không xác định";
      }
    },
    // Xem chi tiết hóa đơn
    viewDetail(id) {
      this.$router.push(`/hoa-don/detail/${id}`);
    },
  },
  mounted() {
    this.fetchHoaDon();
  },
};
</script>

<style scoped>
.status-card {
  padding: 0.25rem 0.5rem;
  border-radius: 0.25rem;
}
</style>