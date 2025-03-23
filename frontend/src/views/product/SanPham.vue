<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-md-12">
        <div class="card custom-card">
          <div class="card custom-card">
            <div class="card-header custom-card-header text-center">
              <h1 class="mb-0">QUẢN LÝ SẢN PHẨM</h1>
            </div>
            <div class="card-body custom-card-body">
              <div class="mb-4">
                <label for="search" class="font-weight-bold">Tên sản phẩm</label>
                <div class="d-flex align-items-center">
                  <div class="input-group custom-input-group mb-3" style="max-width: 600px;">
                    <input id="search" type="text" class="form-control"
                           placeholder="Tìm kiếm sản phẩm theo tên..."
                           style="border: 1px solid black; border-radius: 5px;">
                  </div>
                  <button class="btn btn-purple ml-2 mb-3"><i
                      class="fas fa-plus"></i> Thêm sản phẩm
                  </button>
                </div>
              </div>
              <div class="bg-light p-3 rounded mb-4">
                <div class="form-row align-items-center">
                  <div class="col-md-6">
                    <label class="mr-2">Trạng thái</label>
                    <div class="w-100"></div> <!-- Line break -->
                    <div class="form-check form-check-inline">
                      <input class="form-check-input" type="radio" name="status" id="statusAll"
                             style="margin: 0 0 0 3px" checked>
                      <label class="form-check-label" for="statusAll">Tất cả</label>
                    </div>
                    <div class="form-check form-check-inline">
                      <input class="form-check-input" type="radio" name="status" id="statusActive"
                             style="margin: 0 0 0 3px">
                      <label class="form-check-label" for="statusActive">Đang bán</label>
                    </div>
                    <div class="form-check form-check-inline">
                      <input class="form-check-input" type="radio" name="status" id="statusInactive"
                             style="margin: 0 0 0 3px">
                      <label class="form-check-label" for="statusInactive">Ngừng bán</label>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <label class="mr-2">Danh mục</label>
                    <div class="w-100"></div> <!-- Line break -->
                    <select class="form-control custom-select" style="width: 100%;">
                      <option>Chọn danh mục...</option>
                    </select>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="card-body custom-card-body" style="background-color: rgb(255, 255, 255);">
            <div class="table-responsive">
              <table class="table table-bordered text-center">
                <thead class="thead-light">
                <tr>
                  <th>#</th>
                  <th>Mã</th>
                  <th>Tên</th>
                  <th>Số lượng</th>
                  <th>Danh mục</th>
                  <th>Trạng thái</th>
                  <th>Hành động</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="(sanPham, index) in paginatedSanPham" :key="sanPham.id">
                  <td>{{ (currentPage - 1) * pageSize + index + 1 }}</td>
                  <td>{{ sanPham.maSp }}</td>
                  <td>{{ sanPham.tenSp }}</td>
                  <td>{{ sanPham.soLuong }}</td>
                  <td>{{ sanPham?.danhMuc?.tenDanhMuc }}</td>
                  <td>
                    <span :class="sanPham.trangThai ? 'text-success' : 'text-danger'">
                      {{ sanPham.trangThai ? 'Đang bán' : 'Ngừng bán' }}
                    </span>
                  </td>
                  <td>
                    <button class="btn btn-success btn-sm mx-1">
                      <i class="fas fa-edit"></i>
                    </button>
                    <button class="btn btn-outline-danger btn-sm mx-1">
                      <i class="fas fa-trash"></i>
                    </button>
                  </td>

                </tr>
                </tbody>
              </table>
            </div>

            <!-- Phân trang -->
            <nav>
              <ul class="pagination">
                <li class="page-item" :class="{ disabled: currentPage === 1 }">
                  <button class="page-link" @click="changePage(currentPage - 1)">&#60;</button>
                </li>
                <li v-for="page in totalPages" :key="page" class="page-item" :class="{ active: page === currentPage }">
                  <button class="page-link" @click="changePage(page)">{{ page }}</button>
                </li>
                <li class="page-item" :class="{ disabled: currentPage === totalPages }">
                  <button class="page-link" @click="changePage(currentPage + 1)">&#62;</button>
                </li>
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<style scoped>
.card-body{
  background-color: white;
  border-radius: 0;
}

.custom-card-body{
  background-color: white;
  border-radius: 0;
}
/* Ô tìm kiếm */
.custom-input-group input {
  border: 1px solid #2ecc71; /* Xanh lá */
  border-radius: 5px;
  padding: 6px;
  transition: 0.3s;
}

.custom-input-group input:focus {
  border-color: #27ae60;
  box-shadow: 0 0 5px rgba(39, 174, 96, 0.5);
}

/* Nút Thêm sản phẩm */
.btn-purple {
  background-color: #27ae60; /* Xanh lá */
  color: white;
  border-radius: 5px;
  padding: 8px 15px;
  transition: 0.3s;
  margin-left: 50px;
}

