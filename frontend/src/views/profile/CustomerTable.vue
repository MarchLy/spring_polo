<!--<template>-->
<!--  <div class="customer-table">-->
<!--    <div class="table-header">-->
<!--      <h3><i class="fas fa-users"></i> Danh sách khách hàng</h3>-->
<!--      <button class="btn btn-primary" @click="addCustomer">+ Thêm</button>-->
<!--    </div>-->

<!--    <table class="table table-striped">-->
<!--      <thead>-->
<!--      <tr>-->
<!--        <th>STT</th>-->
<!--        <th>Ảnh</th>-->
<!--        <th>Tên khách hàng</th>-->
<!--        <th>Email</th>-->
<!--        <th>Số điện thoại</th>-->
<!--        <th>Ngày sinh</th>-->
<!--        <th>Trạng thái</th>-->
<!--        <th>Hành động</th>-->
<!--      </tr>-->
<!--      </thead>-->
<!--      <tbody>-->
<!--      <tr v-for="(customer, index) in customers" :key="customer.id">-->
<!--        <td>{{ (currentPage - 1) * pageSize + index + 1 }}</td>-->
<!--        <td>-->
<!--          <img :src="customer.hinhAnh || defaultAvatar" alt="Avatar" class="avatar">-->
<!--        </td>-->
<!--        <td>{{ customer.hoTen }}</td>-->
<!--        <td>{{ customer.email }}</td>-->
<!--        <td>{{ customer.sdt }}</td>-->
<!--        <td>{{ formatDate(customer.ngaySinh) }}</td>-->
<!--        <td>-->
<!--            <span :class="getStatusClass(customer.trangThai)">-->
<!--              {{ customer.trangThai === 'ACTIVE' ? 'Kích hoạt' : 'Tạm khóa' }}-->
<!--            </span>-->
<!--        </td>-->
<!--        <td>-->
<!--          <button class="btn btn-success m-1" @click="viewCustomer(customer.id)">-->
<!--            <i class="fas fa-eye"></i>-->
<!--          </button>-->
<!--          <button class="btn btn-warning m-1" @click="editCustomer(customer.id)">-->
<!--            <i class="fas fa-edit"></i>-->
<!--          </button>-->
<!--          <button class="btn btn-danger m-1" @click="confirmDelete(customer.id)">-->
<!--            <i class="fas fa-trash"></i>-->
<!--          </button>-->
<!--        </td>-->
<!--      </tr>-->
<!--      </tbody>-->
<!--    </table>-->

<!--    <div class="pagination">-->
<!--      <button-->
<!--          :disabled="currentPage === 1"-->
<!--          @click="changePage(currentPage - 1)"-->
<!--          class="pagination-btn"-->
<!--      >-->
<!--        &laquo; Trước-->
<!--      </button>-->

<!--      <span class="pagination-info">{{ currentPage }} / {{ totalPages }}</span>-->

<!--      <button-->
<!--          :disabled="currentPage === totalPages"-->
<!--          @click="changePage(currentPage + 1)"-->
<!--          class="pagination-btn"-->
<!--      >-->
<!--        Tiếp &raquo;-->
<!--      </button>-->
<!--    </div>-->

<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import { computed, onMounted } from "vue";-->
<!--import { useStore } from "vuex";-->
<!--import { useRouter } from "vue-router";-->

