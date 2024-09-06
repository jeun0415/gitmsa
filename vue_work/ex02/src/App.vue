<template>
  <div>
    <TheNav></TheNav>
    <RouterView></RouterView>
    <!-- <TheCounter></TheCounter>
    <TheCounter></TheCounter>
    <TheCounter></TheCounter> -->
    <AA></AA>
  </div>
</template>

<script>
// import TheCounter from './views/TheCounter.vue';
import TheNav from './views/TheNav.vue';
import AA from './views/AA.vue';
import { RouterView } from 'vue-router';
export default {
  components:{
    // TheCounter,
    AA,
    RouterView,
    TheNav
  },
  setup () {

    return { // TheCounter, 
      AA, RouterView, TheNav }
  }
}
</script>

<style lang="scss" scoped>

</style>