<template>
    <div class="myChart" ref="chart"></div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import * as echarts from "echarts";
const chart = ref<any>(null);

console.log(chart);
// 绘制图表
setTimeout(() => {
    chart.value = echarts.init(chart.value!);
    chart.value.setOption({
        title: { text: "总用户量" },
        tooltip: {},
        xAxis: {
            data: ["12-3", "12-4", "12-5", "12-6", "12-7", "12-8"],
        },
        yAxis: {},
        series: [
            {
                name: "用户量",
                type: "line",
                data: [5, 20, 36, 10, 10, 20],
            },
        ],
    });
})

</script>


<style scoped>
.myChart {
    height: 400px;
}
</style>