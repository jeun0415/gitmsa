<template>
  <div>
    <h1 class="h1-green">FreeBoardList</h1>
    <div class="px-5">
      <table class="border border-b-gray-500 w-full">
        <thead>
          <tr>
            <th class="border">IDX</th>
            <th class="border">title</th>
            <th class="border">author</th>
            <th class="border">regdate</th>
            <th class="border">viewcount</th>
            <th class="border">img</th>
          </tr>
        </thead>
        <tbody>
          <template v-if="arr && arr.length > 0">
            <tr
              v-for="item in arr"
              :key="item.idx"
              class="cursor-pointer hover:bg-slate-300"
              @click="viewPage(item.idx)"
            >
              <td class="border text-center text-lg p-1">{{ item.idx }}</td>
              <td class="border text-center text-lg p-1">{{ item.title }}</td>
              <td class="border text-center text-lg p-1">{{ item.creAuthor }}</td>
              <td class="border text-center text-lg p-1">{{ item.regDate }}</td>
              <td class="border text-center text-lg p-1">{{ item.view_count }}</td>
              <template v-if="item.list[0]">
                <td class="border text-center text-lg p-1">
                  <img :src="`${GLOBAL_URL}/file/download/${item.list[0].name}`" alt="" srcset="" width="150">
                </td>
              </template>
              <template v-else>
                <td class="border text-center text-lg p-1"></td>
              </template>
            </tr>
          </template>
        </tbody>
      </table>
    </div>
    <div class="flex justify-center mt-5">
      <ul class="flex space-x-2">
        <li
          class="cursor-pointer p-3"
          v-for="num in totalPages"
          v-bind:key="num"
          @click="setPageNum(num - 1)"
        >
          {{ num }}
        </li>
      </ul>
    </div>
    <div v-if="temp">
      <h1>나올수도 있고</h1>
    </div>
    <div>
      <button @click="changeTemp">나오게 하기</button>
    </div>
  </div>
</template>

<script setup>
import { ref, watchEffect } from 'vue'
import { useRouter } from 'vue-router'
import { GLOBAL_URL } from '@/api/util';
import { getFreeBoard } from '@/api/freeboardApi';

// 프론트 vue angular react -> javascript, 만들어진 것은 jquery
// null, [] 배열 빈공백 -> false
const temp = ref(null)
const changeTemp = () => {
  temp.value = !temp.value
}

const router = useRouter()
const arr = ref([])
const totalPages = ref(10)
const pageNum = ref(0)

const setPageNum = async(num) => {
  pageNum.value = num;
  const res = await getFreeBoard(num);
  arr.value = res.data.list;
  totalPages.value = res.data.totalPages;
}

const viewPage = (idx) => {
  const data = { name: 'freeboardview', params: { idx } }
  router.push(data)
}

watchEffect(async() => {
  const res = await getFreeBoard();
  arr.value = res.data.list;
  totalPages.value = res.data.totalPages;
})
</script>

<style scoped></style>
