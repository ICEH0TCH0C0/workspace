package com.kh.example.oop4;

import java.util.Scanner;

public class ShapeMenu {
	private Scanner sc = new Scanner(System.in);
	private SquareController scr = new SquareController();
	private TriangleController tc = new TriangleController();
	
	public ShapeMenu() {
	}

	void inputMenu() {
		while(true) {	
			System.out.println("=====도형 프로그램=====");
			System.out.print("3. 삼각형\n4. 사각형\n9. 종료 선택\n");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch (select) {
			case 3:
				triangleMenu();
				break;
			case 4:
				squareMenu();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못된 번호입니다. 다시 입력하세요.");
			}
		}
	}
	
	void triangleMenu() {
		while(true) {
			System.out.println();
			System.out.println("========삼각형========");
			System.out.print("1. 삼각형 면적\n2. 삼각형 색칠\n3. 삼각형 정보\n9. 메인으로\n");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				inputSize(3, 2);
				break;
			case 2:
				inputSize(3, 3);
				break;
			case 3:
				printInformation(3);
				break;
			case 9:
				return;
			}
		}
	}
	
	void squareMenu() {
		while(true) {	
			System.out.println();
			System.out.println("========사각형========");
			System.out.print("1. 사각형 둘레\n2. 사각형 면적\n3. 사각형 색칠\n4. 사각형 정보\n9. 메인으로\n");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				inputSize(4, 1);
				break;
			case 2:
				inputSize(4, 2);
				break;
			case 3:
				inputSize(4, 3);
				break;
			case 4:
				printInformation(4);
				break;
			case 9:
				return;
			}
		}
	}
	
	void inputSize(int type, int menuNum) {
		//type -> 3 : 삼각형 / 4 : 사각형
		//menuNum -> 1 : 둘레, 2 : 넓이, 3 : 색상
		
		switch(menuNum) {
		case 1:{
				System.out.print("높이 : ");
				double height = sc.nextDouble();
				System.out.print("너비 : ");
				double width = sc.nextDouble();
				double perimeter = scr.calcPerimeter(height, width);
				System.out.println("사각형의 둘레 : " + perimeter);
			}break;
		case 2:{
				System.out.print("높이 : ");
				double height = sc.nextDouble();
				System.out.print("너비 : ");
				double width = sc.nextDouble();
				
				double area;
				if(type == 3) { 
					area = tc.calcArea(height, width);
					System.out.println("삼각형의 넓이 : " + area);
				} else {
					area = scr.calcArea(height, width);
					System.out.println("사각형의 넓이 : " + area);
				}
			}break;
		case 3: {
				System.out.println("색깔을 입력하세요 : ");
				String color = sc.next();
				sc.nextLine();
				
				if (type == 3) {
					tc.paintColor(color);
				} else {
					scr.paintColor(color);
				}
			}break;
		}
	}
	
	void printInformation(int type) {
		System.out.println(type == 3 ? tc.print() : scr.print());
	}
	
}
