
<template>
    <div class="block">
        <el-carousel height="150px">
            <el-carousel-item v-for="item in 4" :key="item">
                <h3 class="small">{{ item }}</h3>
            </el-carousel-item>
        </el-carousel>
    </div>
    <el-table :data="tableData.data" style="width: 100%" fit>
        <el-table-column prop="title" label="标题" />
        <el-table-column prop="content" label="内容" />
        <el-table-column prop="comment" label="评论" />
        <el-table-column prop="applyId" label="apply_id" />
        <el-table-column prop="checkId" label="check_id" />
        <el-table-column prop="applyDate" label="创建日期" />
        <el-table-column prop="publishDate" label="发布日期" />
        <el-table-column prop="state" label="状态" />
        <el-table-column label="操作">
            <el-button type="primary" :icon="Edit" circle @click="test"></el-button>
            <el-button type="danger" :icon="Delete" circle @click="test"></el-button>
        </el-table-column>
    </el-table>
</template>

<script setup lang="ts">
import { reactive } from 'vue'
import http from '../utils/http'
import { Edit, Delete } from '@element-plus/icons-vue'

let tableData = reactive({
    data: [],
})

function getAnnouncement(page: number, pagesize: number, search: string) {
    http.get("/api/announcements", {
        params: {
            pageNum: page,
            pageSize: pagesize,
            search: search
        }
    }).then(res => {
        tableData.data = res.data.data.records
    })
}
getAnnouncement(1, 50, "")

function test() {
    console.log("test")
}
</script>

<style scoped>
.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
    text-align: center;
}
a .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
    background-color: #d3dce6;
}
.el-table .warning-row {
    --el-table-tr-bg-color: var(--el-color-warning-lighter);
}
.el-table .success-row {
    --el-table-tr-bg-color: var(--el-color-success-lighter);
}
</style>