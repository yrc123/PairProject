<template>
  <div class="searchPage">
    <Header/>
    <SearchView/>
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <Footer/>
  </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'
import Footer from '@/components/Footer.vue'
import Header from '@/components/Header.vue'
import SearchView from '@/components/SearchView.vue'

export default {
  name: 'SearchPage',
  components: {
    //HelloWorld,
    Footer,
    Header,
    SearchView,
  }
}
</script>
