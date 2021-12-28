<template>
  <div id="lostType" ref="lostType" class="myChart" />
  <div id="lostArea" ref="lostArea" class="myChart" />
  <div id="lostYear" ref="lostYear" class="myChart" />
</template>

<script setup lang="ts">
import { ref } from "vue";
import * as echarts from "echarts";
import http from "../utils/http";

var placeList = [
  "武汉大学医学部",
  "武汉大学工学部",
  "武汉大学文理学部",
  "武汉大学信息学部",
];
var contentList = ["一卡通", "书本", "其他", "手机", "钱包"];
var yearList = ["2018", "2019", "2020", "2021"];
function countList(data: any, param: String) {
  var countResult = [];
  if (param == "content") {
    var list = contentList;
    for (let idx = 0; idx < list.length; ++idx) {
      var countNum = 0;
      for (let j = 0; j < data.length; ++j) {
        if (data[j].content == list[idx]) {
          ++countNum;
        }
      }
      countResult.push({
        name: list[idx],
        value: countNum,
      });
    }
  } else if (param == "place") {
    var list = placeList;
    for (let idx = 0; idx < list.length; ++idx) {
      var countNum = 0;
      for (let j = 0; j < data.length; ++j) {
        if (data[j].place == list[idx]) {
          ++countNum;
        }
      }
      countResult.push({
        name: list[idx],
        value: countNum,
      });
    }
  } else if (param == "year") {
    var list = yearList;
    var countList = [];
    for (let idx = 0; idx < list.length; ++idx) {
      var countNum = 0;
      console.log(list[idx]);
      for (let j = 0; j < data.length; ++j) {
        if (data[j].applyDate.substr(0, 4) == list[idx]) {
          ++countNum;
        }
      }
      countList.push(countNum);
    }
    countResult.push(countList)
    countResult.push(list)
  }
  return countResult;
}

const lostArea = ref<any>(null);
const lostType = ref<any>(null);
const lostYear = ref<any>(null);
setTimeout(() => {
  //@js-ignore
  lostArea.value = echarts.init(lostArea.value!);
  lostType.value = echarts.init(lostType.value!);
  lostYear.value = echarts.init(lostYear.value!);
  http.get("/api/lostandfounds?pageNum=1&pageSize=1000").then((res) => {
    var data = eval(res.data.data.records).filter(function (element: any) {
      return element.title == "丢失";
    });
    var objectLost = data.filter(function (element: any) {
      return element.state == 0;
    });
    // 丢失类型
    var dataLostType = countList(data, "content");
    lostType.value.setOption({
      title: { text: "丢失类型" },
      series: [
        {
          type: "pie",
          data: dataLostType,
        },
      ],
    });
    // 丢失地区
    var dataLostArea = countList(data, "place");
    lostArea.value.setOption({
      title: { text: "丢失地区分布" },
      series: [
        {
          type: "pie",
          data: dataLostArea,
        },
      ],
    });

    // 不同年份丢失物品类型
    var dataLostYear = countList(data, "year");
    lostYear.value.setOption({
      title: { text: "每年丢失数量变化" },
      xAxis: {data: dataLostYear[1]},
      yAxis: {},
      series: [
        {
          type: "line",
          data: dataLostYear[0]
        },
      ],
    });
  });
});
</script>


<style scoped>
.myChart {
  height: 600px;
  width: 600px;
}
</style>