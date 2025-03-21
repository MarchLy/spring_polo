
import { createRouter, createWebHistory } from "vue-router";
import Dashboard from "../views/Dashboard.vue";
import Tables from "../views/Tables.vue";
import Billing from "../views/Billing.vue";
import Profile from "../views/Profile.vue";
import Signup from "../views/Signup.vue";
import Signin from "../views/Signin.vue";
import Product from "../views/Product.vue";
import Voucher from "../views/Voucher.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    redirect: "/dashboard-default",
  },
  {
    path: "/dashboard-default",
    name: "Dashboard",
    component: Dashboard,
  },
  {
    path: "/product",
    name: "Product",
    component: Product,
    children: [
      { path: "keyboards", name: "Keyboards", component: () => import("../views/product/Keyboards.vue") },
      { path: "mice", name: "Mice", component: () => import("../views/product/Mice.vue") },
      { path: "headsets", name: "Headsets", component: () => import("../views/product/Headsets.vue") },
      { path: "keycaps", name: "Keycaps", component: () => import("../views/product/Keycaps.vue") },
      { path: "cases", name: "Cases", component: () => import("../views/product/Cases.vue") },
      { path: "laptop-stands", name: "LaptopStands", component: () => import("../views/product/LaptopStands.vue") },
      { path: "speakers", name: "Speakers", component: () => import("../views/product/Speakers.vue") },
      { path: "mousepads", name: "Mousepads", component: () => import("../views/product/Mousepads.vue") },
      { path: "cables", name: "Cables", component: () => import("../views/product/Cables.vue") },
      { path: "accessories", name: "Accessories", component: () => import("../views/product/Accessories.vue") },
    ],
  },
  {
    path: "/voucher",
    name: "Voucher",
    component: Voucher,
    children: [
      { path: "discount", name: "Discount", component: () => import("../views/voucher/Discount.vue") },
      { path: "gift", name: "Gift", component: () => import("../views/voucher/Gift.vue") },
    ],
  },
  {
    path: "/tables",
    name: "Tables",
    component: Tables,
  },
  {
    path: "/billing",
    name: "Billing",
    component: Billing,
  },
  // {
  //   path: "/profile",
  //   name: "Profile",
  //   component: Profile,
  // },
  {
    path: "/profile",
    name: "Profile",
    component: Profile,
    children: [
      { path: "staff", name: "Staff", component: () => import("../views/profile/Staff.vue") },
      { path: "client", name: "Client", component: () => import("../views/profile/Client.vue") },
    ],
  },

  {
    path: "/signin",
    name: "Signin",
    component: Signin,
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
  linkActiveClass: "active",
});

export default router;





// import { createRouter, createWebHistory } from "vue-router";
// import Dashboard from "../views/Dashboard.vue";
// import Tables from "../views/Tables.vue";
// import Billing from "../views/Billing.vue";
// // import VirtualReality from "../views/VirtualReality.vue";
// import RTL from "../views/Rtl.vue";
// import Profile from "../views/Profile.vue";
// import Signup from "../views/Signup.vue";
// import Signin from "../views/Signin.vue";
// import Voucher from "@/views/Voucher.vue";
//
// import Product from "../views/Product.vue";
//
// const routes = [
//   {
//     path: "/",
//     name: "/",
//     redirect: "/dashboard-default",
//   },
//   {
//     path: "/dashboard-default",
//     name: "Dashboard",
//     component: Dashboard,
//   },
//   {
//     path: "/product",
//     name: "Product",
//     component: Product,
//   },
//   {
//     path: "/tables",
//     name: "Tables",
//     component: Tables,
//   },
//   {
//     path: "/billing",
//     name: "Billing",
//     component: Billing,
//   },
//   {
//     path: "/voucher",
//     name: "Voucher",
//     component: Voucher,
//   },
//   // {
//   //   path: "/virtual-reality",
//   //   name: "Virtual Reality",
//   //   component: VirtualReality,
//   // },
//   {
//     path: "/rtl-page",
//     name: "RTL",
//     component: RTL,
//   },
//   {
//     path: "/profile",
//     name: "Profile",
//     component: Profile,
//   },
//   {
//     path: "/signin",
//     name: "Signin",
//     component: Signin,
//   },
//   {
//     path: "/signup",
//     name: "Signup",
//     component: Signup,
//   },
// ];
//
// const router = createRouter({
//   history: createWebHistory(process.env.BASE_URL),
//   routes,
//   linkActiveClass: "active",
// });
//
// export default router;
