<template>
  <!-- 分类查询 -->
  <div>
    <el-select
      v-model="typeValue"
      placeholder="维修"
      size="small"
      style="width: 100px"
      @change="getEventList"
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
      v-model="state"
      placeholder="所有状态"
      size="small"
      style="width: 100px; margin-left: 10px"
      @change="getEventList"
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
      v-model="search"
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
  <!-- 表格 -->
  <el-table
    :data="tableData.data"
    style="width: 100%; border: 1px solid rgb(228, 228, 228)"
  >
    <el-table-column prop="id" label="编号" width="50px" />
    <el-table-column prop="applyId" label="提交者ID" width="65px" />
    <el-table-column
      v-if="typeValue == 'repair'"
      prop="repairId"
      label="维修者ID"
      width="65px"
    />
    <el-table-column v-else prop="finishId" label="解决者ID" width="65px" />
    <el-table-column prop="title" label="标题" width="50px" />
    <el-table-column prop="content" label="内容" />
    <el-table-column prop="place" label="地点" />
    <el-table-column prop="latitude" label="纬度" />
    <el-table-column prop="longitude" label="经度" />
    <el-table-column prop="applyDate" label="提交时间" />
    <el-table-column prop="finishDate" label="解决时间" />
    <el-table-column prop="state" label="完成状态" width="50px" />

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
  <!-- 分页 -->
  <div style="display: flex; justify-content: flex-end">
    <el-pagination
      background
      v-model:currentPage="currentPage"
      v-model:page-size="pageSize"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      @current-change="currentChange"
      @size-change="sizeChange"
      layout="total, sizes, prev, pager, next, jumper, ->, slot"
      :total="total"
    >
    </el-pagination>
  </div>
  <!-- 对话框 -->
  <el-dialog v-model="dialogVisible">
    <div
      style="
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
      "
    >
      <div style="height: 70px"><h3>编辑事件</h3></div>
      <el-form
        ref="Form"
        :model="formData"
        size="medium"
        label-width="90px"
        label-position="left"
      >
        <el-form-item label="提交者ID" prop="applyId">
          <el-input
            v-model="formData.applyId"
            placeholder="请输入提交者ID"
            clearable
            suffix-icon="el-icon-user"
            :style="{ width: '100%' }"
          ></el-input>
        </el-form-item>
        <el-form-item
          v-if="typeValue == 'repair'"
          label="维修者ID"
          prop="repairId"
        >
          <el-input
            v-model="formData.repairId"
            placeholder="请输入维修者ID"
            clearable
            suffix-icon="el-icon-user"
            :style="{ width: '100%' }"
          ></el-input>
        </el-form-item>
        <el-form-item v-else label="解决者ID" prop="finishId">
          <el-input
            v-model="formData.finishId"
            placeholder="请输入解决者ID"
            clearable
            suffix-icon="el-icon-user"
            :style="{ width: '100%' }"
          ></el-input>
        </el-form-item>
        <el-form-item label="标题" prop="title">
          <el-input
            v-model="formData.title"
            placeholder="请输入标题"
            clearable
            :style="{ width: '100%' }"
          ></el-input>
        </el-form-item>
        <el-form-item label="内容" prop="content">
          <el-input
            v-model="formData.content"
            placeholder="请输入内容"
            clearable
            :style="{ width: '100%' }"
          ></el-input>
        </el-form-item>
        <el-form-item label="地点" prop="place">
          <el-input
            v-model="formData.place"
            placeholder="请输入地点"
            clearable
            :style="{ width: '100%' }"
          ></el-input>
        </el-form-item>
        <el-form-item label="纬度" prop="latitude">
          <el-input
            v-model="formData.latitude"
            placeholder="请输入纬度"
            clearable
            :style="{ width: '100%' }"
          ></el-input>
        </el-form-item>
        <el-form-item label="经度" prop="longitude">
          <el-input
            v-model="formData.longitude"
            placeholder="请输入经度"
            clearable
            :style="{ width: '100%' }"
          ></el-input>
        </el-form-item>
        <el-form-item label="经度" prop="longitude">
          <el-input
            v-model="formData.longitude"
            placeholder="请输入经度"
            clearable
            :style="{ width: '100%' }"
          ></el-input>
        </el-form-item>
        <el-form-item label="提交时间" prop="applyDate">
          <el-date-picker
            v-model="formData.applyDate"
            type="datetime"
            placeholder="Select date and time"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="解决时间" prop="finishDate">
          <el-date-picker
            v-model="formData.finishDate"
            type="datetime"
            placeholder="Select date and time"
          >
          </el-date-picker>
        </el-form-item>
        <el-radio v-model="radio1" label="1">Option 1</el-radio>
    <el-radio v-model="radio1" label="2">Option 2</el-radio>

     
      </el-form>
    </div>
  </el-dialog>
</template>

<script setup lang="ts">
import { ElMessage } from "element-plus";
import { ref, defineComponent, reactive, onMounted } from "vue";
import http from "../utils/http";
// 可选项
let options1 = ref([
  {
    value: "repair",
    label: "维修",
  },
  {
    value: "0",
    label: "丢失",
  },
  {
    value: "1",
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

// 表格
let tableData = reactive({
  data: [],
});

//查询所需要的参数
let typeValue = ref("repair");
let state = ref("");
let search = ref("");
let pageSize = ref(5);
let currentPage = ref(1);
let total = ref(0);

// 查询事件
function getEventList() {
  if (typeValue.value == "repair") {
    // 向repair表发起查询
    http
      .get("/api/repairs", {
        params: {
          pageNum: currentPage.value,
          pageSize: pageSize.value,
          search: search.value,
          repairType: "",
          state: state.value,
        },
      })
      .then((res) => {
        tableData.data = res.data.data.records;
        console.log(tableData);
        total.value = res.data.data.total;
        console.log(total.value);
      });
  } else {
    //   向lost_and_found表发起查询
    http
      .get("/api/lostandfounds", {
        params: {
          pageNum: currentPage.value,
          pageSize: pageSize.value,
          search: search.value,
          type: typeValue.value,
          state: state.value,
        },
      })
      .then((res) => {
        tableData.data = res.data.data.records;

        console.log(tableData);
        total.value = res.data.data.total;
        console.log(total.value);
      });
  }
}
// 重置关键词
function resetEventList() {
  search.value = "";
  getEventList();
}

//分页控制
function currentChange() {
  getEventList();
}
function sizeChange() {
  getEventList();
}

// 对话框事件编辑
let dialogVisible = ref(false);
let formData = reactive({});
let rules = reactive([]);
function addEvent() {}
function handleEdit(index: any, row: any) {}
// 删除
function handleDelete(index: any, row: any) {
  if (typeValue.value == "repair") {
    console.log(index, row);
    http.delete("/repairs/" + row.id).then((res) => {
      console.log(res);
      getEventList();
    });
    ElMessage({
      message: "删除成功",
      type: "success",
    });
  }
}

onMounted(() => {
  getEventList();
});
</script>
