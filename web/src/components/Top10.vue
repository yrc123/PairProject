<template>

  <div>
    <div id="myChart"
     :style="{ width: '50%', height: '500px' }"></div>
  </div>
</template>

<script>
import { inject, onMounted } from "vue";
import axios from 'axios'
import QS from 'qs'
var x=new Array();
for(var i=1;i<=10;i++)x.push("热词"+i);
export default {
  name: "data_page",
  setup() {

    let echarts = inject("ec");//引入
    onMounted(() => {//需要获取到element,所以是onMounted的Hook
        var list= postHeader(true);
    console.log(list);
      let myChart = echarts.init(document.getElementById("myChart"));
      // 绘制图表
      myChart.setOption({
        title: { text: "总用户量" },
           tooltip: {
          trigger: 'axis',
          enterable: true,
          alwaysShowContent: true,
          formatter: function (params, ticket, callback) {
               var res='';
               res+="热词："+params[0].name+"<br/>";
               res+="频次："+params[0].value+"<br/>";
               res+="相关论文<br/>";
               for(i=1;i<=10;i++){
                    res+="<a href='#'>论文"+i+"</a><br/>"
               }
               return res;
          },
          position:function(point){
               return {
                    left:point[0],
                    top:0,
               }
          }
     },
      toolbox: {
          show: true,
          feature: {
               dataView: {
                    readOnly: false
               },
               magicType: {
                    type: ["line", "bar"]
               },
               restore: {},
               saveAsImage: {}
          }
     },
     legend: {
          data: ['热词']
     },
     xAxis: {
          type: 'category',
          data: x,
     },
     yAxis: {
          type: 'value'
     },
     dataZoom: [
          {
               type: 'slider',
               show: true,
               xAxisIndex: [0],
               start: 1,
               end: 100
          },
          {
               type: 'slider',
               show: true,
               yAxisIndex: [0],
               left: '93%',
               start: 1,
               end: 100
          },
          {
               type: 'inside',
               xAxisIndex: [0],
               start: 1,
               end: 100
          },
          {
               type: 'inside',
               yAxisIndex: [0],
               start: 1,
               end: 1
          }
     ],
     series: [{
          color:"#409eff",
          name: '热词',
          data: [150,130,80,70,60,50,40,38,35,30],
          type: 'bar'
     }]
      },true);
      window.onresize = function () {//自适应大小
        myChart.resize();
      };
    });
      /**
      * post方法，对应post请求
      * @param {String} url [请求的url地址]
      * @param {Object} params [请求时携带的参数]
      * @param {Boolean} json [true：json格式请求头；false：FormData格式请求头]
      */
        function post(url, params = {}, json = false) {
        // json格式请求头
        const headerJSON = {
          "Content-Type": "application/json"
        };
        // FormData格式请求头
        const headerFormData = {
          "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"
        };
        return new Promise((resolve, reject) => {
          axios
            .post(url, json ? JSON.stringify(params) : QS.stringify(params), {
              headers: json ? headerJSON : headerFormData
            })
            .then(res => {
              resolve(res.data);
            })
            .catch(err => {
              reject(err.data);
            });
        });
      }
      // post接口封装：
      // json或FormData格式请求头测试接口
        function  postHeader( isJson) {
          return  post('http://106.15.74.153:8080/api/top10', isJson);
      }
      return{
        postHeader,
        post,
      };
  },
  components: {},
  mounted() {},
};
</script>