<template>
  <div>
      <Header/>
    <router-link to="/HotWords"><span>HotWords</span></router-link>|
    <router-link to="/Top10"><span>Top10</span></router-link>
    <router-view/>
    <Footer style="position:fixed"/>
  </div>
</template>

<script>
import Footer from '@/components/Footer.vue'
import Header from '@/components/Header.vue'
import Top10 from '@/components/Top10.vue'
import HotWords from '@/components/HotWords.vue'

export default {
  name: 'HotAreas',
  components: {
    //HelloWorld,
    Footer,
    Header,
    Top10,
    HotWords,
  }
}
</script>

<style>

</style>