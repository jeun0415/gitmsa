import './assets/main.css'

// import {aa} from './AA';
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

// aa();

const app = createApp(App)

app.use(router)

app.mount('#app')
