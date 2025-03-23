<script setup>

import MasterCard from "@/examples/Cards/MasterCard.vue";
import DefaultInfoCard from "@/examples/Cards/DefaultInfoCard.vue";
// import PaymentCard from "./components/PaymentCard.vue";
// import InvoiceCard from "./components/InvoiceCard.vue";
// import BillingCard from "./components/BillingCard.vue";
// import TransactionCard from "./components/TransactionCard.vue";


import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import api from '@/services/api';

const router = useRouter();
const listHoaDon = ref([]);
const filters = ref({
  maHoaDon: '',
  trangThai: '',
  fromDate: '',
  toDate: '',
});
const currentPage = ref(0);
const size = ref(5);
const totalPages = ref(0);

// Lấy dữ liệu hóa đơn từ API
const fetchHoaDon = async () => {
  try {
    const response = await api.get('/hoa-don/hien-thi', {
      params: {
        page: currentPage.value,
        size: size.value,
        ...filters.value,
      },
    });
    listHoaDon.value = response.data.content || [];
    totalPages.value = response.data.totalPages || 0;
  } catch (error) {
    console.error('Lỗi khi tải dữ liệu hóa đơn:', error);
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
  return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(value);
};

// Định dạng ngày tháng
const formatDate = (date) => {
  return new Date(date).toLocaleDateString('vi-VN');
};

// Lấy class trạng thái
const getStatusClass = (status) => {
  switch (status) {
    case 0:
      return 'bg-warning text-dark';
    case 1:
      return 'bg-info text-dark';
    case 2:
      return 'bg-success';
    case 3:
      return 'bg-danger';
    case 4:
      return 'bg-secondary';
    default:
      return 'bg-dark';
  }
};

// Lấy văn bản trạng thái
const getStatusText = (status) => {
  switch (status) {
    case 0:
      return 'Chờ xác nhận';
    case 1:
      return 'Đang vận chuyển';
    case 2:
      return 'Hoàn thành';
    case 3:
      return 'Đã hủy';
    case 4:
      return 'Trả hàng';
    default:
      return 'Không xác định';
  }
};

// Xem chi tiết hóa đơn
const viewDetail = (id) => {
  router.push(`/hoa-don/detail/${id}`);
};

// Gọi hàm fetch dữ liệu khi component được mounted
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
        <!--        <invoice-card class="mt-4"/>-->
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <!--                 <billing-card />-->
        <div class="bg-white rounded-3 p-3 mb-3"> <!-- Thêm lớp bg-white và rounded-3 -->
          <form @submit.prevent="fetchHoaDon">
            <div class="row">
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
        </div>


      </div>
      <div class="col-md-5">
        <!--        <transaction-card/>-->
      </div>
    </div>
    <div class="col-md-12">
      <div class="col-md-12">
        <div class="bg-white rounded-3 p-3"> <!-- Thêm lớp bg-white và rounded-3 -->
          <h6 class="mb-0">Billing Information</h6>
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
              <span :class="getStatusClass(hd.trangThai)" class="status-card badge">
                {{ getStatusText(hd.trangThai) }}
              </span>
              </td>
              <td>{{ formatDate(hd.ngayTao) }}</td>
              <td>
              <span :class="hd.loaiHoaDon ? 'status-card bg-online' : 'status-card bg-offline'">
                {{ hd.loaiHoaDon ? "Online" : "Tại quầy" }}
              </span>
              </td>
              <td>
                <button class="btn btn-sm btn-outline-primary" @click="viewDetail(hd.id)" title="chi tiết">
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
              <li v-for="pageNum in totalPages" :key="pageNum" class="page-item" :class="{ active: pageNum - 1 === currentPage }">
                <a class="page-link" href="#" @click.prevent="goToPage(pageNum - 1)">
                  {{ pageNum }}
                </a>
              </li>
              <li class="page-item" :class="{ disabled: currentPage + 1 >= totalPages }">
                <a class="page-link" href="#" @click.prevent="nextPage">&gt;</a>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>

/* Thêm vào file CSS của bạn */
.bg-white {
  background-color: white;
}

.rounded-3 {
  border-radius: 0.5rem; /* Bo tròn các góc */
}

.form-control, .form-select {
  border-radius: 0.25rem; /* Bo tròn các góc của input và select */
}

.btn-primary {
  border-radius: 0.25rem; /* Bo tròn các góc của nút */
}

.table-hover tbody tr:hover {
  background-color: #f8f9fa; /* Màu nền khi di chuột qua */
}

.table {
  margin-bottom: 0; /* Loại bỏ margin dưới của bảng */
}

.table thead th {
  background-color: #f8f9fa; /* Màu nền cho header của bảng */
  border-top: 1px solid #dee2e6; /* Đường viền trên cùng */
}

.table tbody td {
  border-top: 1px solid #dee2e6; /* Đường viền trên cùng của mỗi ô */
}

.pagination {
  margin-top: 1rem; /* Khoảng cách giữa bảng và phân trang */
}
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

.status-card {
  padding: 0.25rem 0.5rem;
  border-radius: 0.25rem;
}

.status-card {
  display: inline-block;
  min-width: 100px; /* Đảm bảo độ dài đồng đều */
  text-align: center;
  padding: 4px 8px;
  border-radius: 4px;
  font-size: 14px;
  font-weight: 500;
  opacity: 0.8; /* Làm màu nhạt hơn */
}

/* Màu trạng thái nhạt hơn */
.bg-warning {
  background-color: #fff3cd !important;
  color: #856404 !important;
}

.bg-info {
  background-color: #d1ecf1 !important;
  color: #0c5460 !important;
}

.bg-success {
  background-color: #d4edda !important;
  color: #155724 !important;
}

.bg-danger {
  background-color: #f8d7da !important;
  color: #721c24 !important;
}

.bg-secondary {
  background-color: #e2e3e5 !important;
  color: #383d41 !important;
}

.bg-dark {
  background-color: #d6d8d9 !important;
  color: #1b1e21 !important;
}

/* Loại đơn hàng */
.bg-online {
  background-color: #cce5ff !important; /* Màu xanh nhạt */
  color: #004085 !important;
}

.bg-offline {
  background-color: #e2e3e5 !important; /* Màu xám */
  color: #383d41 !important;
}

</style>

