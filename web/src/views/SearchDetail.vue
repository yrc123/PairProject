<template>
  <div class="searchPage">
    <SearchHeader/>
    <div style="background-color:black;height:5000px" >123123</div>
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
