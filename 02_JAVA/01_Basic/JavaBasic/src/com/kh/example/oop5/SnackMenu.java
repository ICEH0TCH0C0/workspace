package com.kh.example.oop5;

import java.util.Scanner;

public class SnackMenu {
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	public void menu() {
		while(true) {
			System.out.println("스택류를 입력하세요");
			System.out.print("종류 : ");
			String kind = sc.next();
			
			System.out.print("이름 : ");
			String name = sc.next();
			
			System.out.print("맛 : ");
			String flavor = sc.next();
			
			System.out.print("개수 : ");
			int numOf = sc.nextInt();
			
			System.out.print("가격 : ");
			int price = sc.nextInt();
			sc.nextLine(); //개행문자비우기
			
			String str;
			str = scr.saveData(kind, name, flavor, numOf, price);
			System.out.println(str);
			
			System.out.print("저장한 정보를 확인하겠습니까?(y/n) : ");
			String yn = sc.next();
			sc.nextLine();
			if (yn.charAt(0) == 'y') {
				System.out.println(scr.confirmData());
				return;
			} else {
				return;
			}
			
		}
	}
	
}
