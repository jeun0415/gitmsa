import './assets/main.css';

import { createApp } from 'vue';
import { createPinia } from 'pinia';

import App from './App.vue';
import router from './router';

// FontAwesome 관련 import
import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

// 사용할 아이콘들 import
import { faCalendarAlt, faBook, faUsers, faCog, faSignInAlt, faSearch, faCheck, faTimes, faBookmark, faAngleLeft, faAngleRight } from '@fortawesome/free-solid-svg-icons'; // 일반 아이콘 import

// 아이콘들을 라이브러리에 추가

library.add(faCalendarAlt, faBook, faUsers, faCog, faSignInAlt, faSearch, faCheck, faTimes, faBookmark, faAngleLeft, faAngleRight);


// Vue 앱 생성
const app = createApp(App);

// FontAwesomeIcon을 전역 컴포넌트로 등록
app.component('FontAwesomeIcon', FontAwesomeIcon);

// Pinia와 Router 등록
app.use(createPinia());
app.use(router);

// todo
window.Kakao.init('2515f45fc0d9a50bfeee4e2db7c37005');

// 앱 마운트
app.mount('#app');
