package com.kh.pratice.array2D;

import java.util.Scanner;

public class Pratice3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//색종이 수 입력
		int n = sc.nextInt();
		//도화지 생성
		boolean[][] arr1 = new boolean[100][100];
		//색종이 붙이기
		for (int k=0; k<n; k++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int j=x; j<x+10; j++) {
				for (int i=y; i<y+10; i++) {
					arr1[j][i] = true;
					
				}
			}	
		}
		
		//영역 출력
		int area = 0;
		for (int i=0; i<arr1.length; i++) {
			for (int j=0; j<arr1[i].length; j++) {
				if(arr1[i][j]) {
					area++;
				}
			}
		}
		System.out.println(area);
		sc.close();
	}
}