<template>
  <el-icon @click="handleCollapse" :color="iconColor" size="30"
    ><expand
  /></el-icon>
  <el-menu
    default-active=""
    class="el-menu-vertical-demo"
    :collapse="isCollapse"
    @open="handleOpen"
    @close="handleClose"
  >
    <el-menu-item index="1">
      <el-icon><avatar /></el-icon>
      <template #title>用户管理</template>
    </el-menu-item>
    <el-sub-menu index="2">
      <template #title>
        <el-icon><icon-menu /></el-icon>
        <span>事件管理</span>
      </template>
      <el-menu-item index="2-1">
        <el-icon><document /></el-icon>
        <template #title>事件列表</template>
      </el-menu-item>
      <el-menu-item index="2-1">
        <el-icon><location /></el-icon>
        <template #title>事件地图</template>
      </el-menu-item>
    </el-sub-menu>

    <el-menu-item index="3">
      <el-icon><chat-dot-square /></el-icon>
      <template #title>事件公告发布</template>
    </el-menu-item>
    <el-menu-item index="4">
      <el-icon><data-analysis /></el-icon>
      <template #title>可视化分析</template>
    </el-menu-item>
  </el-menu>
</template>

<script setup lang="ts">
import { defineComponent, ref } from "vue";
import {
  Location,
  Document,
  Menu as IconMenu,
  Setting,
  Expand,
  ChatDotSquare,
  Avatar,
  DataAnalysis
} from "@element-plus/icons-vue";

let isCollapse = ref(true);
let iconColor = ref("inherit");
function handleCollapse() {
  console.log("isCollapse是", isCollapse);
  if (isCollapse) {
    iconColor.value = "dodgerblue";
  } else {
    iconColor.value = "inherit";
  }
  isCollapse.value = !isCollapse.value;
}
const handleOpen = (key: any, keyPath: any) => {
  console.log(key, keyPath);
};
const handleClose = (key: any, keyPath: any) => {
  console.log(key, keyPath);
};
</script>

<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 100vh;
}
</style>
