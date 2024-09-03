const arr = ['a','b','c'];
const brr = [1,2,3,4,5];

const str1 = arr.join();
const str2 = brr.join('<p>');

console.log(str1);
console.log(str2);

// pust arr 제일 끝의 값이 추가되고, 배열의 길이 값이 반환됨
const length = arr.push('zz');
console.log(arr);
console.log(length);

// unshift arr 제일 앞의 값이 추가되고, 배열의 길이 값이 반환됨
const value = arr.unshift('aa');
console.log(arr);
console.log(value);

const item = arr.pop();
console.log(item);
console.log(arr);

const fitem = arr.shift();
console.log(fitem);
console.log(arr);