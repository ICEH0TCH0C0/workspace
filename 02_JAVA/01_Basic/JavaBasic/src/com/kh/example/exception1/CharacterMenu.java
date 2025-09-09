package com.kh.example.exception1;

import java.util.Scanner;

public class CharacterMenu {

	public void menu() {
		try (Scanner sc = new Scanner(System.in);){
			System.out.print("문자열 : ");
			String s = sc.nextLine();
			
			CharacterController cc = new CharacterController();
			int count =cc.countAlpha(s);
			
			System.out.println(s + "에 포함된 영문자 개수 : " + count);
			
		} catch (CharCheckException e) {
			e.printStackTrace();
		}
	}

}
