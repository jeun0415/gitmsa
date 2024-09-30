import { createRouter, createWebHistory } from 'vue-router';
import TheHome from '../views/TheHome.vue';
import TheUserList from '../views/users/TheUserList.vue';

import TheFreeBoardInput from '../views/freeboard/TheFreeBoardInput.vue';
import TheFreeBoardList from '../views/freeboard/TheFreeBoardList.vue';
import TheFreeBoardView from '../views/freeboard/TheFreeBoardView.vue';
import TheFreeBoardUpdate from '@/views/freeboard/TheFreeBoardUpdate.vue';

import TheFileUpload from '@/views/TheFileUpload.vue';

import TheUserInsert from '@/views/users/TheUserInsert.vue';
import TheUserUpdate from '@/views/users/TheUserUpdate.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: TheHome
    },
 
    {
      path: '/freeboardinput',
      name: 'freeboardinput',
      component: TheFreeBoardInput
    },
    {
      path: '/freeboardupdate',
      name: 'freeboardupdate',
      component: TheFreeBoardUpdate
    },
    {
      path: '/freeboardlist',
      name: 'freeboardlist',
      component: TheFreeBoardList
    },
    {
      path: '/freeboardview/:idx',
      name: 'freeboardview',
      component: TheFreeBoardView
    },
    {
      path: '/Userinsert',
      name: 'userinsert',
      component: TheUserInsert
    },
    {
      path: '/Userlist',
      name: 'userlist',
      component: TheUserList
    },
    {
      path: '/UserUpdate',
      name: 'userupdate',
      component: TheUserUpdate
    },
    {
      path: '/FileUpload',
      name: 'fileupload',
      component: TheFileUpload
    },

  ]
});

export default router;
