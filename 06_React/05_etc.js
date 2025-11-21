//1. 템플릿 리터럴

const { useState } = require("react");

//문자열과 변수 결합시 편리하고 여러줄의 문자열도 간단하게 처리 가능
const userName = "홍길동";
console.log(`사용자 이름은 ${userName}입니다.`);

//2. 구조분해할당
// 객체에서 필요한 값을 바로 변수로 추출할 때 사용.
const userInfo = {
    name: "홍길서",
    age: 21,
    job: "dev"
}

//const name = userInfo.name;
//const age = userInfo.age;
// const {name, age} = userInfo;
// console.log(name, age);

//const name = userInfo.name;
//const newJob = userInfo.job;
const {name, job: newJob} = userInfo;
console.log(name, newJob);

//React에서는 props라는 객체를 전달하고 매개변수로 내부의 값들을 받을때 해당 문법을 주로 사용함.
function myInfo({name, age}) {
    console.log(name, age);
}

myInfo(userInfo);

//3. 배열 구조 분해할당
//배열 요소를 순서대로 변수에 담아줌
const numbers = [10, 20, 30];
const [a, b] = numbers;
console.log(a, b);

//필요없는 값은 생략 가능
const [,, c] = numbers;
console.log(c);

//React에서는 state라는 값을 생성할 때 배열에 값과 해당 값을 변경하는 함수가 순차적으로 전달
// useState() return [값, 값을 변경할 때 사용하는 setter]
// const [count, setCount] = useState();

//4. 스프레드 연산자 ...
//배열, 객체 복사, 병합, 수정, 나머지 값을 처리

let user = {
    name: "홍길동",
    age: 20,
    job: "dev"
}

user.job = "che"; 
//이렇게 변경시 실제 객체의 내부값만 변경되기 때문에 객체자체의 주소값이 변경되지 않음

user = {
    ...user,
    job: "che"
}
console.log(user);