package com.kh.pratice.array;

import java.util.Scanner;

public class Pratice4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] submitStd = new boolean[30];
		int n = sc.nextInt();
		
		for (int i=0; i < 28; i++) {
			int num = sc.nextInt();
			submitStd[num - 1] = true;
		}
		
		for (int i=0; i<submitStd.length; i++) {
			if (!submitStd[i]) {
				System.out.println(i + 1);
			}
		}
		
		sc.close();
		
		
	}

}
