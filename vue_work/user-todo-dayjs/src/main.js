import './assets/main.css';

import { createApp } from 'vue';
import { createPinia } from 'pinia';

import App from './App.vue';
import router from './router';

const app = createApp(App);

app.use(createPinia());
app.use(router);

// 사용하려는 앱의 JS키 입력
window.Kakao.init('1692f4090898eb1a60d5c44c13a050e5');

app.mount('#app');
