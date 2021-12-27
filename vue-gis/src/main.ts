import {computed, createApp} from "vue";
import App from "./App.vue";
import router from "./router/index";
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";
import zhCn from "element-plus/es/locale/lang/zh-cn";
import axios from "./utils/http";
import {store} from "./store"

const app = createApp(App).use(router).use(store).use(ElementPlus, {locale: zhCn});

app.mount("#app");
app.config.globalProperties.$axios = axios;

// @ts-ignore
let userName = computed(() => store.state.userName)
// 路由判断登录 根据路由配置文件的参数
router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.requireAuth)) { // 判断该路由是否需要登录权限
        console.log('需要登录');
        if (userName.value != "") { // 判断当前的用户是否已经登录
            next();
        } else {
            next({
                path: '/login',
                query: {redirect: to.fullPath} // 将跳转的路由path作为参数，登录成功后跳转到该路由
            })
        }
    } else {
        next();
    }
});