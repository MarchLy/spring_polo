<!--<template>-->
<!--  <div class="container mt-4">-->
<!--    <div class="row">-->
<!--      &lt;!&ndash; Cột ảnh đại diện &ndash;&gt;-->
<!--      <div class=" card shadow col-md-4 d-flex flex-column align-items-center">-->
<!--        <h3 class="mb-3 mt-3"><b>Ảnh đại diện</b></h3>-->
<!--        <div class="avatar-container">-->
<!--          <img :src="khachHang.hinhAnh || defaultAvatar" class="rounded-circle img-thumbnail" width="200pz" height="200px" />-->
<!--        </div>-->
<!--        <input type="file" class="form-control mt-3" @change="uploadImage" />-->
<!--      </div>-->

<!--      &lt;!&ndash; Cột form nhập liệu &ndash;&gt;-->
<!--      <div class="col-md-8">-->
<!--        <div class="card shadow p-4">-->
<!--          <h3 class="text-center">{{ isEdit ? "Cập Nhật" : "Thêm" }} Khách Hàng</h3>-->
<!--          <form v-if="khachHang" @submit.prevent="saveKhachHang">-->
<!--            <div class="row g-3">-->
<!--              &lt;!&ndash; Họ tên &ndash;&gt;-->
<!--              <div class="col-md-6">-->
<!--                <label class="form-label">Họ Tên *</label>-->
<!--                <input type="text" v-model="khachHang.hoTen" class="form-control" required />-->
<!--              </div>-->

<!--              &lt;!&ndash; Số điện thoại &ndash;&gt;-->
<!--              <div class="col-md-6">-->
<!--                <label class="form-label">Số điện thoại *</label>-->
<!--                <input type="text" v-model="khachHang.sdt" class="form-control" required />-->
<!--              </div>-->

<!--              &lt;!&ndash; Email &ndash;&gt;-->
<!--              <div class="col-md-6">-->
<!--                <label class="form-label">Email *</label>-->
<!--                <input type="email" v-model="khachHang.email" class="form-control" required />-->
<!--              </div>-->

<!--              &lt;!&ndash; Ngày sinh &ndash;&gt;-->
<!--              <div class="col-md-6">-->
<!--                <label class="form-label">Ngày sinh *</label>-->
<!--                <input type="date" v-model="khachHang.ngaySinh" class="form-control" required />-->
<!--              </div>-->

<!--              &lt;!&ndash; Giới tính &ndash;&gt;-->
<!--              <div class="col-md-6">-->
<!--                <label class="form-label">Giới tính *</label>-->
<!--                <div class="d-flex">-->
<!--                  <div class="form-check me-3">-->
<!--                    <input class="form-check-input" type="radio" v-model="khachHang.gioiTinh" value="Nam" id="male" />-->
<!--                    <label class="form-check-label" for="male">Nam</label>-->
<!--                  </div>-->
<!--                  <div class="form-check">-->
<!--                    <input class="form-check-input" type="radio" v-model="khachHang.gioiTinh" value="Nữ" id="female" />-->
<!--                    <label class="form-check-label" for="female">Nữ</label>-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->

<!--              &lt;!&ndash; Địa chỉ &ndash;&gt;-->
<!--              <div class="col-md-6">-->
<!--                <label class="form-label">Tỉnh/Thành phố *</label>-->
<!--                <select v-model="khachHang.tinhThanh" class="form-select" @change="loadQuanHuyen">-->
<!--                  <option v-for="tinh in tinhThanhOptions" :key="tinh.value" :value="tinh.value">-->
<!--                    {{ tinh.text }}-->
<!--                  </option>-->
<!--                </select>-->
<!--              </div>-->

<!--              <div class="col-md-6">-->
<!--                <label class="form-label">Quận/Huyện *</label>-->
<!--                <select v-model="khachHang.quanHuyen" class="form-select" @change="loadXaPhuong">-->
<!--                  <option v-for="quan in quanHuyenOptions" :key="quan.value" :value="quan.value">-->
<!--                    {{ quan.text }}-->
<!--                  </option>-->
<!--                </select>-->
<!--              </div>-->

