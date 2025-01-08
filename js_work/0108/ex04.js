const person = {
    age: 20,
    name: "고길동",
    gender: "남자"
}

// function func({age,name,gender}){
//     console.log(`나이는 ${age}`);
//     console.log(`이름은 ${name}`);
//     console.log(`성별은 ${gender}`);
// }

const func = ({age, name, gender})=>{
    console.log(`나이는 ${age}`);
    console.log(`이름은 ${name}`);
    console.log(`성별은 ${gender}`);
}

func(person);