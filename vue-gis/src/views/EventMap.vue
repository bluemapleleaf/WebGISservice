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
import { ref } from "vue";

let input = ref("");
function searchEvent() {}

function getEventList() {}

let radio = ref("all");

function loadMap() {
  var map = new BMap.Map("container");
  var point = new BMap.Point(116.404, 39.915);
  map.centerAndZoom(point, 15);
  map.enableScrollWheelZoom(true);
}
</script>
