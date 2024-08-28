export default{ a:10, b:function(){console.log('test');} };  // 객체 반환

export const aa = {
  z:10,
  zz:20,
  zzz:function(){ console.log("test"); }
};

export const bb = ()=>{
  let a = 10;
  let b = 20;

  console.log("bb");

  let c = 30;
}

// 매개변수 자리에 자료형 타입 적으면 안됨
// javascript 컴파일러가 알아서 처리함
export const cc = function (){
  return 10;
}