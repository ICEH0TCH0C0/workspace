package com.kh.example.exception2;

import java.util.Scanner;

public class NumberMenu {
	public void menu() {
		try(Scanner sc = new Scanner(System.in);){
			int num1, num2;
			System.out.print("정수1 : ");
			num1 = sc.nextInt();
			System.out.print("정수2 : ");
			num2 = sc.nextInt();
			
			NumberController nc = new NumberController();
			boolean b = nc.checkDouble(num1, num2);
			System.out.printf("%d은(는) %d의 배수인가 ? %s", num1, num2, b ? true : false);
		}catch(NumRangeException e) {
			e.printStackTrace();
		}
				
	}
}