<!--              <div class="col-md-6">-->
<!--                <label class="form-label">Xã/Phường *</label>-->
<!--                <select v-model="khachHang.xaPhuong" class="form-select">-->
<!--                  <option v-for="xa in xaPhuongOptions" :key="xa.value" :value="xa.value">-->
<!--                    {{ xa.text }}-->
<!--                  </option>-->
<!--                </select>-->
<!--              </div>-->

<!--              <div class="col-md-6">-->
<!--                <label class="form-label">Số nhà/Ngõ/Đường *</label>-->
<!--                <input type="text" v-model="khachHang.soNha" class="form-control" required />-->
<!--              </div>-->

<!--              &lt;!&ndash; Trạng thái &ndash;&gt;-->
<!--              <div class="col-md-6">-->
<!--                <label class="form-label">Trạng thái *</label>-->
<!--                <select v-model="khachHang.trangThai" class="form-select">-->
<!--                  <option value="Kích hoạt">Kích hoạt</option>-->
<!--                  <option value="Tạm ngừng">Tạm ngừng</option>-->
<!--                </select>-->
<!--              </div>-->
<!--            </div>-->

<!--            &lt;!&ndash; Nút hành động &ndash;&gt;-->
<!--            <div class="d-flex justify-content-end mt-4">-->
<!--              <button type="submit" class="btn btn-primary me-2">-->
<!--                {{ isEdit ? "Cập Nhật" : "Thêm" }}-->
<!--              </button>-->
<!--              <button type="button" class="btn btn-secondary" @click="cancel">Hủy</button>-->
<!--            </div>-->
<!--          </form>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->


<!--<script>-->
<!--import { computed, ref, onMounted, watch } from "vue";-->
<!--import { useStore } from "vuex";-->
<!--import { useRoute, useRouter } from "vue-router";-->

