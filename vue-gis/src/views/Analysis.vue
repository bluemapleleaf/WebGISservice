<template>
    <div class="myChart" ref="charts"></div>
</template>

<script setup lang="ts">
import {ref} from "vue";
import http from "../utils/http";
import * as echarts from "echarts";
// 图表DOM
const charts = ref<any>(null);
console.log(charts);
let Option = {
    title: {
        top: 0,
        left: 'center',
        text: '武汉大学修理统计'
    },
    legend: {
        top: 'bottom'
    },
    toolbox: {
        show: true,
        feature: {
            mark: {show: true},
            dataView: {show: true, readOnly: false},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    series: [
        {
            name: 'Nightingale Chart',
            type: 'pie',
            radius: [50, 250],
            center: ['50%', '50%'],
            roseType: 'area',
            itemStyle: {
                borderRadius: 8
            },
            data: [
                {value: 40, name: 'rose 1'},
                {value: 38, name: 'rose 2'},
                {value: 32, name: 'rose 3'},
                {value: 30, name: 'rose 4'},
                {value: 28, name: 'rose 5'},
                {value: 26, name: 'rose 6'},
                {value: 22, name: 'rose 7'},
                {value: 18, name: 'rose 8'}
            ]
        }
    ]
};
drawChart(charts, Option)


// 绘制图表
function drawChart(chartDOM: any, option: any) {
    setTimeout(() => {
        chartDOM.value = echarts.init(chartDOM.value!);
        chartDOM.value.setOption(option);
    })
}
</script>


<style scoped>
.myChart {
    height: 600px;
}
</style>