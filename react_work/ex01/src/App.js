import { useState } from 'react';
import './App.css';
import Person from './components/Person';

// useState, useEffect
// ref watch watchEffect
function App() {

  const [data, setData] = useState(0);
  const [age, setAge] = useState(1);

  const doClick1 = () => {
    alert('Hello React!');
    console.log('Button Clicked!');
    setData(data+1);
  }
  const doClick2 = () => {
    setAge(age+1);
  }
  return (
    <div className="App">
      <Person name="고길동" age={20}></Person>
      <Person name="박길동" age={30}></Person>
      <Person name="정길동" age={40}></Person>
      <h1>안녕 REACT</h1>
      <h2>Count: {data}</h2>
      <h3>age: {age}</h3>
      <button onClick={doClick1}>date누름</button>
      <button onClick={doClick2}>age누름</button>
    </div>
  );
}

export default App;
