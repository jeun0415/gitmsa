// 240829

// module export import 함수 호출하고 객체로 가져오고
import asdf,{doA,doB} from './myfunction.js';

console.log('test');
doA();
doB();

console.log(`asdf.a = ${asdf.a}`);
console.log(`asdf.b = ${asdf.b}`);