<script setup lang="ts">
import {useStore} from 'vuex'
import {useRouter} from "vue-router";
// @ts-ignore
const store = useStore()
const router = useRouter()

//在页面加载时读取sessionStorage里的状态信息
if (sessionStorage.getItem("store")) {
    // @ts-ignore
    store.replaceState(Object.assign({}, store.state, JSON.parse(sessionStorage.getItem("store"))))
}

//在页面刷新时将vuex里的信息保存到sessionStorage里
window.addEventListener("beforeunload", () => {
    sessionStorage.setItem("store", JSON.stringify(store.state))
})


</script>

<template>
    <router-view></router-view>
</template>

<style></style>
