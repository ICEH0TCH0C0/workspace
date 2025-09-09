package com.kh.example.abstractNInterface;

public class Run {

	public static void main(String[] args) {
		PhoneController pc = new PhoneController();
		String[] pcArr = pc.method();
		for (int i =0; i<pcArr.length; i++) {
			System.out.println(pcArr[i]);
		}
	}

}
