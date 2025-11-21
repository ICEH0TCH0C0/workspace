//1. for문
for(let i = 0; i < 10; i++) {
    console.log(i);
}

//2. while문
let i = 0;
while(i < 10) {
    console.log(i);
    i++;
}

//3. do while문
let j = 0;
do {
    console.log(j);
    j++;
} while (j < 10);

//4. for ... of 값
let fruits = ["사과", "바나나", "딸기"];
for(let fruit of fruits) {
    console.log(fruit);
}

fruits = [{
    id: 1,
    name: "사과",
    price: 1000
}, {
    id: 2,
    name: "바나나",
    price: 2000
}, {
    id: 3,
    name: "딸기",
    price: 3000 
}];

for(let fruit of fruits) {
    console.log(fruit.id + " : " + fruit.name + " : " + fruit.price);
}

//5. for ... in 키

const apple = {
    id: 1,
    name: "사과",
    price: 1000
}

for(let key in apple) {
    console.log(key + " : " + apple[key]);
}

//6. forEach
// - 배열 순회 전용 메서드
fruits.forEach((obj, index) => {
    console.log(`forEach : ${index} -> ${obj.name}`);
})

const numbers = [1, 3, 5, 7, 9];
//7. map();
//기존 배열을 가지고 새로운 배열을 만들고 싶을 때 -> 변형된 새로운 배열을 반환
//서버로부터 받은 데이터를 통해서 대칭되는 UI를 만들어낼 대 사용
const squared = numbers.map((num) => num * num);
console.log(squared);

//8. filter()
// 조건에 맞는 요소만 추출하고 싶을때 -> 조건에 맞는 값만 모아서 새로운 배열을 반환
//내부함수의 리턴값이 true인것만 모아서 반환
//서버로부터 데이터를 삭제하고 이를 UI 상태에 반영해 줄때 많이 사용함
const squared2 = numbers.filter((num) => num % 3 === 0);
console.log(squared2);

//9. find()
// 조건에 맞는 첫번째 요소만 추출하고 싶을때 -> 조건에 맞는 값 하나 검색
const squared3 = numbers.find((num) => num % 3 === 0);
console.log(squared3);

//10. some()
//하나라도 조건을 만족하면 true 아니면 flase
const squared4 = numbers.some((num) => num % 3 === 0);
console.log(squared4);

const squared5 = numbers.some((num) => num % 2 === 0);
console.log(squared5);

//11. every()
//모두 조건을 만족하면 true 아니면 flase
const squared6 = numbers.every((num) => num % 3 === 0);
console.log(squared6);

const squared7 = numbers.every((num) => num % 1 === 0);
console.log(squared7);

//12. reduce()
// 배열의 값을 누적하여 하나의 결과값을 도출
// 배열.reduce((누적값, 배열요소) => {실행할 코드 return 누적값;}, 누적값의 초기값)

const result = numbers.reduce((sum, num) => {
    console.log("합 " + sum, " 값 : ", num);
    sum.push(sum + num);
    return sum;
}, []);

console.log(result);

const stdList = [{
    name: "홍길동",
    age: 15,
    score: 90
}, {
    name: "김길동",
    age: 16,
    score: 80
}, {
    name: "박길동",
    age: 17,
    score: 70
}, {
    name: "최길동",
    age: 18,
    score: 60
}]

let scoreMap = stdList.reduce((scoreMap, std) => {
    scoreMap[std.name] = std.score;
    return scoreMap;
}, {});

console.log(scoreMap);