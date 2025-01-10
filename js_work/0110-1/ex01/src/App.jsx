import { useState } from 'react'
import './App.css'

function App() {
  
  const doA = ()=>{
    return [10, ()=>{ console.log("doA") }];
  }

  const [bb,bbb] = doA();

  // ref() 반응형 변수 역할
  const [aa,setAA] = useState(10);

  const clickA = ()=>{
    console.log("누름");
    setAA(aa+1);
  }

  console.log("랜더링");
  console.log(bb);
  console.log(bbb);

  return (
    <>
      <h1>깔끔</h1>
      <h1>{aa}</h1>
      <button onClick={clickA}>누르면 aa값 증가</button>
    </>
  )
}

export default App
