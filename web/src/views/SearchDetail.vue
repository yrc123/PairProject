<template>
  <div class="searchPage">
    <SearchHeader style="position:fixed;width:100%;top:0;height:50px;padding-top:14px;"/>
    <div class="detail">
       <div style="background-color:pink;height:5000px;z-index:0" >123123</div>
    </div>

    <Footer/>
  </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'
import Footer from '@/components/Footer.vue'
import SearchHeader from '@/components/SearchHeader.vue'
export default {
  name: 'SearchDetail',
  components: {
    //HelloWorld,
    Footer,
    SearchHeader,
  },
  

}
</script>

<style>
.detail {
  margin-top: 70px;
}
::-webkit-scrollbar { width: 0 !important }
</style>