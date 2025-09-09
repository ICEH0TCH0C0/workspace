package com.kh.pratice.all;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String pd = sc.next();
		boolean isOk = true;
		
		for (int i=0, j=pd.length()-1; i<j; i++, j--) {
			if(pd.charAt(i) != pd.charAt(j)) {
				isOk = false;
				break;
				
			}
		}
		
		System.out.println(isOk ? 1 : 0);
		
		
		
		
	}

}
