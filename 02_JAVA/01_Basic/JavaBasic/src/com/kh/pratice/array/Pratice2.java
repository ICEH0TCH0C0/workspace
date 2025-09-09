package com.kh.pratice.array;

import java.util.Scanner;

public class Pratice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] iArr = new int[N];
		
		for (int i=0; i < N; i++) {
			iArr[i] = sc.nextInt();
		}
		
//		int min = 1000000; 
//		int max = -1000000;
		
		int min = Integer.MAX_VALUE; //int로 표현할 수 있는 수 중 가장 큰 수
		int max = Integer.MIN_VALUE; //int로 표현할 수 있는 수 중 가장 작은 수
		
		for(int num : iArr) {
			if (num < min) {
				min = num;
			} else if (num > max) {
				max = num;
			}
		} 
		
		System.out.print(min + " " + max);
		
		
	}

}
