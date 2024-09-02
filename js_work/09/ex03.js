let arr = [1,2,3];
let brr = [4,5,6];
let myarr = [{age:20, name:"고길동"},{age:7, name:"최포미"},{age:1, name:"임예서"}];
console.log(arr+brr);
console.log(arr.concat(brr));

// filter 주어진 함수에 predicate 람다 true,false 새로운 배열
// 자바 collect(newArrayList,(a,c)=>a.add(c),(1,2)->{})
const crr = arr.filter((n)=>n%2==0);
console.log(crr);

const filterArr = myarr.filter( item => item.age>6 );
console.log(filterArr);