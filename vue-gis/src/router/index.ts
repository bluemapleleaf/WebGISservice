import {createRouter, createWebHistory} from "vue-router";
import {computed} from "vue";
import {store} from "../store";

const routerHistory = createWebHistory();
const router = createRouter({
    history: routerHistory,
    routes: [
        {
            path: "/",
            name: "Index",
            component: () => import("../views/Index.vue"),
            meta: {
                requireAuth: true, // 判断是否需要登录
            },
            children: [
                {
                    path: "/usermanage",
                    name: "UserManage",
                    component: () => import("../views/UserManage.vue"),
                    meta: {
                        requireAuth: true, // 判断是否需要登录
                    },
                },
                {
                    path: "/eventlist",
                    name: "EventList",
                    component: () => import("../views/EventList.vue"),
                    meta: {
                        requireAuth: true, // 判断是否需要登录
                    },
                },
                {
                    path: "/eventmap",
                    name: "EventMap",
                    component: () => import("../views/EventMap.vue"),
                    meta: {
                        requireAuth: true, // 判断是否需要登录
                    },
                },
                {
                    path: "/heatmap",
                    name: "HeatMap",
                    component: () => import("../views/analyHeatMap.vue"),
                    meta: {
                        requireAuth: true, // 判断是否需要登录
                    },
                },
                {
                    path: "/announce",
                    name: "Announce",
                    component: () => import("../views/Announce.vue"),
                    meta: {
                        requireAuth: true, // 判断是否需要登录
                    },
                },
                {
                    path: "/lostcharts",
                    name: "lostcharts",
                    component: () => import("../views/lostCharts.vue"),
                    meta: {
                        requireAuth: true, // 判断是否需要登录
                    },
                }
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