<!--export default {-->
<!--  setup() {-->
<!--    const store = useStore();-->
<!--    const route = useRoute();-->
<!--    const router = useRouter();-->

<!--    // Khởi tạo state khách hàng-->
<!--    const khachHang = ref({-->
<!--      hoTen: "",-->
<!--      email: "",-->
<!--      sdt: "",-->
<!--      cccd: "",-->
<!--      ngaySinh: "",-->
<!--      gioiTinh: "",-->
<!--      tinhThanh: "",-->
<!--      quanHuyen: "",-->
<!--      xaPhuong: "",-->
<!--      soNha: "",-->
<!--      trangThai: "Kích hoạt",-->
<!--    });-->

<!--    // Lấy danh sách tỉnh/thành phố từ Vuex-->
<!--    const tinhThanhOptions = computed(() => {-->
<!--      return store.state.location.tinhThanhList.map((tinh) => ({-->
<!--        value: tinh.value,-->
<!--        text: tinh.text,-->
<!--      }));-->
<!--    });-->

<!--    // Danh sách quận/huyện và xã/phường-->
<!--    const quanHuyenOptions = ref([]);-->
<!--    const xaPhuongOptions = ref([]);-->
<!--    // Kiểm tra chế độ chỉnh sửa hay thêm mới-->
<!--    const isEdit = computed(() => route.params.id !== "new");-->

<!--    // Tải dữ liệu khách hàng khi ở chế độ sửa-->
<!--    const fetchKhachHang = async () => {-->
<!--      try {-->
<!--        const response = await fetch(`http://localhost:8080/api/khach-hang/${route.params.id}`);-->
<!--        khachHang.value = await response.json();-->

<!--        // Nếu có dữ liệu tỉnh/thành phố, tải quận/huyện và xã/phường tương ứng-->
<!--        if (khachHang.value.tinhThanh) {-->
<!--          loadQuanHuyen();-->
<!--        }-->
<!--        if (khachHang.value.quanHuyen) {-->
<!--          loadXaPhuong();-->
<!--        }-->
<!--      } catch (error) {-->
<!--        console.error("Lỗi khi lấy dữ liệu khách hàng:", error);-->
<!--      }-->
<!--    };-->

<!--    // Lưu khách hàng (Thêm/Sửa)-->
<!--    const saveKhachHang = async () => {-->
<!--      try {-->
<!--        if (isEdit.value) {-->
<!--          await store.dispatch("customer/updateCustomer", khachHang.value);-->
<!--        } else {-->
<!--          await store.dispatch("customer/addCustomer", khachHang.value);-->
<!--        }-->
<!--        router.push("/customers");-->
<!--      } catch (error) {-->
<!--        console.error("Lỗi khi lưu khách hàng:", error);-->
<!--      }-->
<!--    };-->

<!--    // Hủy bỏ và quay lại trang danh sách-->
<!--    const cancel = () => {-->
<!--      router.push("/customers");-->
<!--    };-->

<!--    // Khi chọn tỉnh/thành phố, cập nhật danh sách quận/huyện-->
<!--    const loadQuanHuyen = () => {-->
<!--      const selectedTinh = store.state.location.tinhThanhList.find((t) => t.value === khachHang.value.tinhThanh);-->

<!--      if (selectedTinh && selectedTinh.districts) {-->
<!--        quanHuyenOptions.value = selectedTinh.districts.map((q) => ({-->
<!--          value: q.value,-->
<!--          text: q.text,-->
<!--        }));-->
<!--      } else {-->
<!--        quanHuyenOptions.value = [];-->
<!--      }-->

<!--      // Reset quận/huyện và xã/phường khi thay đổi tỉnh/thành-->
<!--      khachHang.value.quanHuyen = "";-->
<!--      khachHang.value.xaPhuong = "";-->
<!--      xaPhuongOptions.value = [];-->
<!--    };-->


<!--    const loadXaPhuong = () => {-->
<!--      console.log("🔹 Khách hàng chọn quận/huyện:", khachHang.value.quanHuyen);-->
<!--      console.log("📌 Danh sách quận/huyện hiện tại:", JSON.stringify(quanHuyenOptions.value, null, 2));-->

<!--      const selectedQuan = quanHuyenOptions.value.find(q => q.value === khachHang.value.quanHuyen);-->
<!--      console.log("✅ Quận/Huyện được chọn:", JSON.stringify(selectedQuan, null, 2));-->

<!--      if (!selectedQuan) {-->
<!--        console.warn(`⚠️ Không tìm thấy Quận/Huyện '${khachHang.value.quanHuyen}' trong danh sách!`);-->
<!--        xaPhuongOptions.value = [];-->
<!--        return;-->
<!--      }-->

<!--      if (!selectedQuan.wards || selectedQuan.wards.length === 0) {-->
<!--        console.warn(`⚠️ Quận/Huyện '${selectedQuan.text}' không có danh sách xã/phường!`);-->
<!--      } else {-->
<!--        console.log(`📌 Quận/Huyện '${selectedQuan.text}' có ${selectedQuan.wards.length} xã/phường.`);-->
<!--      }-->
<!--      xaPhuongOptions.value = selectedQuan.wards?.map(x => ({ value: x.value, text: x.text })) || [];-->
<!--      console.log("📌 Danh sách xã/phường cập nhật:", JSON.stringify(xaPhuongOptions.value, null, 2));-->
<!--    };-->



<!--    // Theo dõi thay đổi tỉnh/thành phố để cập nhật quận/huyện-->
<!--    watch(() => khachHang.value.tinhThanh, loadQuanHuyen);-->

<!--    // Theo dõi thay đổi quận/huyện để cập nhật xã/phường-->
<!--    watch(() => khachHang.value.quanHuyen, loadXaPhuong);-->
<!--    // watch(() => khachHang.value.quanHuyen, (newValue) => {-->
<!--    //   console.log("🔹 Quận/Huyện mới được chọn:", newValue);-->
<!--    //   loadXaPhuong();-->
<!--    // });-->



<!--    // Gọi API khi component mount-->
<!--    onMounted(() => {-->
<!--      store.dispatch("location/fetchTinhThanh").then(() => {-->
<!--        console.log("Dữ liệu tỉnh/thành sau khi tải:", JSON.parse(JSON.stringify(store.state.location.tinhThanhList)));-->
<!--      });-->

<!--      if (isEdit.value) {-->
<!--        fetchKhachHang();-->
<!--      }-->
<!--    });-->


<!--    return {-->
<!--      khachHang,-->
<!--      tinhThanhOptions,-->
<!--      quanHuyenOptions,-->
<!--      xaPhuongOptions,-->
<!--      isEdit,-->
<!--      saveKhachHang,-->
<!--      cancel,-->
<!--      loadQuanHuyen,-->
<!--      loadXaPhuong,-->
<!--    };-->
<!--  },-->
<!--};-->
<!--</script>-->