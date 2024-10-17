<script setup>
import { ref, watch } from 'vue';
import dayjs from 'dayjs';
import utc from 'dayjs/plugin/utc';
import timezone from 'dayjs/plugin/timezone';

dayjs.extend(utc);
dayjs.extend(timezone);

const now = ref(dayjs());
const columns = ref([]);
const groupColumns = ref([]);

const subMonth = () => {
  now.value = dayjs(now.value).subtract(1,'month');
}
const addMonth = () => {
  now.value = dayjs(now.value).add(1,'month');
}

watch(now, (newValue,) => {
  // 원래 있던 값 제거
  columns.value = [];
  groupColumns.value = [];

  // 처음 로딩할 때는 now는 현재 달력
  const startday = dayjs(now.value).startOf('month');
  const lastday = dayjs(now.value).endOf('month');
  const startdayOfWeek = startday.get('day');
  const lastdayOfWeek = lastday.get('day');

  // 저번달에 날짜 추가
  for(let i = 1; i <= startdayOfWeek; i++){
    columns.value.unshift(dayjs(startday).subtract(i, 'day'))
  }

  // 현재 달력에 날짜 추가
  for(let i = 0; i < lastday.get('date'); i++){
    columns.value.push(dayjs(startday).add(i,'day'));
  }

  // 다음달에 날짜 추가
  for(let i = 1; i <= 6-lastdayOfWeek; i++){
    columns.value.push(dayjs(lastday).add(i, 'day'))
  }
  // groupColumns ([29,30,1,2,3,4,5],[6,7,8,9,10,11,12]...)
  groupColumns.value.push(columns.value.slice(0,7));
  groupColumns.value.push(columns.value.slice(7,14));
  groupColumns.value.push(columns.value.slice(14,21));
  groupColumns.value.push(columns.value.slice(21,28));
  groupColumns.value.push(columns.value.slice(28,35));
},{
  immediate: true,  // 현재페이지 처음 로딩될 때도 실행
  deep: true,    // 안의 값이 객체이면 객체 안에 변수도 변경될 때 watch 안에 있는 함수 실행
});

</script>


<template>
  <main class="p-5">
    <h1>MonthView</h1>
    <h1 class="text-center text-3xl">
      <button @click="subMonth()">&lt;&lt;</button>
      {{ now.format('YYYY년 MM월') }}
      <button @click="addMonth()">&gt;&gt;</button>
    </h1>
    <div class="grid grid-cols-7 gap-2">
      <div class="border border-gray-400 text-center p-2 text-red-600">일</div>
      <div class="border border-gray-400 text-center p-2">월</div>
      <div class="border border-gray-400 text-center p-2">화</div>
      <div class="border border-gray-400 text-center p-2">수</div>
      <div class="border border-gray-400 text-center p-2">목</div>
      <div class="border border-gray-400 text-center p-2">금</div>
      <div class="border border-gray-400 text-center p-2">토</div>
    </div>
    <div class="grid grid-cols-7 gap-2" v-for="group in groupColumns" :key="group.length">
    <div v-for="(column,index) in group" :key="column.format('YYYY-MM-DD')" class="border border-gray-400 text-center p-2" :class="{'text-red-600': index%7==0}">
      {{ column.get('date') }}
    </div>
  </div>
  </main>
</template>