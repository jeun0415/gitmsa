<template>
  <div>
<h1>ㅎㅎ</h1>
<br>
<br>
<RouterView />
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router';


const router = useRouter();

const runingbtn = () => {

  router.push({name:'gbbtn'})

}


runingbtn();


</script>

<style lang="scss" scoped>

</style>