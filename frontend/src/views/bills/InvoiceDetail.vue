<template>
  <div class="container mt-4">
    <!-- Trạng thái đơn hàng -->
    <div class="card mb-3">
      <div class="card-header">Trạng thái đơn hàng</div>
      <div class="card-body">{{ hoaDon?.trangThai }}</div>
    </div>

    <!-- Thông tin khách hàng -->
    <div class="card mb-3">
      <div class="card-header">Thông tin khách hàng</div>
      <div class="card-body">
        <div class="row">
          <div class="col-md-6">
            <div class="p-3 border rounded bg-white">
              <strong>Tên Khách Hàng</strong>
              <p>{{ hoaDon?.khachHang?.hoTen }}</p>
            </div>
          </div>
          <div class="col-md-6">
            <div class="p-3 border rounded bg-white">
              <strong>Số Điện Thoại</strong>
              <p>{{ hoaDon?.khachHang?.sdt }}</p>
            </div>
          </div>
          <div class="col-md-6 mt-3">
            <div class="p-3 border rounded bg-white">
              <strong>Email</strong>
              <p>{{ hoaDon?.khachHang?.email }}</p>
            </div>
          </div>
          <div class="col-md-6 mt-3">
            <div class="p-3 border rounded bg-white">
              <strong>Địa Chỉ</strong>
              <p>{{ hoaDon?.khachHang?.diaChi }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Chi tiết đơn hàng -->
    <div class="card mb-3">
      <div class="card-header">Chi tiết đơn hàng</div>
      <div class="card-body">
        <div class="row text-center mb-4">
          <div class="col-md-3">
            <div class="p-3 border rounded bg-light">
              <strong>Mã đơn hàng</strong>
              <p class="text-primary fw-bold">{{ hoaDon.maHoaDon }}</p>
            </div>
          </div>
          <div class="col-md-3">
            <div class="p-3 border rounded bg-light">
              <strong>Phí vận chuyển</strong>
              <p class="text-primary fw-bold">{{ hoaDon.phiVanChuyen }} đ</p>
            </div>
          </div>
          <div class="col-md-3">
            <div class="p-3 border rounded bg-light">
              <strong>Giảm giá</strong>
              <p class="text-primary fw-bold">{{ hoaDon.soTienGiam }} %</p>
            </div>
          </div>
          <div class="col-md-3">
            <div class="p-3 border rounded bg-light">
              <strong>Tổng tiền</strong>
              <p class="text-primary fw-bold">{{ hoaDon.tongTien }} đ</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Lịch sử thanh toán -->
    <div class="card mb-3">
      <div class="card-header">Lịch sử thanh toán</div>
      <div class="card-body">
        <table class="table table-bordered">
          <thead>
          <tr>
            <th>#</th>
            <th>Mã giao dịch</th>
            <th>Số tiền thanh toán</th>
            <th>Thời gian</th>
            <th>Phương thức thanh toán</th>
            <th>Loại giao dịch</th>
            <th>Nhân viên tiếp nhận</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(lshdDto, index) in listLichSuHoaDonDto" :key="index">
            <td>{{ index + 1 }}</td>
            <td>{{ lshdDto.maGiaoDich }}</td>
            <td>{{ lshdDto.tongTien }} VND</td>
            <td>{{ formatDate(lshdDto.ngayThanhToan) }}</td>
            <td>{{ lshdDto.tenHinhThuc }}</td>
            <td :class="lshdDto.trangThai ? 'text-success' : 'text-danger'">
              {{ lshdDto.trangThai ? 'Đã thanh toán' : 'Chưa thanh toán' }}
            </td>
            <td>{{ lshdDto.hoTen }}</td>
          </tr>
          </tbody>
        </table>
        <p v-if="listLichSuHoaDonDto.length === 0" class="text-center">Không có lịch sử thanh toán.</p>
      </div>
    </div>

    <!-- Danh sách sản phẩm -->
    <div class="card mb-3">
      <div class="card-header">Danh sách sản phẩm
        <button class="btn btn-primary btn-sm float-end" @click="openAddProductModal">Thêm sản phẩm</button>
      </div>
      <div class="card-body">
        <table class="table table-bordered">
          <thead>
          <tr>
            <th><strong>#</strong></th>
            <th><strong>Ảnh</strong></th>
            <th><strong>Sản phẩm</strong></th>
            <th><strong>Số lượng</strong></th>
            <th><strong>Tổng tiền</strong></th>
            <th><strong>Hành động</strong></th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(sanPham, index) in listDanhSachSanPham" :key="index">
            <td>{{ index + 1 }}</td>
            <td>
              <img :src="sanPham.maAnh" alt="Ảnh sản phẩm" width="50" height="50">
            </td>
            <td>
              <h5>{{ sanPham.tenChiTietSp }}</h5>
              <p>Mã SP: {{ sanPham.maChiTietSp }}</p>
              <p>Đơn giá: {{ formatCurrency(sanPham.donGia) }} đ</p>
            </td>
            <td>
              <div class="product-actions">
                <button class="btn btn-secondary" @click="decreaseQuantity(sanPham)">-</button>
                <span>{{ sanPham.soLuong }}</span>
                <button class="btn btn-secondary" @click="increaseQuantity(sanPham)">+</button>
              </div>
            </td>
            <td>{{ formatCurrency(sanPham.donGia * sanPham.soLuong) }} đ</td>
            <td>
              <button class="btn btn-danger btn-sm" @click="removeProduct(sanPham)">Xóa</button>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>

    <!-- Modal chọn sản phẩm -->
    <div class="modal fade" id="addProductModal" tabindex="-1">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Chọn sản phẩm</h5>
            <button type="button" class="btn-close" @click="closeAddProductModal"></button>
          </div>
          <div class="modal-body">
            <ul class="list-group">
              <li class="list-group-item" v-for="product in availableProducts" :key="product.id">
                <span>{{ product.name }}</span>
                <button class="btn btn-sm btn-success float-end" @click="openQuantityModal(product)">Chọn</button>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <!-- Modal nhập số lượng -->
    <div class="modal fade" id="quantityModal" tabindex="-1">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Nhập số lượng</h5>
            <button type="button" class="btn-close" @click="closeQuantityModal"></button>
          </div>
          <div class="modal-body">
            <label for="quantity">Số lượng:</label>
            <input type="number" id="quantity" class="form-control" min="1" v-model="selectedQuantity">
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-danger" @click="closeQuantityModal">Hủy</button>
            <button type="button" class="btn btn-primary" @click="confirmQuantity">Xác nhận</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>


<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import api from '@/services/api';

// Khai báo các biến reactive
const route = useRoute();
const hoaDon = ref({});
const listLichSuHoaDonDto = ref([]);
const listDanhSachSanPham = ref([]);
const availableProducts = ref([]);
const selectedProduct = ref(null);
const selectedQuantity = ref(1);

// Hàm fetch chi tiết hóa đơn
const fetchHoaDonDetail = async () => {
  try {
    const response = await api.get(`/hoa-don/detail/${route.params.id}`);
    hoaDon.value = response.data;
    listLichSuHoaDonDto.value = response.data.listLichSuHoaDonDto || [];
    listDanhSachSanPham.value = response.data.listDanhSachSanPham || [];
  } catch (error) {
    console.error('Lỗi khi tải chi tiết hóa đơn:', error);
  }
};

// Hàm fetch sản phẩm có sẵn
const fetchAvailableProducts = async () => {
  try {
    const response = await api.get('/san-pham/available');
    availableProducts.value = response.data || [];
  } catch (error) {
    console.error('Lỗi khi tải sản phẩm có sẵn:', error);
  }
};

// Hàm mở modal thêm sản phẩm
const openAddProductModal = () => {
  // Logic để mở modal thêm sản phẩm
};

// Hàm đóng modal thêm sản phẩm
const closeAddProductModal = () => {
  // Logic để đóng modal thêm sản phẩm
};

// Hàm mở modal nhập số lượng
const openQuantityModal = (product) => {
  selectedProduct.value = product;
  // Logic để mở modal nhập số lượng
};

// Hàm đóng modal nhập số lượng
const closeQuantityModal = () => {
  selectedProduct.value = null;
  selectedQuantity.value = 1;
  // Logic để đóng modal nhập số lượng
};

// Hàm xác nhận số lượng
const confirmQuantity = () => {
  // Logic để xác nhận số lượng và thêm sản phẩm vào hóa đơn
};

// Hàm tăng số lượng sản phẩm
const increaseQuantity = (product) => {
  product.soLuong++;
};

// Hàm giảm số lượng sản phẩm
const decreaseQuantity = (product) => {
  if (product.soLuong > 1) {
    product.soLuong--;
  }
};

// Hàm xóa sản phẩm
const removeProduct = (product) => {
  listDanhSachSanPham.value = listDanhSachSanPham.value.filter(p => p.id !== product.id);
};

// Hàm định dạng tiền tệ
const formatCurrency = (value) => {
  return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(value);
};

// Hàm định dạng ngày tháng
const formatDate = (date) => {
  return new Date(date).toLocaleDateString('vi-VN');
};

// Gọi hàm fetch dữ liệu khi component được mounted
onMounted(() => {
  fetchHoaDonDetail();
  fetchAvailableProducts();
});
</script>

<style scoped>
/* CSS styles từ file Thymeleaf */
</style>


<style scoped>
/* CSS chung */
body {
  font-family: Arial, sans-serif;
  background-color: #f8f9fa;
  padding: 20px;
}

.card {
  border: 1px solid #ddd;
  border-radius: 8px;
  margin-bottom: 20px;
  background-color: #fff;
}

.card-header {
  background-color: #2DCE89;
  color: #fff;
  padding: 10px 15px;
  border-top-left-radius: 8px;
  border-top-right-radius: 8px;
  font-size: 18px;
  font-weight: bold;
}

.card-body {
  padding: 15px;
}

.table {
  width: 100%;
  margin-bottom: 0;
  border-collapse: collapse;
}

.table-bordered {
  border: 1px solid #ddd;
}

.table-bordered th,
.table-bordered td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

.table thead th {
  background-color: #f8f9fa;
  font-weight: bold;
}

p {
  margin: 0 0 10px;
}

strong {
  font-weight: bold;
}

.product-actions {
  display: flex;
  align-items: center;
  gap: 10px;
}

.product-actions .btn {
  padding: 5px 10px;
}

.trang-thai-thanh-toan {
  font-weight: bold;
  padding: 5px;
  border-radius: 5px;
}

.da-thanh-toan {
  color: #28a745; /* Màu xanh */
  background-color: #d4edda;
}

.chua-thanh-toan {
  color: #dc3545; /* Màu đỏ */
  background-color: #f8d7da;
}
</style>