package com.kh.pratice.array;

import java.util.Scanner;

public class Pratice5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //바구니 수
		int m = sc.nextInt(); //반복 작업수
		int[] basket = new int[n];
		
		for (int i=0; i<basket.length; i++) {
			basket[i] = i + 1;
		}
		
		for (int k=0; k<m; k++) {
			int i = sc.nextInt() - 1; //index로 변경
			int j = sc.nextInt() - 1;
			
			while(i < j) {
				int num = basket[i];
				basket[i] = basket[j];
				basket[j] = num;
				i++;
				j--;
			}
		}
		for (int bas : basket) {
			System.out.print(bas + " ");
		}
		sc.close();
		
	}

}
