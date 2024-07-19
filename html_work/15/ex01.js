

const aa = document.getElementById("btn-min");
const bb = document.getElementById("btn-max");
const printDiv = document.getElementById("print-div");

const n1 = document.getElementById("num1");
const n2 = document.getElementById("num2");
const n3 = document.getElementById("num3");
const n4 = document.getElementById("num4");
const n5 = document.getElementById("num5");

function min(){
  console.log(n1.value);
  const arr = [n1.value,n2.value,n3.value,n4.value,n5.value];
  console.log(arr);
for(let index = 0; index < arr.length; index++){
  const element = arr[index];
  console.log(element);
}
}
function max(){
  alert('max함수 호출');
}

aa.addEventListener('click',min)
bb.addEventListener('click',max)

printDiv.textContent = "안녕하세요 내용을 넣은 거에요";

/*const cc= 10;
let dd = 10;

dd = 30;

console.log(dd);

for (let i=0; i<10; i++){
  console.log(i);
}*/

