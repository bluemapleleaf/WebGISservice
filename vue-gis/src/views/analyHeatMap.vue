<template>
  <div id="myChart" class="myChart" ref="chart" style="width: 600px" :key="chartKey"></div>
  <div id="filterArea" class="filterArea">
    <div class="title">事件类型</div>
    <el-select v-model="type" placeholder="Select" id="typeSelect">
      <el-option
        v-for="item in typeList"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      />
    </el-select>
    <div class="title">提交时间</div>
    <el-select v-model="year" placeholder="Select" id="yearSelect">
      <el-option
        v-for="item in yearList"
        :key="item.value"
        :value="item.value"
        :label="item.label"
      />
    </el-select>

    <el-button type="primary" @click="updateData" class="searchBtn">
      <el-icon style="vertical-align: middle;">
        <search />
      </el-icon>Search
    </el-button>
  </div>
</template>

<script lang="ts">
import { ref, defineComponent, reactive, onMounted, toRefs } from "vue";
import http from "../utils/http";
import "ol/ol.css";
import Map from "ol/Map";
import {
  Heatmap as HeatmapLayer,
  Tile as TileLayer,
  Vector as VectorLayer,
} from "ol/layer";
import XYZ from "ol/source/XYZ";
import View from "ol/View";
import { fromLonLat } from "ol/proj.js";
import point from "ol/geom/Point";
import Feature from "ol/Feature";
import VectorSource from "ol/source/Vector";
import { Search } from '@element-plus/icons-vue'


export default {
  name: "Param",
  setup() {
    const dataType = reactive({
      loading: false,
      year: 0,
      type: 0,
      chartKey: 0,
      yearList: [
        {
          value: 0,
          label: "全部",
        },
        {
          value: 2018,
          label: "2018年",
        },
        {
          value: 2019,
          label: "2019年",
        },
        {
          value: 2020,
          label: "2020年",
        },
        {
          value: 2021,
          label: "2021年",
        },
      ],
      typeList: [
        {
          value: 0,
          label: "全部",
        },
        {
          value: 1,
          label: "木",
        },
        {
          value: 2,
          label: "水",
        },
        {
          value: 3,
          label: "电",
        },
      ],
    });

    onMounted(() => {
      initMap();
    });

    //绘制热力图
    const setHeatMap = (coordinates: Array<Array<number>>) => {
      // 构造热力图数据
      var _coordinates = coordinates;
      let features = [];
      for (let idx = 0; idx < _coordinates.length; ++idx) {
        let feature = new Feature({
          geometry: new point([_coordinates[idx][0], _coordinates[idx][1]]),
        });
        features.push(feature);
      }
      let heatmapVector = new VectorSource({
        features: features,
      });

      //   绘制热力图图层
      var heatmap = new HeatmapLayer({
        source: heatmapVector,
        blur: 5,
        radius: 8,
        weight: function (feature) {
          return 0.5;
        },
      });
      //请求高德图层
      var AMapLayer = new TileLayer({
        source: new XYZ({
          url: "http://wprd0{1-4}.is.autonavi.com/appmaptile?lang=zh_cn&size=1&style=7&x={x}&y={y}&z={z}",
        }),
      });
      //将图层添加到map对象中
      var map = new Map({
        layers: [AMapLayer, heatmap],
        target: "myChart",
        view: new View({
          center: [114.363374, 30.539491],
          zoom: 14.5,
          minZoom: 4,
          maxZoom: 20,
          projection: "EPSG:4326",
        }),
      });
    };
    const initMap = (year: number = 0, type: number = 0) => {
      http.get("/api/repairs?pageNum=1&pageSize=1000").then((res) => {
        var data = eval(res.data.data.records);
        if (year != 0) {
          data = data.filter(function (element: any) {
            return element.applyDate.substr(0, 4) == year;
          });
        }
        if (type != 0) {
          data = data.filter(function (element: any) {
            var repairType = dataType.typeList[type + 1].label;
            return element.title == repairType;
          });
        }
        var coordinates = [];
        for (let idx = 0; idx < data.length; ++idx) {
          coordinates.push([data[idx].longitude, data[idx].latitude]);
        }
        setHeatMap(coordinates);
      });
    };
    function updateData() {
      dataType.chartKey += 1;
      var _dataType = dataType;
      initMap(_dataType.year, _dataType.type);
    };
    return {
      ...toRefs(dataType),
      setHeatMap,
      initMap,
      updateData,
    };
  },
};
</script>


<style scoped>
.myChart {
  height: 600px;
  position: absolute;
  left: 300px;
}
.filterArea {
  height: 200px;
  width: 200px;
  background-color: rgba(127, 255, 212, 0.5);
  padding: 20px;
  position: relative;
  left: 750px;
  top: 140px;
}
.title {
  font-size: 10px;
  margin: 20px 50px 0 50px;
}
.searchBtn {
  margin: 20px;
  position: inherit;
  left: 80px;
}
</style>