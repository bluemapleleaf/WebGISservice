<template>
  <div style="height: 100%">
    <el-menu default-active="/" class="el-menu-vertical-demo" router>
      <el-menu-item index="/">
        <el-icon>
          <coordinate />
        </el-icon>
        <template #title>首页</template>
      </el-menu-item>
      <el-menu-item index="/eventlist">
        <el-icon>
          <document />
        </el-icon>
        <template #title>事件列表</template>
      </el-menu-item>
      <el-menu-item index="/eventmap">
        <el-icon>
          <location />
        </el-icon>
        <template #title>事件地图</template>
      </el-menu-item>

      <el-menu-item index="/announce">
        <el-icon>
          <chat-dot-square />
        </el-icon>
        <template #title>事件公告发布</template>
      </el-menu-item>
      <el-sub-menu index="1">
        <template #title>
          <el-icon>
            <data-analysis />
          </el-icon>
          可视化分析
        </template>
        <el-menu-item index="/heatmap">
          <template #title> 事件分布热力图 </template>
        </el-menu-item>
        <el-menu-item index="/lostcharts">
          <template #title> 失物招领数据分析 </template>
        </el-menu-item>
      </el-sub-menu>
    </el-menu>
    <el-button class="logoutBtn" @click="userLogout" type="primary">
      <el-icon><circle-close-filled /></el-icon>
      退出登录
    </el-button>
  </div>
</template>

<script setup lang="ts">
import {
  Location,
  Document,
  ChatDotSquare,
  Avatar,
  Coordinate,
  DataAnalysis,
} from "@element-plus/icons-vue";
import { store } from "../store";
import { CircleCloseFilled } from "@element-plus/icons-vue";
function userLogout() {
  sessionStorage.clear();

  var state = {
    userName: "",
    realName: "",
    phoneNumber: "",
    type: 1,
    address: "",
    affiliation: "",
  };
  store.commit("changeUser", state);
  location.reload();
}
</script>

<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 100vh;
}
.logoutBtn {
  height: 30px;
  position: absolute;
  left: 20px;
  bottom: 60px;
}
</style>
