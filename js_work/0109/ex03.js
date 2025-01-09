// 배열 map -> 반환되는 값이 있는 경우
// 배열 foreach -> 반환되는 값이 없는 경우

const arr1 = [1,2,3];

// 람다 완성식
const mapArr1 = arr1.map(item=> item*3 );
const foreachArr1 = arr1.forEach(item=>{ return item*3 });

console.log('mapArr1');
console.log(mapArr1);

console.log('foreachArr1');
console.log(foreachArr1);