<!--export default {-->
<!--  setup() {-->
<!--    const store = useStore();-->
<!--    const router = useRouter();-->

<!--    const defaultAvatar = "https://via.placeholder.com/50";-->
<!--    const pageSize = 5; // 🔹 Số khách hàng mỗi trang-->

<!--    // Lấy dữ liệu từ Vuex-->
<!--    const customers = computed(() => store.getters["customer/customers"]);-->
<!--    const totalPages = computed(() => store.getters["customer/totalPages"]);-->
<!--    const currentPage = computed(() => store.getters["customer/currentPage"]);-->

<!--    // 🔹 Kiểm tra dữ liệu Vuex-->
<!--    console.log("📌 Total Pages:", totalPages.value);-->
<!--    console.log("📌 Current Page:", currentPage.value);-->

<!--    // Tải danh sách khách hàng khi component được mount-->
<!--    onMounted(() => {-->
<!--      console.log("📌 Fetching customer list...");-->
<!--      store.dispatch("customer/fetchCustomers", 1);-->
<!--    });-->

<!--    const formatDate = (dateString) => {-->
<!--      if (!dateString) return "N/A";-->
<!--      return new Date(dateString).toLocaleDateString("vi-VN", {-->
<!--        year: "numeric",-->
<!--        month: "2-digit",-->
<!--        day: "2-digit",-->
<!--      });-->
<!--    };-->

<!--    const getStatusClass = (status) => {-->
<!--      return status === "ACTIVE" ? "status-active" : "status-inactive";-->
<!--    };-->

<!--    const changePage = (page) => {-->
<!--      console.log("🔹 Đổi sang trang:", page, " / Tổng số trang:", totalPages.value);-->
<!--      if (page >= 1 && page <= totalPages.value) {-->
<!--        store.dispatch("customer/fetchCustomers", page);-->
<!--      } else {-->
<!--        console.warn("⚠️ Trang không hợp lệ:", page);-->
<!--      }-->
<!--    };-->

<!--    const addCustomer = () => {-->
<!--      router.push({ name: "AddOrEdit", params: { id: "new" } });-->
<!--    };-->

<!--    const editCustomer = (customerId) => {-->
<!--      router.push({ name: "AddOrEdit", params: { id: customerId } });-->
<!--    };-->

<!--    const confirmDelete = (id) => {-->
<!--      if (confirm("Bạn có chắc chắn muốn xóa khách hàng này không?")) {-->
<!--        store.dispatch("customer/deleteCustomer", id).then(() => {-->
<!--          console.log("📌 Xóa thành công, tải lại danh sách...");-->
<!--          store.dispatch("customer/fetchCustomers", currentPage.value);-->
<!--        });-->
<!--      }-->
<!--    };-->

<!--    const viewCustomer = (id) => {-->
<!--      console.log("🔵 Xem chi tiết khách hàng ID:", id);-->
<!--    };-->

<!--    return {-->
<!--      defaultAvatar,-->
<!--      customers,-->
<!--      totalPages,-->
<!--      currentPage,-->
<!--      pageSize,-->
<!--      formatDate,-->
<!--      getStatusClass,-->
<!--      changePage,-->
<!--      addCustomer,-->
<!--      editCustomer,-->
<!--      confirmDelete,-->
<!--      viewCustomer,-->
<!--    };-->
<!--  },-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.customer-table {-->
<!--  width: 100%;-->
<!--  padding: 20px;-->
<!--  background: #fff;-->
<!--  border-radius: 8px;-->
<!--  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);-->
<!--}-->

<!--.table-header {-->
<!--  display: flex;-->
<!--  justify-content: space-between;-->
<!--  align-items: center;-->
<!--  margin-bottom: 15px;-->
<!--}-->

<!--.table {-->
<!--  width: 100%;-->
<!--  border-collapse: collapse;-->
<!--}-->

<!--.table th, .table td {-->
<!--  padding: 10px;-->
<!--  text-align: left;-->
<!--  border-bottom: 1px solid #ddd;-->
<!--}-->

<!--.table th {-->
<!--  background: #f4f4f4;-->
<!--}-->

<!--.avatar {-->
<!--  width: 50px;-->
<!--  height: 50px;-->
<!--  border-radius: 50%;-->
<!--}-->

<!--.status-active {-->
<!--  color: green;-->
<!--  font-weight: bold;-->
<!--}-->

<!--.status-inactive {-->
<!--  color: red;-->
<!--  font-weight: bold;-->
<!--}-->

<!--.pagination {-->
<!--  display: flex;-->
<!--  justify-content: center;-->
<!--  align-items: center;-->
<!--  gap: 10px;-->
<!--  margin-top: 20px;-->
<!--}-->

<!--.pagination-btn {-->
<!--  background-color: #3498db;-->
<!--  color: white;-->
<!--  border: none;-->
<!--  padding: 8px 15px;-->
<!--  border-radius: 5px;-->
<!--  cursor: pointer;-->
<!--  font-size: 14px;-->
<!--  transition: 0.3s;-->
<!--}-->

<!--.pagination-btn:hover {-->
<!--  background-color: #2980b9;-->
<!--}-->

<!--.pagination-btn:disabled {-->
<!--  background-color: #bdc3c7;-->
<!--  cursor: not-allowed;-->
<!--}-->

<!--.pagination-info {-->
<!--  font-weight: bold;-->
<!--  font-size: 16px;-->
<!--}-->
<!--</style>-->