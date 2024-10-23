import './assets/main.css';

import { createApp } from 'vue';
import { createPinia } from 'pinia';

import App from './App.vue';
import router from './router';

const app = createApp(App);

app.use(createPinia());
app.use(router);

// 사용하려는 앱의 JS키 입력
window.Kakao.init('f4112a126c4633ffe4599b9f93cf66dd');

app.mount('#app');
