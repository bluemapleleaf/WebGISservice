<template>
  <div style="display: flex; flex-direction: column; height: 100%">
    <div>
      <el-input
        v-model="input"
        placeholder="查询关键字"
        style="width: 300px; margin-bottom: 10px"
        size="small"
      />
      <el-button
        type="primary"
        @click="searchEvent"
        style="margin-left: 10px"
        size="small"
        >查询</el-button
      >
      <el-button
        type="primary"
        plain
        @click="getEventList"
        style="margin-left: 10px"
        size="small"
        >重置</el-button
      >
    </div>

    <div id="container" style="flex: 1"></div>
    <!-- <iframe style="flex: 1"
        src="https://maplab.amap.com/share/mapv/22e19a8fb91eefdd5c2bf753e9c5562a"
      ></iframe> -->
    <div style="margin: 0 auto">
      <el-radio-group v-model="radio" @change="getEventList" size="small">
        <el-radio-button label="all">全部事件</el-radio-button>
        <el-radio-button label="repair">维修</el-radio-button>
        <el-radio-button label="found">寻物启事</el-radio-button>
        <el-radio-button label="lost">失物招领</el-radio-button>
      </el-radio-group>
    </div>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref,reactive } from "vue";
import { shallowRef } from "@vue/reactivity";
import AMapLoader from "@amap/amap-jsapi-loader";
// 选择不同的类别
let input = ref("");
function searchEvent() {}

function getEventList() {}

let radio = ref("all");
let map = shallowRef(null);
let data=reactive({
    marker:[]
})
function initMap() {
  AMapLoader.load({
    key: "cdbb4acf696f8080139bc1cb2a29000d", // 申请好的Web端开发者Key，首次调用 load 时必填
    version: "2.0", // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
    plugins: [""], // 需要使用的的插件列表，如比例尺'AMap.Scale'等
  })
    .then((AMap) => {
      map = new AMap.Map("container", {
        //设置地图容器id
        viewMode: "3D", //是否为3D地图模式
        zoom: 15, //初始化地图级别
        center: [114.362378, 30.534268], //初始化地图中心点位置
      });
    })
    .catch((e) => {
      console.log(e);
    });
}
onMounted(() => {
  initMap();
});
</script>

<style scoped>
#container {
  padding: 0px;
  margin: 0px;
  width: 100%;
  height: 800px;
}
</style>
