package com.kh.interface1;

public class AnimalManager {

	public static void main(String[] args) {
		Animal[] ani = new Animal[5];
		
		ani[0] = new Dog("찹살", 2, "시베리안허스키");
		ani[1] = new Dog("백구", 2, "진돗개");
		ani[2] = new Cat("백설", 2, "페르시아");
		ani[3] = new Cat("흑설", 2, "봄베이");
		ani[4] = new Dog("왓슨", 2, "골든 리트리버");
		
		for (int i=0; i<ani.length; i++) {
			if (ani[i] instanceof Dog) {
				((Dog)ani[i]).speak();
				System.out.println("이 개의 견종은 " + ((Dog)ani[i]).getBreed() + "입니다. ");
			} else {
				((Cat)ani[i]).speak();
				System.out.println("이 고양이의 색상은 " + ((Cat)ani[i]).getColor() + "입니다. ");
			}
		}
	}

}