.btn-purple:hover {
  background-color: #219150;
}

/* Bộ lọc trạng thái & danh mục */
.bg-light {
  background-color: #eafaf1 !important; /* Xanh lá nhạt */
  padding: 15px;
  border-radius: 8px;
}

/* Căn chỉnh trạng thái và danh mục thẳng hàng */
.form-row {
  display: flex;
  align-items: center; /* Căn giữa theo chiều dọc */
  justify-content: space-between;
}

/* Radio button */
.form-check-input {
  accent-color: #2ecc71; /* Xanh lá */
}

/* Dropdown danh mục */
.custom-select {
  border: 1px solid #2ecc71;
  border-radius: 5px;
  padding: 8px;
  transition: 0.3s;
  width: 100%;
}

.custom-select:focus {
  border-color: #27ae60;
  box-shadow: 0 0 5px rgba(39, 174, 96, 0.5);
}

/* Đảm bảo radio button không bị lệch */
.form-check-inline {
  margin-right: 10px;
}

/* Bảng chung */
.table {
  width: 100%;
  border-collapse: collapse;
  background-color: #fff;
  border-radius: 8px; /* Bo góc bảng */
  overflow: hidden;
  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1); /* Đổ bóng nhẹ */
}

/* Header */
.thead-light {
  background-color: #2ecc71; /* Xanh lá đậm */
  color: white;
  font-weight: bold;
}

/* Dòng kẻ */
.table-bordered th,
.table-bordered td {
  border: 1px solid #ddd;
  padding: 10px;
  text-align: center;
}

/* Hàng xen kẽ */
.table tbody tr:nth-child(odd) {
  background-color: #eafaf1; /* Xanh lá cây nhạt */
}

/* Hover */
.table tbody tr:hover {
  background-color: rgba(46, 204, 113, 0.2);
  transition: background 0.3s ease-in-out;
}

/* Nút hành động */
.btn-success {
  background-color: #27ae60;
  border-color: #27ae60;
  color: white;
  transition: 0.3s;
}

.btn-success:hover {
  background-color: #219150;
}

.btn-outline-danger {
  border-color: #e74c3c;
  color: #e74c3c;
  transition: 0.3s;
}

.btn-outline-danger:hover {
  background-color: #e74c3c;
  color: white;
}

.custom-card-header {
  border-top-left-radius: 1rem;
  border-top-right-radius: 1rem;
}

.custom-input-group input {
  border: 1px solid #ced4da;
  box-shadow: none;
}

.custom-input-group .input-group-append .btn {
  border: none;
  background-color: #6f42c1;
  color: white;
}

.pagination {
  display: flex;
  justify-content: flex-end; /* Căn phải */
  align-items: center;
  font-size: 14px; /* Giảm kích thước chữ */
  padding-right: 10px;
}

.pagination .page-item .page-link {
  width: 30px; /* Giảm kích thước nút */
  height: 30px;
  font-size: 12px; /* Giảm font chữ */
  line-height: 28px;
}

.pagination .page-item.active .page-link {
  background-color: rgba(0, 128, 0, 0.1); /* Xanh lá cây nhạt */
  border: 1px solid rgba(0, 128, 0, 0.3); /* Viền xanh */
  color: #008000;
  /* Màu chữ xanh lá cây *
 }

 .pagination .page-item .page-link:hover {
   background-color: rgba(0, 128, 0, 0.6); /* Xanh lá cây đậm hơn */
}

/* Chỉnh nút Previous và Next */
.pagination .page-item.prev .page-link,
.pagination .page-item.next .page-link {
  font-size: 18px; /* Làm lớn biểu tượng */
  font-weight: bold;
}

.pagination {
  margin-right: 60px;
}

</style>

<script>
import axios from "axios";

export default {
  name: "SanPham",
  data() {
    return {
      sanPhamList: [],
      currentPage: 1,
      pageSize: 5,
      loading: true,
      error: "",
    };
  },
  computed: {
    totalPages() {
      return Math.ceil(this.sanPhamList.length / this.pageSize);
    },
    paginatedSanPham() {
      const start = (this.currentPage - 1) * this.pageSize;
      return this.sanPhamList.slice(start, start + this.pageSize);
    },
  },
  methods: {
    async fetchSanPham() {
      try {
        const response = await axios.get("http://localhost:8080/api/san-pham/all");
        if (Array.isArray(response.data)) {
          this.sanPhamList = response.data;
        } else {
          console.error("Dữ liệu API không hợp lệ");
          this.error = "Dữ liệu sản phẩm không hợp lệ!";
        }
      } catch (error) {
        console.error("Lỗi khi lấy sản phẩm:", error);
        this.error = "Không thể tải sản phẩm!";
      } finally {
        this.loading = false;
      }
    },
    changePage(page) {
      if (page > 0 && page <= this.totalPages) {
        this.currentPage = page;
      }
    },
  },
  mounted() {
    this.fetchSanPham();
  },
};
</script>