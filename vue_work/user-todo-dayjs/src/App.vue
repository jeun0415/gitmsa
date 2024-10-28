<script setup>
import { RouterView } from 'vue-router';

// nav 위치 설정
import TheLayoutNav from './components/TheLayoutNav.vue';
</script>

<template>
	<TheLayoutNav />

	<RouterView />
</template>

<style scoped></style>
