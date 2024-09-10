<template>
  <div>
    <h1>HOME</h1>
    <ul>
      <li v-for="user in list" v-bind:key="user.idx">
        idx = {{  user.idx }}
        name = {{  user.name }}
      </li>
    </ul>
    <button @click="select" class="bg-yellow-200 p-3 m-3 hover:bg-yellow-400 border border-gray-200">불러오기</button>
    <div v-for="num in mylist" v-bind:key="num">
      num = {{ num }}
    </div>
  </div>
</template>

<script>
import { ref } from 'vue'

export default {
  setup() {
    const mylist = [10,20,30];
    const list = ref([
      {
        idx: 1,
        name: '탁길동',
        age: 84,
        email: 'hoh@naver.com',
        password: 'good',
        wdata: null
      },
      {
        idx: 2,
        name: '정길동',
        age: 84,
        email: 'ho@naver.com',
        password: 'good',
        wdata: null
      },
      {
        idx: 3,
        name: '이길동',
        age: 84,
        email: 'hoho123@naver.com',
        password: 'good',
        wdata: null
      }
    ]);
    const select = ()=>{
      list.value = [{idx:1, name:"강제로 바꿈"}];
    }

    // fetch(`127.0.0.1:8080/user/select`)
    return { list, mylist, select }
  }
}
</script>

<style lang="scss" scoped></style>
