<template>
    <div style="display: flex">
        <SideMenu />
        <div
            v-show="visable"
            style="
            display: flex;
            flex: 1;
            justify-content: center;
            flex-direction: column;
            align-items: center;
            "
        >
            <h1>欢迎进入Web GIS Service~</h1>
        </div>
        <div v-show="!visable" style="flex: 1">
            <router-view />
        </div>
    </div>
</template>

<script setup lang="ts">
import SideMenu from "../components/SideMenu.vue";
import { ref, watch } from "vue";
import { useRoute } from "vue-router";
let visable = ref(true);
const route = useRoute();
watch(
    () => route.path,
    () => {
        console.log("监听到变化");
    }
);

//   watch: {
//     $route(to: any, from: any) {
//       console.log(to, from);
//       if (to.path == "/") {
//         this.visable = true;
//       } else {
//         this.visable = false;
//       }
//     },
//   },
</script>
