//함수 표현식

//1. 기본함수

function hello() {
    console.log("hello");
}

hello();

//js에서는 함수도 하나의 값으로 취급
let _hello = hello;
_hello();

//2. 익명함수
const printMsg = function() {
    console.log("hello");
}

printMsg();

//기본함수는 호이스팅이 된다.
tmp();
function tmp() {
    console.log("함수임")
}

//익명함수는 호이스팅이 안된다.
tmp2();
let tmp2 = function() {
    console.log("함수임")
}

//함수의 기본 매개변수
function greet(name = "홍길동", msg = "안녕하세요") {
    console.log(`${name}님 ${msg}`);
}

//js의 함수는 호출시 이름으로만 함수를 판단
greet("홍길동", "반갑습니다");
greet(); //-> undefined = 개발자의 실수를 방지

greet(null); //-> 개발자가 명시적으로 표현한 빈값
greet(undefined, "반갑습니다"); //-> 시스템이 정해준 빈값(개발자가 선언 후 사용하지 않은 값)
greet(false);

//기본값이 있는 매개변수는 두쪽에 배치하자
function greet2(name = "홍길동", msg) {
    console.log(`${name}님 ${msg}`);
}

greet2(undefined, "반갑습니다");

function greet3( msg, name = "홍길동") {
    console.log(`${name}님 ${msg}`);
}

greet3(undefined, "반갑습니다");

//2. 화살표 함수
//코드가 짧고 가독성이 좋다.
function add(a, b) {
    return a + b;
}

const add2 = (a, b) => {
    console.log(a, b);
    return a + b;
}

//함수의 구현부에 리턴값만 있다면, return 키워드와 {}를 생략 가능
const add3 = (a, b) => a + b;

//매개변수가 한개라면 ()도 생략 가능
const print = msg => console.log(msg);

//this의 바인딩 차이
//화살표 함수는 자신만의 this를 바인딩하지 않는다.
const obj1 = {
    name: "홍길동",
    age: 22,
    info: function() {
        console.log(this.name, this.age);
        setTimeout(function() {
            console.log(this.name, this.age);
        }, 1000);
    }
}

obj1.info(); //-> undefined

//Lexical scope
//함수를 선언하는 위치에 따라 this가 결정되는 방식
const obj2 = {
    name: "홍길서",
    age: 22,
    info: function() {
        console.log(this.name, this.age);
        setTimeout(() => {
            console.log(this.name, this.age);
        }, 1000);
    }
}

obj2.info(); //-> 홍길서 22

//3. 콜백 함수
// 특정 함수를 실행할 때 실행하는 사람이 특정 기능을 완료한 후에 실행하고 싶은 코드를 정의하는 용도
const run = (callback) => {
    // 
    callback();
}

run(() => {
    console.log("실행")
})

