<template>
    <div style="background-color: darkgray; display: inline-block; width: 400px; height: 500px;">
 <br>
<br>
<br>
<br>
<br>
<div v-if="ee" v-show="cc"> <h1 style="padding: 20px;"  >10까지..눌러야 겠찌?</h1>
<p>콘솔로그에 놀라운 일이....</p>
</div>
  
<br>
<br>
<br>
<br>
<br>
   <button style="padding: 20px;" @click="bb" v-show="tt">눌러보기</button>
   <p  v-show="tt">{{count}}</p>
   <br>
<br>
   <br>
   <h1 style="display: inline-block; border: 1px solid black; background-color: yellow;">{{text}}</h1>
    </div>
</template>

<script setup>
import { ref } from 'vue';

const cc = ref(true);
const ee = ref(true);
let count = ref(0);
const text = ref('');

const tt = ref(true)


   



const bb = () => {
    count.value++;
    setTimeout(() => {
        console.log(`괴도등장!===>{${count.value}}`)
    }, 2000);
    
    ee.value = !ee.value

    if(count.value==10){

text.value = "빰빠밤!!괴도등장!!";
ee.value = false;
    tt.value = false;
    }

}

</script>

<style lang="scss" scoped>

</style>