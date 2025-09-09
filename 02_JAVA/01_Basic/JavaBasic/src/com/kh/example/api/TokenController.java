package com.kh.example.api;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
		super();
	}
	
	public String afterToken(String str) {
		StringTokenizer st = new StringTokenizer(str, " ");
		
		StringBuilder sb = new StringBuilder();
		while(st.hasMoreTokens()) {
			sb.append(st.nextToken());
		}
		return sb.toString();
	}
	
	public String firstCap(String input) {
		char first = input.toUpperCase().charAt(0);
		return first + input.substring(1);
	}
	
	public int findChar(String input, char one) {
		int count =0;
	 	char[] chArr = input.toCharArray();
	 	for (char ch : chArr) {
	 		if(ch == one) count++;
	 	}
	 	return count++;
	}
}
