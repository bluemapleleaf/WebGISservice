<template>
  <div class="main" style=";display: flex">
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
      <div style="top: 100px; position: absolute; mar" id="welcomeText">
        <h1>欢迎进入Web GIS Service~</h1>
        <h1>欢迎{{ storeState.userName }}使用~</h1>
      </div>
      <div class="userInfo">
        <h2>用户昵称: {{ storeState.userName }}</h2>
        <h2>用户姓名: {{ storeState.realName }}</h2>
        <h2>用户联系方式: {{ storeState.phoneNumber }}</h2>
        <h2>用户所在区域: {{ _storeState.affiliation }}</h2>
        <h2>用户住址: {{ _storeState.address }}</h2>
      </div>
    </div>
    <div v-show="!visable" style="flex: 1; margin: 10px">
      <router-view />
    </div>
  </div>
</template>

<script setup lang="ts">
import SideMenu from "../components/SideMenu.vue";
import { ref, watch } from "vue";
import { useRoute } from "vue-router";
import { useStore } from "vuex"

const store = useStore()
// @ts-ignore
let storeState = store.state;
// @ts-ignore
let _storeState = ref(storeState)
let visable = ref(true);
const route = useRoute();
watch(
  () => route.path,
  () => {
    if (route.path == "/") {
      visable.value = true;
    } else {
      visable.value = false;
    }
  }
);

</script>
<style scoped>
#three {
  background-color: aquamarine;
}
#welcomeText {
  position: absolute;
  top: 100px;
  left: 250px;
  text-align: center;
}
.userInfo {
  box-shadow: 3 4 1px #000;
  background-color: white;
  position: absolute;
  left: 700px;
  top: 200px;
  height: 300px;
  width: 400px;
  border: #000;
  border-width: 2px;
  -webkit-box-shadow: #666 0px 0px 10px;
  -moz-box-shadow: #666 0px 0px 10px;
  box-shadow: #666 0px 0px 10px;
  border-radius: 10px;
  text-align: left;
  padding: 20px;
}
</style>