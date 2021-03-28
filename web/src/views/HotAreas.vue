<template>
  <div>
    <Header/>
    <Top10/>
    <Footer/>
  </div>
</template>

<script>
import Footer from '@/components/Footer.vue'
import Header from '@/components/Header.vue'
import Top10 from '@/components/Top10.vue'

export default {
  name: 'HotAreas',
  components: {
    //HelloWorld,
    Footer,
    Header,
    Top10,
  }
}
</script>

<style>

</style>