//utils에서 작성한 기능을 import해서 사용 가능
import { add, pi } from "./utils.js";
import helloFun from "./utils.js";

console.log(add(10, 20));
console.log(pi);

helloFun("홍길동");
helloFun();

//모듈시스템에서는 각파일에 독립된 스코프를 제공함
//다른 파일의 변수나 함수는 반드시 improt를 해서 사용.