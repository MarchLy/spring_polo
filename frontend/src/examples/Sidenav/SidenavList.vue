<script setup>
import { ref, computed } from "vue";
import { useRoute } from "vue-router";
import { useStore } from "vuex";

import SidenavItem from "./SidenavItem.vue";
import SidenavCard from "./SidenavCard.vue";
// import PaymentCard from "./components/PaymentCard.vue";
// import InvoiceCard from "./components/InvoiceCard.vue";
// import BillingCard from "./components/BillingCard.vue";
// import TransactionCard from "./components/TransactionCard.vue";

const store = useStore();
const isRTL = computed(() => store.state.isRTL);
const route = useRoute();

// Trạng thái mở/đóng menu con
const openMenus = ref({});

// Kiểm tra route hiện tại để mở menu con tương ứng
const getRoute = () => {
  const routeArr = route.path.split("/");
  return routeArr[1];
};

// Hàm toggle menu con
const toggleMenu = (menuName) => {
  openMenus.value = {
    ...openMenus.value,
    [menuName]: !openMenus.value[menuName],
  };
};
</script>

<template>
  <div class="collapse navbar-collapse w-auto h-auto h-100" id="sidenav-collapse-main">
    <ul class="navbar-nav">
      <!-- Dashboard -->
      <li class="nav-item">
        <sidenav-item
            to="/dashboard-default"
            :class="getRoute() === 'dashboard-default' ? 'active' : ''"
            :navText="isRTL ? 'Dashboard' : 'Thống kê'"
        >
          <template v-slot:icon>
            <i class="ni ni-tv-2 text-primary text-sm opacity-10"></i>
          </template>
        </sidenav-item>
      </li>

      <!-- Product -->
      <li class="nav-item">
        <sidenav-item
            to="/"
            :navText="isRTL ? 'Product' : 'Sản phẩm'"
            @click="toggleMenu('product')"
        >
          <template v-slot:icon>
            <i class="ni ni-bag-17 text-warning text-sm opacity-10"></i>
          </template>
          <template v-slot:extra >
            <i :class="openMenus['product'] ? 'fa fa-chevron-up' : 'fa fa-chevron-down'" class="ms-auto"></i>
          </template>
        </sidenav-item>
        <ul v-if="openMenus['product']" class="navbar-nav">
          <li class="nav-item">
            <sidenav-item to="/product/keyboards" navText="Keyboards" />
          </li>
          <li class="nav-item">
            <sidenav-item to="/product/mice" navText="Mice" />
          </li>
          <li class="nav-item">
            <sidenav-item to="/product/headsets" navText="Headsets" />
          </li>
          <li class="nav-item">
            <sidenav-item to="/product/keycaps" navText="Keycaps" />
          </li>
          <li class="nav-item">
            <sidenav-item to="/product/cases" navText="Cases" />
          </li>
          <li class="nav-item">
            <sidenav-item to="/product/laptop-stands" navText="Laptop Stands" />
          </li>
          <li class="nav-item">
            <sidenav-item to="/product/speakers" navText="Speakers" />
          </li>
          <li class="nav-item">
            <sidenav-item to="/product/mousepads" navText="Mousepads" />
          </li>
          <li class="nav-item">
            <sidenav-item to="/product/cables" navText="Cables" />
          </li>
          <li class="nav-item">
            <sidenav-item to="/product/accessories" navText="Accessories" />
          </li>
        </ul>
      </li>

      <!-- Billing -->
      <li class="nav-item">
        <sidenav-item
            to="/billing"
            :class="getRoute() === 'billing' ? 'active' : ''"
            :navText="isRTL ? 'Billing' : 'Hóa đơn'"
        >
          <template v-slot:icon>
            <i class="ni ni-credit-card text-success text-sm opacity-10"></i>
          </template>
        </sidenav-item>
      </li>

      <!-- Voucher -->
      <li class="nav-item">
        <sidenav-item
            to="/"
            :navText="isRTL ? 'Voucher' : 'Quản lý giảm giá'"
            @click="toggleMenu('voucher')"
        >
          <template v-slot:icon>
            <i class="ni ni-tag text-info text-sm opacity-10"></i>
          </template>
          <template v-slot:extra>
            <i :class="openMenus['voucher'] ? 'fa fa-chevron-up' : 'fa fa-chevron-down'" class="ms-auto"></i>
          </template>
        </sidenav-item>
        <ul v-if="openMenus['voucher']" class="navbar-nav">
          <li class="nav-item">
            <sidenav-item to="/voucher/discount" navText="Discount" />
          </li>
          <li class="nav-item">
            <sidenav-item to="/voucher/gift" navText="Gift" />
          </li>
        </ul>
      </li>

      <!-- ACCOUNT PAGES -->
      <li class="mt-3 nav-item">
        <h6 class="text-xs ps-4 text-uppercase font-weight-bolder opacity-6" :class="isRTL ? 'me-4' : 'ms-2'">
          ACCOUNT PAGES
        </h6>
      </li>

      <!-- Profile -->
      <li class="nav-item">
        <sidenav-item
            to="/"
            :navText="isRTL ? 'Profile' : 'Hồ sơ'"
            @click="toggleMenu('profile')"
        >
          <template v-slot:icon>
            <i class="ni ni-single-02 text-dark text-sm opacity-10"></i>
          </template>
          <template v-slot:extra>
            <i :class="openMenus['profile'] ? 'fa fa-chevron-up' : 'fa fa-chevron-down'" class="ms-auto"></i>
          </template>
        </sidenav-item>
        <ul v-if="openMenus['profile']" class="navbar-nav">
          <li class="nav-item">
            <sidenav-item to="/profile/staff" navText="Staff" />
          </li>
          <li class="nav-item">
            <sidenav-item to="/profile/client" navText="Client" />
          </li>
        </ul>
      </li>

      <!-- Sign In -->
      <li class="nav-item">
        <sidenav-item
            to="/signin"
            :class="getRoute() === 'signin' ? 'active' : ''"
            :navText="isRTL ? 'Sign In' : 'Đăng nhập'"
        >
          <template v-slot:icon>
            <i class="ni ni-single-copy-04 text-danger text-sm opacity-10"></i>
          </template>
        </sidenav-item>
      </li>

      <!-- Sign Up -->
      <li class="nav-item">
        <sidenav-item
            to="/signup"
            :class="getRoute() === 'signup' ? 'active' : ''"
            :navText="isRTL ? 'Sign Up' : 'Đăng ký'"
        >
          <template v-slot:icon>
            <i class="ni ni-collection text-info text-sm opacity-10"></i>
          </template>
        </sidenav-item>
      </li>
    </ul>
  </div>

  <!-- FOOTER -->
  <div class="pt-3 mx-3 mt-3 sidenav-footer">
    <sidenav-card
        :card="{
        title: 'Cần trợ giúp?',
        description: 'Vui lòng kiểm tra tài liệu của chúng tôi',
        links: [
          { label: 'Tài liệu', route: 'https://www.creative-tim.com/learning-lab/vue/overview/argon-dashboard/', color: 'dark' },
          { label: 'Mua ngay', route: 'https://www.creative-tim.com/product/vue-argon-dashboard-pro?ref=vadp', color: 'success' },
        ],
      }"
    />
  </div>
</template>

<style scoped>
.navbar-nav .nav-item {
  margin-bottom: 0.5rem;
}

.navbar-nav .nav-item .nav-link {
  padding: 0.5rem 1rem;
}

.navbar-nav .nav-item .nav-link.active {
  background-color: rgba(255, 255, 255, 0.1);
  border-radius: 0.375rem;
}

.sidenav-footer {
  border-top: 1px solid rgba(255, 255, 255, 0.1);
}
.nav-item i {
  transition: transform 0.3s ease;
}
</style>