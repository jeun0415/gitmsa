const obj = {};   // 객체 선언
// const obj = new Object();

obj.a = 10;
obj.b = ()=>{
  console.log('obj.b');
}

console.log(obj);
console.log(obj.a);
console.log(obj.b);

obj.b();

console.log('잘되네 ㅎㅎ');

for(var i =0; i<10; i++){
  for(let j=0; j<i+1; j++){

    console.log("나오나?"+i+"x"+j+" = "+(i*j));
    
  }
}