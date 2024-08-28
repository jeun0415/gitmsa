const num = document.getElementById('num');
const btn = document.getElementById('btn');
const print = document.querySelector('#print');
let sum = 0;
    
btn.onclick = function(){
  for(let i = 1; i <= num.value; i++){
    sum += i;
    console.log(i);
  }
  print.innerHTML=sum;
}