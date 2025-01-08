console.log("ㅎㅎㅎ");

// 1 falsy 값
const f1 = undefined; // 선언만 되어져 있고 값이 할당되지 않을 때
const f2 = null; // 선언 되어져 있고 값이 null로 선언되어 있을 때
const f3 = 0;
const f4 = -0;
const f5 = NaN; // 숫자로 표기할 수 없음 Not a Number
const f6 = "";

// f1이 false이기 때문에 바로 f1 반환
const result = f1 && "result";
console.log(result);

// f1이 false여도 or 연산자여서 뒤에 있는 result2 반환
const result0 = f1 || "result0";
console.log(result0);

class A{
    a;
    constructor(a){
        this.a = a;
    }
}

// 2 truthy 값
const t1 = "result";
const t2 = 123;
const t3= [];
const t4 = {}; // json-> javascript object
const t5 = ()=>{
    function a(){ console.log("함수") }
};
const t6 = new A(20);

const result2 = t1 && "result2222";
console.log(result2);

function printName(test){
    if(test){
        console.log(`${test} 출력된다`);
    }
    else{
        console.log(`${test} 출력안된다`);
    }
}

printName(f5);
printName(t5);

function aa (a){
    console.log(a);
}

aa({a:10, b:20});