import { createApp } from "vue";
import App from "./App.vue";
import router from "./router/index";
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";
import zhCn from "element-plus/es/locale/lang/zh-cn";
import axios from "./utils/http";

const app = createApp(App).use(router).use(ElementPlus,{locale:zhCn});

app.mount("#app");
app.config.globalProperties.$axios = axios;
