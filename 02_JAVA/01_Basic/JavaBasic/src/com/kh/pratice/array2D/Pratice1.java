package com.kh.pratice.array2D;

import java.util.Scanner;

public class Pratice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr1 = new int[n][m];
		int[][] arr2 = new int[n][m];
		int[][] arr3 = new int[n][m];
		
		for (int j=0; j<arr1.length; j++) {
			for (int i=0; i<arr1[j].length; i++) {
				arr1[j][i] = sc.nextInt();
			}
		}
		
		for (int j=0; j<arr2.length; j++) {
			for (int i=0; i<arr2[j].length; i++) {
				arr2[j][i] = sc.nextInt();
			}
		}
		/*
		for (int j=0; j<arr1.length; j++) {
			for (int i=0; i<arr1[j].length; i++) {
				System.out.print(arr1[j][i] + " ");
			}
			System.out.println();
		}
		
		for (int j=0; j<arr2.length; j++) {
			for (int i=0; i<arr2[j].length; i++) {
				System.out.print(arr2[j][i] + " ");
			}
			System.out.println();
		}
		*/
		for (int j=0; j<m; j++) {
			for (int i=0; i<m; i++) {
				int num1 = arr1[j][i];
				int num2 = arr2[j][i];
				int sum = num1 + num2;
				arr3[j][i] = sum;
			}
		}
		
		for (int j=0; j<arr3.length; j++) {
			for (int i=0; i<arr3[j].length; i++) {
				System.out.print(arr3[j][i] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
