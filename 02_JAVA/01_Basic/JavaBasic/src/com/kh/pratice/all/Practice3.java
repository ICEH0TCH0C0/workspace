package com.kh.pratice.all;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String en = sc.next();
		en = en.toUpperCase();
		
		//개수
		int[] count = new int[26];
		for (int i=0; i<en.length(); i++) {
			int idx = en.charAt(i) - 'A';
			count[idx]++;
		}
		
		int max = 0, idx = 0;
		boolean isDupl = false;
		for(int i=0; i<count.length; i++) {
			
			if (count[i] > max) {
				max = count[i];
				idx = i;
				isDupl = false;
			}else if(count[i] == max) {
				isDupl = true;
			}
		}
		System.out.println(isDupl ? "?" : (char)(idx + 'A'));
		
		/*
		char[] mem = new char[26];
		int[] iMem = new int[26];
		
		//알파벳 생성
		for (int i=0; i<mem.length; i++) {
			mem[i] = (char)('A' + i);
		}
		//비교
		for (int i=0; i<en.length(); i++) {
			char A = en.charAt(i);
			for (int j=0; j<mem.length; j++) {
				if (mem[j] == A) {
					iMem[j] += 1;
				}
			}
		}
		
		//중간 출력
		for (char alpa : mem) {
			System.out.printf(alpa + " ");
		}
		System.out.println();
		for (int i : iMem) {
			System.out.printf(i + " ");
		}
		System.out.println();
		
		//최대빈도
		int max = Integer.MIN_VALUE;
		for (int i=0; i<iMem.length; i++) {
			if(max < iMem[i]) {
				max = iMem[i];	
			}
		}
		System.out.println(max);
		*/
	}

}
