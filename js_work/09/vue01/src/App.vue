<script setup>
const myarr = [
  { age: 20, name: "고길동" },
  { age: 7, name: "최포미" },
  { age: 1, name: "임예서" },
];
</script>

<template>
  <div>
    <h1>안녕 VUE</h1>
    <div>{{ myarr }}</div>

    <div v-for="item in myarr" v-bind:key="item">
      <h1 style="color: blue">나이: {{ item.age }} 이름: {{ item.name }}</h1>
    </div>
  </div>
</template>

<style scoped></style>
