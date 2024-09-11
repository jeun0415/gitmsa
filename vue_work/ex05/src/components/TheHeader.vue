<template>
  <div>
    <h1>TheHeader</h1>
    <RouterLink to="/">Home</RouterLink>
    <RouterLink to="/join">Join</RouterLink>
    <RouterLink to="/about">About</RouterLink>
  </div>
</template>

<script setup>
import { RouterLink } from "vue-router";
</script>

<style lang="scss" scoped></style>
