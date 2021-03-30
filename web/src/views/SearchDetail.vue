<template>
  <div class="searchPage">
    <div style="z-index:2;position:absolute;top:0px;" id="scroll"></div>
    <SearchHeader style="position:fixed;width:100%;top:0;
                height:50px;padding-top:14px;z-index:1;
                box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)"
                 @inputValue="getInputValue"/>
    <div class="detail">
       <div style="color:#7F7F7F;font-size:12px; display:flex; margin-left:100px;margin-bottom:10px;" >共搜索到{{count}}条记录</div>
       <div style="height:1600px;z-index:0; margin-left:100px" >
        <PaperItem  :paperPost="paper" v-for="paper in paperList"/>
        
       </div>
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
    }
  },
  methods:{
    
    getCount(){
            var getString="http://106.15.74.153:8080/api/search_paper";
            getString+=window.location.search;
            getString+="&time=5&limit=9&page=0";
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
</style>
