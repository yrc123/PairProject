<template>
<div class="SearchView">
    <img alt="PaperRetriveal logo" src="../assets/PaperRetriveal.png" class="logo" >
    <!-- <div><el-input v-model="input" placeholder="支持关键字、论文编号检索" id="seachBox"></el-input>
        <el-button type="primary">主要按钮</el-button>
    </div> -->
    <div style="height:54px;">
        <!-- <el-input v-model="input" placeholder="支持关键字、论文编号检索" id="seachBox" style="width:500px;height:100%;"></el-input> -->
         <el-autocomplete
            class="inline-input"
             v-model="state2"
             :fetch-suggestions="querySearch"
              placeholder="支持关键字、论文编号检索"
             :trigger-on-focus="false"
            @select="handleSelect"  style="width:500px;height:100%" id="searchBox"></el-autocomplete>
        <el-button type="primary" style="" id="searchButton"><span style="position:relative;top:-2px;">论文检索</span></el-button>
    </div>
    
</div>
</template>
<style>
.logo{
    width: 520px;
    height: 70px;
    margin-top:80px;
    margin-bottom:30px;
}
#searchBox{
    border-top-left-radius: 10px;
    border-top-right-radius: 0px;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 0px;
    border-right: none;
    font-size: 16px;
}
#searchButton{
    border-top-left-radius: 0px;
    border-top-right-radius: 10px;
    border-bottom-left-radius: 0px;
    border-bottom-right-radius: 10px;
    height:36px;
    color:#ffffff;
    font-weight: bold;
    font-size: 20px;
    text-align:center;
    vertical-align:middle ;
    position: relative;
    top:-1.5px;
}
</style>
<script>
import { defineComponent, ref, onMounted } from 'vue'

export default defineComponent({
  setup() {
    const restaurants = ref([]);
    const querySearch = (queryString, cb) => {
      var results = queryString
        ? restaurants.value.filter(createFilter(queryString))
        : restaurants.value;
      // 调用 callback 返回建议列表的数据
      cb(results);
    };
    const createFilter = (queryString) => {
      return (restaurant) => {
        return (
          restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) ===
          0
        );
      };
    };
    const loadAll = () => {
      return [
        { value: "三全鲜食（北新泾店）", address: "长宁区新渔路144号" },
        {
          value: "Hot honey 首尔炸鸡（仙霞路）",
          address: "上海市长宁区淞虹路661号",
        },
        {
          value: "新旺角茶餐厅",
          address: "上海市普陀区真北路988号创邑金沙谷6号楼113",
        },
      ];
    };
    const handleSelect = (item) => {
      console.log(item);
    };
    onMounted(() => {
      restaurants.value = loadAll();
    });
    return {
      restaurants,
      state1: ref(''),
      state2: ref(''),
      querySearch,
      createFilter,
      loadAll,
      handleSelect,
    };
  },
});
</script>