<template>
  <div>
    <el-select
      v-model="typeValue"
      placeholder="维修"
      size="small"
      style="width: 100px"
    >
      <el-option
        v-for="item in options1"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      >
      </el-option>
    </el-select>
    <el-select
      v-model="stateValue"
      placeholder="所有状态"
      size="small"
      style="width: 100px;margin-left: 10px;"
    >
      <el-option
        v-for="item in options2"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      >
      </el-option>
    </el-select>
    <el-input
      v-model="inputTitle"
      placeholder="输入关键字"
      style="width: 300px; margin-bottom: 10px; margin-left: 10px"
      size="small"
    />
    <el-button
      type="primary"
      @click="getEventList"
      style="margin-left: 10px"
      size="small"
      >查询</el-button
    >
    <el-button
      type="primary"
      plain
      @click="resetEventList"
      style="margin-left: 10px"
      size="small"
      >重置</el-button
    >
    <el-button
      type="success"
      @click="addEvent"
      style="float: right"
      size="small"
      >+ 添加</el-button
    >
  </div>

  <el-table
    :data="tableData"
    style="width: 100%; border: 1px solid rgb(228, 228, 228)"
  >
    <el-table-column prop="id" label="事件ID" />
    <el-table-column prop="applyId" label="提交者ID" />
    <el-table-column prop="finishID" label="解决者ID" />
    <el-table-column prop="title" label="标题" />
    <el-table-column prop="content" label="内容" />
    <el-table-column prop="place" label="地点" />
    <el-table-column prop="latitude" label="纬度" />
    <el-table-column prop="longitude" label="经度" />
    <el-table-column prop="applyDate" label="提交时间" />
    <el-table-column prop="finishDate" label="解决时间" />
    <el-table-column prop="state" label="完成状态" />

    <el-table-column label="操作" width="150">
      <template #default="scope">
        <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
          >编辑</el-button
        >
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>
  <div style="display: flex; justify-content: flex-end">
    <el-pagination
      background
      v-model:currentPage="currentPage"
      :page-size="pageSize"
      @current-change="currentChange"
      @size-change="sizeChange"
      layout="total, sizes, prev, pager, next, jumper, ->, slot"
      :total="total"
    >
    </el-pagination>
  </div>
</template>

<script setup lang="ts">
import { ref, defineComponent, reactive } from "vue";
// 查询
let options1 = ref([
  {
    value: "repair",
    label: "维修",
  },
  {
    value: "lost",
    label: "丢失",
  },
  {
    value: "found",
    label: "捡到",
  },
]);
let options2 = ref([
  {
    value: "",
    label: "所有状态",
  },
  {
    value: "0",
    label: "未完成",
  },
  {
    value: "1",
    label: "已完成",
  },
]);
let typeValue = ref("repair");
let stateValue = ref("");
let inputTitle = ref("");

function getEventList(
  page: number,
  pagesize: number,
  search: string,
  type: string,
  state: string
) {}
function resetEventList() {}
function addEvent() {}

// 表格
let tableData = reactive([]);
function handleEdit(index: any, row: any) {}
function handleDelete(index: any, row: any) {}

//分页
let pageSize = ref(10);
let currentPage = ref(1);
let total = ref(0);
function currentChange() {}
function sizeChange() {}
</script>
