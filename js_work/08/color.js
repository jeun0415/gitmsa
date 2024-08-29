// import {cc} from './myclass.js';

// const [a,b,c] = cc;

const mybgclass = ['bg-orange-400','bg-yellow-300','bg-blue-200'];
const removeclass = ()=>{
  for (const element of mybgclass){
    document.querySelector('#result').classList.remove(element);
    }
}

document.querySelector('#orange').onclick= ()=>{
  // console.log("확인");
  removeclass();
  document.querySelector('#result').classList.add('bg-orange-400');
  // console.log(`a = ${a}`);
  // console.log(`b = ${b}`);
  // console.log(`c = ${c}`);
}

document.querySelector('#gy').onclick= ()=>{
  removeclass();
  document.querySelector('#result').classList.add('bg-yellow-300');
}

document.querySelector('#skyblue').onclick= ()=>{
  removeclass();
  document.querySelector('#result').classList.add('bg-blue-200');
}