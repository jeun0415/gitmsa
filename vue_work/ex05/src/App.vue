<template>
<div>
  <h1>{{ myVar }}</h1>
    <TheHeader />
  <div class="flex items-center justify-center">
    <RouterView></RouterView>
  </div>
  </div>
</template>

<script setup>
import TheHeader from './components/TheHeader.vue';
import { RouterView } from 'vue-router';
const myVar = "안녕하세요";
</script>

<style lang="scss" scoped></style>
