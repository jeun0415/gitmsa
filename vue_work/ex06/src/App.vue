<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <!-- <h1 class="aaa">test</h1> -->
    <div class="p-5 bg-orange-400 text-white text-3xl">
      <nav class="flex space-x-5">
        <div>
          <RouterLink to="/">Home</RouterLink>
        </div>
        <div>
          <RouterLink to="/Userlist">User</RouterLink>
        </div>
        <div class="group relative">
          <RouterLink to="/freeboardlist">FreeBoard</RouterLink>
          <div class="hidden group-hover:block absolute bg-orange-400 p-5 top-8 -left-5 rounded">
            <div>
              <RouterLink to="/freeboardlist">FreeBoardList</RouterLink>
            </div>
            <div>
              <RouterLink to="/freeboardinput">FreeBoardInput</RouterLink>
            </div>
          </div>
        </div>
        <!-- <div>
          <RouterLink to="/fileupload">FileUpload</RouterLink>
        </div> -->
        <div>
          <RouterLink to="/fileuploads">FileUploads</RouterLink>
        </div>
        <div>
          <RouterLink to="/filedownload">FileDownload</RouterLink>
        </div>
        <!-- <div>
          <RouterLink to="/fileuploads">fileuploads</RouterLink>
        </div>
        <div>
          <RouterLink to="/fileupload">filedownload</RouterLink>
        </div> -->
      </nav>
    </div>
    <RouterView />
  </header>
</template>

<style scoped></style>
