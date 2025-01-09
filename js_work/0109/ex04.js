const arr1 = [10,3,5];

// const sortArr1 = arr1.sort((a,b)=>{
//     if(a>b)
//         return -1;
//     else if(a<b)
//         return 1;
//     else
//         return 0;
// });

const sortArr1 = arr1.sort((a,b)=>{
    return a-b;
})

console.log(sortArr1);

const arr2 = [{name:"고길동", age:20},
    {name:"박길동", age:15},
    {name:"이길동", age:30}];

const sortArr2 = arr2.sort((item1,item2)=>{
    return item2.age-item1.age;
})

console.log(sortArr2);

const arr3 = ["안녕","나는","최포미야"]

console.log(arr3.join(" "));

// falsy, truthy
// && ||
// 객체분할
// 배열분할

// map => 배열 반환값O
// foreach => 배열 반환값X
// sort => 정렬
// find => 객체 찾기
// findIndex => 위치 찾기

// for of 배열에서 for
// for in 객체에서 for