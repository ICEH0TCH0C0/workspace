// var -> 사용하지 않는다.
//인터프리터 언어이기 때문에 호이스팅을 통해
//var tmp; 가 코드 위에 존재한다.
console.log(tmp); //-> 선언이 됨, 호이스팅
var tmp = "여기서 부터 생성됨";

//let const : 변수 상수
//TDZ(Temporal Dead Zone)를 통해서 호이스팅의 문제를 해결
//let과 const도 호이스팅이 되지만, 선언되는 시점의 코드가 
// 실행되기 전까지 TDZ에 등록하여 사용할 수 없게 관리한다

//변수명 작성 규칙
//1. 변수명에는 $, _ 외의 특수문자는 사용안됨
//2. 숫자로 시작할 수 없음
//3. 예약어 사용 안됨

//올바른 변수명 예시
let $price = 1000; //보통 두가지의 변수 타입이 있을 때 구분의 용도로 사용
let userName = "홍길동";
let _status = "active"; //보통 복사한 값을 표현할 때 사용

//let : 변수(값을 재할당 가능, 중복 선언 불가)
let name = "홍길동";
console.log(`name : ${name}`);
name = "김길동";
console.log(`name : ${name}`);

//const : 상수
const age = 10;
console.log(`age : ${age}`);

try {
    age = 15;
    console.log(`age : ${age}`);
} catch (error) {
    console.log(error);
}