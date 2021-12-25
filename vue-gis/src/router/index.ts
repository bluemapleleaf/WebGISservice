import { createRouter, createWebHistory } from "vue-router";

const routerHistory = createWebHistory();
const router = createRouter({
  history: routerHistory,
  routes: [
    {
      path: "/",
      name: "Index",
      component: () => import("../views/Index.vue"),
      children: [
        {
          path: "/usermanage",
          name: "UserManage",
          component: () => import("../views/UserManage.vue"),
        },
        {
          path: "/eventlist",
          name: "EventList",
          component: () => import("../views/EventList.vue"),
        },
        {
          path: "/eventmap",
          name: "EventMap",
          component: () => import("../views/EventMap.vue"),
        },
        {
            path: "/announce",
            name: "Announce",
            component: () => import("../views/Announce.vue"),
          },
      ],
    },
    {
      path: "/login",
      name: "Login",
      component: () => import("../views/LoginRegister.vue"),
    },
    {
      path: "/:catchAll(.*)",
      name: "404",
      component: () => import("../views/404.vue"),
    },
  ],
});

export default router;
