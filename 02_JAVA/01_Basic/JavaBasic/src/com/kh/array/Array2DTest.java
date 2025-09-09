package com.kh.array;

import java.util.Scanner;

public class Array2DTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//사용자에게 행(m)과 열(n)을 입력받아
		//해다 행과 열의 빙고판을 만들어라.
		//다음 행과 열의 들어갈 문자를 각각 모두 입력받아 저장한 뒤
		//출력

		/*
		 * 행 : n
		 * 열 : m
		 * 
		 * 1행1열 : 바나나
		 * 1행2열 : 배
		 * ...
		 * n행m열 : 귤
		 * */
		
		/*
		System.out.print("행 : ");
		int n = sc.nextInt();
		System.out.print("열 : ");
		int m = sc.nextInt();
		String[][] basket = new String[n][m];
		
		//입력
		for (int j=0; j<basket.length; j++) {
			for (int i=0; i<basket[j].length; i++) {
				System.out.printf("%d행 %d열 : ", j+1, i+1);
				String name = sc.next();
				basket[j][i] = name;
			}
			System.out.println();
		}
		
		//출력
		for (int j=0; j<basket.length; j++) {
			for (int i=0; i<basket[j].length; i++) {
				System.out.print(basket[j][i] + " ");
			}
			System.out.println();
		}

		*/
		
		//사용자에게 좌석의 행과 열을 입력받아 2차원 배열을 생성
		//각 좌석에 들어갈 관객의 이름을 입력받아 저장
		//모두 입력받으면 좌석표를 출력.
		//행(줄)의 수 :
		//열(좌석)의 수 :
		//1행 1열 : 철수
		//1행 2열 : 민수
		//1행 3열 : 상수
		//...
		//=========좌석표==========
		//철수 민수 상수 ...
		
		System.out.print("행(줄)의 수 : ");
		int n = sc.nextInt();
		System.out.print("열(좌석)의 수 : ");
		int m = sc.nextInt();
		String[][] sit = new String[n][m];
		
		//입력
		for (int j=0; j<sit.length; j++) {
			for (int i=0; i<sit[j].length; i++) {
				System.out.printf("%d행 %d열 : ", j+1, i+1);
				String name = sc.next();
				sit[j][i] = name;
			}
			System.out.println();
		}
		System.out.println("======좌석표======");
		//출력
		for (int j=0; j<sit.length; j++) {
			for (int i=0; i<sit[j].length; i++) {
				System.out.print(sit[j][i] + " ");
			}
			System.out.println();
		}
		
		
	}

}
