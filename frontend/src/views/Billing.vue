<script setup>
import MasterCard from "@/examples/Cards/MasterCard.vue";
import DefaultInfoCard from "@/examples/Cards/DefaultInfoCard.vue";
// import PaymentCard from "./components/PaymentCard.vue";
import InvoiceCard from "./components/InvoiceCard.vue";
// import BillingCard from "./components/BillingCard.vue";
import TransactionCard from "./components/TransactionCard.vue";


import api from "@/services/api";

import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";


const router = useRouter();
const listHoaDon = ref([]); // Danh sách hóa đơn
const filters = ref({
  maHoaDon: "",
  trangThai: "",
  fromDate: "",
  toDate: "",
});
const currentPage = ref(0); // Trang hiện tại
const size = ref(5); // Số lượng bản ghi mỗi trang
const totalPages = ref(0); // Tổng số trang

// Lấy dữ liệu hóa đơn từ API
const fetchHoaDon = async () => {
  try {
    const response = await api.get("/hoa-don/hien-thi", {
      params: {
        page: currentPage.value,
        size: size.value,
        ...filters.value,
      },
    });
    listHoaDon.value = response.data.content;
    totalPages.value = response.data.totalPages;
  } catch (error) {
    console.error("Lỗi khi tải dữ liệu hóa đơn:", error);
  }
};

// Chuyển đến trang trước
const prevPage = () => {
  if (currentPage.value > 0) {
    currentPage.value--;
    fetchHoaDon();
  }
};

// Chuyển đến trang tiếp theo
const nextPage = () => {
  if (currentPage.value + 1 < totalPages.value) {
    currentPage.value++;
    fetchHoaDon();
  }
};

// Chuyển đến trang cụ thể
const goToPage = (pageNum) => {
  currentPage.value = pageNum;
  fetchHoaDon();
};

// Định dạng tiền tệ
const formatCurrency = (value) => {
  return new Intl.NumberFormat("vi-VN", {
    style: "currency",
    currency: "VND",
  }).format(value);
};

// Định dạng ngày tháng
const formatDate = (date) => {
  return new Date(date).toLocaleDateString("vi-VN");
};

// Lấy class trạng thái
const getStatusClass = (status) => {
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
};

// Lấy văn bản trạng thái
const getStatusText = (status) => {
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
};

// Xem chi tiết hóa đơn
const viewDetail = (id) => {
  router.push(`/hoa-don/detail/${id}`);
};

onMounted(fetchHoaDon);
</script>
<template>
  <div class="container-fluid">
    <div class="row">
      <div class="col-lg-8">
        <div class="row mt-4">
          <div class="col-xl-6 mb-xl-0 mb-4">
            <master-card/>
          </div>
          <div class="col-xl-6">
            <div class="row">
              <div class="col-md-6">
                <default-info-card
                    :icon="{
                    component: 'fas fa-landmark',
                    background: 'bg-gradient-success',
                  }"
                    title="Salary"
                    description="Belong Interactive"
                    value="+$2000"
                />
              </div>
              <div class="col-md-6">
                <default-info-card
                    :icon="{
                    component: 'fab fa-paypal',
                    background: 'bg-gradient-success',
                  }"
                    title="Paypal"
                    description="Freelance Payment"
                    value="$455.00"
                />
              </div>

            </div>
          </div>
          <div class="col-md-12 mb-4">
            <!--             <payment-card />-->
          </div>
        </div>
      </div>
      <div class="col-lg-4">
        <invoice-card class="mt-4"/>
      </div>
    </div>
    <div class="row">
      <div class="col-md-7">
        <!--         <billing-card />-->
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
              <input type="date" class="form-control" v-model="filters.fromDate"/>
            </div>
            <div class="col-md-3">
              <input type="date" class="form-control" v-model="filters.toDate"/>
            </div>
            <div class="col-md-1">
              <button type="submit" class="btn btn-primary w-100">Tìm kiếm</button>
            </div>
          </div>
        </form>
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
      <div class="col-md-5">
        <transaction-card/>
      </div>
    </div>
    <div class="col-md-5">
      <div class="col-md-6">
        <div>
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
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin: 10px 0;
}

button {
  margin: 0 5px;
}
</style>

