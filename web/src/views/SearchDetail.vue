<template>
  <div class="searchPage">
    <div style="z-index:2;position:fixed;" id="scroll">1111</div>
    <SearchHeader style="position:fixed;width:100%;top:0;
                height:50px;padding-top:14px;z-index:1;
                box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)"
                 @inputValue="getInputValue"/>
    <div class="detail">
       <div style="margin-left:100px;margin-bottom:10px;" >
         <span style="color:#7F7F7F;font-size:12px;float:left;">共搜索到{{count}}条记录</span>
         <div style="font-size:16px" class="tool" @click="showTool = !showTool"><i class="el-icon-setting"></i><span>筛选工具</span></div>
         </div>
       <div style="height:1600px;z-index:0; margin-left:100px" >
        <PaperItem  :paperPost="paper" v-for="paper in paperList"/>
        
       </div>
       <el-collapse-transition>
       <div class="toolBar" v-show="showTool">
         <div class="label" style="margin-top:30px"><i class="el-icon-sort"></i><span>排序方式</span>
            <el-select v-model="orderBy" clearable placeholder="默认" style="width:150px;">
            <el-option
              v-for="item in orderByOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
         </div>
         <div class="label"><i class="el-icon-time"></i><span>时间性&nbsp;&nbsp;&nbsp;</span>
          <el-select v-model="time" clearable placeholder="默认" style="width:150px;">
            <el-option
              v-for="item in timeOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
         </div>
         <div class="label"><i class="el-icon-sugar"></i><span>来源过滤</span>
          <el-select v-model="from" clearable placeholder="默认" style="width:150px;">
            <el-option
              v-for="item in fromOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
         </div>
            <div style="margin-top:20px;padding:0 60px;"><el-button type="primary" plain 
                style="width:100%;font-size:14px;"
                @click="searchAgain">
              <i class="el-icon-coffee-cup"></i>
              <span>重新搜索</span></el-button></div>
       </div>
       </el-collapse-transition>
      <div class="block">
        <el-pagination
          layout="prev, pager, next"
          :total="1000">
        </el-pagination>
      </div>
    </div>
    <Footer/>
  </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'
import Footer from '@/components/Footer.vue'
import SearchHeader from '@/components/SearchHeader.vue'
import PaperItem from '@/components/PaperItem.vue'
import { onBeforeMount,onMounted,provide} from 'vue'
import axios from 'axios'
export default {
  name: 'SearchDetail',
  components: {
    //HelloWorld,
    Footer,
    SearchHeader,
    PaperItem,
  },
  data(){
    return{
      count:0,
      test:"111",
      //paper:[1],
      paperList:[1],
      showTool:false,
      orderBy:null,
      orderByOptions:[{
              value:'0',
              label:"最相关",
          },{
              value:'1',
              label:"最新",
          }],
      
      time:null,
      timeOptions:[{
         value:'1',
         label:"近一年"
       },{
         value:'3',
         label:"近三年"
       },{
          value:'5',
         label:"近五年"
       },{
          value:'10',
         label:"近十年"
       }],

       from:null,
       fromOptions:[{
         value:'2',
         label:"CPVR"
       },{
         value:'1',
         label:"ICCV"
       },{
          value:'3',
         label:"ECCV"
       }],
    }
  },
  methods:{
    searchAgain(){
      var newURL=window.location.pathname;
      newURL+="?searchWord=";
      newURL+=window.location.search.match('((?<=searchWord=).*?(?=&|$))')[0];
      newURL+="&orderBy="+this.orderBy+"&time="+this.time+"&meetId="+this.from;
      console.log(newURL);
      window.location.href=newURL;
    },
    getCount(){
            var getString="http://106.15.74.153:8080/api/search_paper";
            getString+=window.location.search;
            axios.get(getString).then(response => {
                 var list=response.data.data;
                 this.paperList=list.paperList;
                 this.count=list.count;
                 console.log(list.paperList[0])
                 this.paper=list.paperList[0] ;
      });
    }

  },
  created(){
    this.getCount();
  },

  setup(context){
      
      var flag=false;
      function getInputValue(val){
          var newURL=window.location.pathname;
          newURL+="?searchWord=";
          //newURL+="&orderBy=";
          console.log(context.root.orderBy);
          newURL+=val;
          window.location.href=newURL;
      }
      function searchItem(input){
        var list;
        getString+=input;
        getString+="&time=5&limit=9&page=0";

      }
      return{
          getInputValue,
          flag,
      }
  }

}
</script>

<style>
.detail {
  margin-top: 70px;
}
::-webkit-scrollbar { width: 0 !important }
.tool{
  user-select: none;
  transition: 0.3s;
}
.tool:hover{
  color:#409eff;
}
.toolBar{
  height:270px;
  width:280px;
  background:white;
  position:fixed;
  left:74%;
  top:150px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  border-radius: 10px;
  font-size:16px;
  color:#777777;
}
.label{
  margin-top:10px;
}
.label>span{
  margin-right: 10px;
}
</style>
