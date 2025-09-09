package com.kh.pratice.all;

import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] white = {1, 1, 2, 2, 2, 8};
		int[] num = new int[6];
		for (int i=0; i<white.length; i++) {
			num[i] = sc.nextInt();
			num[i] = white[i] - num[i];
			if (white[i] - num[i] < 0) {
				num[i] = num[i] - white[i];
			}
		}
		for (int chs : num) {
			System.out.print(chs + " ");
		}
	}
}
