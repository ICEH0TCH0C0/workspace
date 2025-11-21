//js class

//1. 클래스 선언
// - 객체를 생성하기 위한 설계도
// - 데이터(변수)와 기능(함수), 생성자를 포함

class Person {

    //js에서 생성자는 명확하게 이름을 constructor라고 정함
    constructor(name, age) {
        this.name = name;
        this.age = age;
        this.gmender = "남자";
    }

    //메서드
    speak() {
        console.log(`안녕하세요 ${this.name} 입니다.`);
    }

    //정적 메서드
    //클래스 자체에 바인딩 되어 인스턴스 없이 호출 가능
    static create(name, age) {
        return new Person(name, age);
    }
}

//2. 인스턴스 생성
const person1 = new Person("홍길동", 20);
console.log(person1.name, person1.age);
person1.speak();

const person2 = Person.create("김길동", 30);
console.log(person2.name, person2.age);
person2.speak();

//3. 상속
class Student extends Person {
    constructor(name, age, studentId) {
        //부모클래스의 생성자를 호출
        super(name, age);
        this.studentId = studentId;
    }

    study() {
        console.log(`${this.name}이(가) 공부합니다.`);
    }

    //메서드 오버라이딩
    speak(){
        console.log(`안녕하세요 ${this.name} 입니다.`);
        console.log(`학번은 ${this.studentId} 입니다.`);
    }
    
}

// function sutdent() {}
// Person.prototype.speak = function() {
//     console.log(`안녕하세요 ${this.name} 입니다.`);
// }
//js는 객체지향이 아닌 함수형 구조.

//자바스크립트의 object로도 필드와 메서드를 포함하는 객체를 만들 수 있다.
const car = {
    name : "아우디",
    bland: "A8",
    color : "빨강",
    drive: function() {
        console.log(`${this.name}이(가) 달립니다.`);
    }
}

console.log(car.name);
car.drive();

const newCar = {
    ...car,
    name: "벤츠"
}

console.log(newCar.name);
newCar.drive();

//static 키워드 사용
class Math{
    static add(a, b) {
        return a + b;
    }

    static subtract(a, b) {
        return a - b;
    }
}

Math.add(1, 2);
Math.subtract(1, 2);

