package com.kh.pratice.array2D;

import java.util.Scanner;

public class Pratice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int num1 = 0;
		int num2 = 0;
		
		int[][] arr1 = new int[n][m];
		//입력
		for (int j=0; j<arr1.length; j++) {
			for (int i=0; i<arr1[j].length; i++) {
				arr1[j][i] = sc.nextInt();
			}
		}
		//출력
		for (int j=0; j<arr1.length; j++) {
			for (int i=0; i<arr1[j].length; i++) {
				if (arr1[j][i] > max) {
					max = arr1[j][i];
					num1 = j;
					num2 = i;
				}
				 
			}
		}
		System.out.println(max);
		System.out.printf("%d %d", num1+1, num2+1);
		
	}

}
