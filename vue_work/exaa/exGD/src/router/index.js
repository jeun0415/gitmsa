import { createRouter, createWebHistory } from 'vue-router'

import GBbtn from '@/views/GBbtn.vue';







const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/GBbtn',
      name: 'gbbtn',
      component: GBbtn
    },
   ]
  }
 )

export default router
