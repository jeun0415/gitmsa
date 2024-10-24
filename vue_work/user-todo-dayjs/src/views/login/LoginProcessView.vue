<template>
	<div class="flex flex-col justify-center items-center min-height-80">
		<h1>Oauth</h1>
		<template v-if="useStore.loginCheck">
			<div>
				<h1>로그인에 성공하셨습니다.</h1>
				<router-link to="/">홈으로</router-link>
			</div>
		</template>
		<!-- <template v-else>
			<div>
				<h1>로그인하세요.</h1>
			</div>
		</template> -->
	</div>
</template>

<script setup>
import { login, loginCheck } from '@/api/loginApi';
import { useUserStore } from '@/stores/user';
import { watchEffect } from 'vue';
import { useRoute } from 'vue-router';

const useStore = useUserStore();
const route = useRoute();

watchEffect(async () => {
	// console.log('code = ', route.query.code);
	if (route.query.code) {
		await login(route.query.code);
		const res = await loginCheck();
		console.log(res);
		if (res.status.toString().startsWith('2')) {
			console.log(res.data);
			useStore.login(res.data);
		}
	}
});
</script>

<style lang="scss" scoped></style>
