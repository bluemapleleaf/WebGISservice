<template>
    <el-menu default-active="/usermanage" class="el-menu-vertical-demo" router>
        <el-menu-item index="/usermanage">
            <el-icon>
                <avatar/>
            </el-icon>
            <template #title>我的</template>
        </el-menu-item>

        <el-menu-item index="/eventlist">
            <el-icon>
                <document/>
            </el-icon>
            <template #title>事件列表</template>
        </el-menu-item>
        <el-menu-item index="/eventmap">
            <el-icon>
                <location/>
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
        <template #title>
          事件分布热力图
        </template>
      </el-menu-item>
    </el-sub-menu>
  </el-menu>

</template>

<script setup lang="ts">
import {
    Location,
    Document,
    ChatDotSquare,
    Avatar,
    DataAnalysis
} from "@element-plus/icons-vue";
</script>

<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 100vh;
}
</style>
