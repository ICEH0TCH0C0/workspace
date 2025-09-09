package com.kh.example.inherit1;

import java.util.Scanner;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		while (true) {	
			System.out.println("=====메뉴=====");
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch (num) {
				case 1: {
					circleMenu();
					break;
				}
				case 2: {
					rectangleMenu();
					break;
				}
				case 9: {
					System.out.println("종료합니다.");
					return;
				}
				default: 
					System.out.println("잘못된 번호를 입력하셨습니다.");
			}
			
		}
	}
	
	private void calcCircleArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		sc.nextLine();
		
		System.out.print("반지름: ");
		int radius = sc.nextInt();
		sc.nextLine();
		
		String area = cc.calcArea(x, y, radius);
		System.out.println("둘레 :" + area);

	}
	
	private void calcCircum() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		sc.nextLine();
		
		System.out.print("반지름: ");
		int radius = sc.nextInt();
		sc.nextLine();
		
		String circum = cc.calcCircum(x, y, radius);
		System.out.println("면적 :" + circum);

	}

	private void calcRectArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		sc.nextLine();
		
		System.out.print("높이 : ");
		int height = sc.nextInt();
		sc.nextLine();
		
		System.out.print("너비 : ");
		int width = sc.nextInt();
		sc.nextLine();
		
		String area = rc.calcArea(x, y, height, width);
		System.out.println("면적 :" + area);
		
	}
	
	private void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		sc.nextLine();
		
		System.out.print("높이 : ");
		int height = sc.nextInt();
		sc.nextLine();
		
		System.out.print("너비 : ");
		int width = sc.nextInt();
		sc.nextLine();
		
		String perimeter = rc.calcPerimeter(x, y, height, width);
		System.out.println("둘레 :" + perimeter);

	}

	private void rectangleMenu() {
		while(true) {	
			System.out.println();
			System.out.println("=====사각형 메뉴=====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 넓이");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch (select) {
				case 1: {
					calcPerimeter();
					System.out.println();
					break;
				}
				case 2: {
					calcRectArea();
					System.out.println();
					break;
				}
				case 9: {
					return;
				}
				default:
					System.out.println("잘못된 번호를 입력하셨습니다.");
			}
		}
	}



	public void circleMenu() {
		while(true) {	
			System.out.println();
			System.out.println("=====원 메뉴=====");
			System.out.println("1. 원 둘레");
			System.out.println("2. 원 넓이");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch (select) {
				case 1: {
					calcCircum();
					System.out.println();
					break;
				}
				case 2: {
					calcCircleArea();
					System.out.println();
					break;
				}
				case 9: {
					return;
				}
				default:
					System.out.println("잘못된 번호를 입력하셨습니다.");
			}
		}
	}
}
