const arr1 = [{name:"고길동", age:20},
              {name:"박길동", age:15},
              {name:"이길동", age:30}];

arr1.forEach(obj => {
    console.log(obj);
})
console.log("\n");
const arr2 = [...arr1, {name:"김길동", age:40}];
console.log(arr2);

// ref 변수가 아니기 때문에 예외처리됨
// arr1.value = [...arr1.value, {name:"김길동", age:40}];

const findObj = arr1.find(obj =>{
    if(obj.name=="박길동" && obj.age===20){
        return obj;
    }
});

console.log(findObj);

const arr3 = [1,2,3,4];
const findIndex1 = arr3.findIndex(index=>{
    return index === 2;
})

console.log(findIndex1);

const findIndex2 = arr3.findIndex(index=>{
    return index === 4;
})

console.log(findIndex2);