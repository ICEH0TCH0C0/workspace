package com.kh.example.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MemberMenu {
	private MemberController mc = new MemberController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.println("========== KH 사이트 ========== ");
		while(true) {
			System.out.println("=====***** 메인 메뉴 *****===== ");
			System.out.println("1. 회원가입 ");
			System.out.println("2. 로그인 ");
			System.out.println("3. 같은 이름 회원 찾기 ");
			System.out.println("9. 종료 ");
			System.out.print("메뉴 번호 입력 : ");
			
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
				case 1:{
					joinMembership();
					break;
				}
				case 2:{
					if (logIn() == true) {
						memberMenu();
					}
					break;
				}
				case 3:{
					sameName();
					break;
				}
				case 9:{
					System.out.println("프로그램 종료.");
					return;
				}
				default:
					System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
		}
	}

	private void joinMembership() {
		while(true) {	
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			
			System.out.println("비밀번호 : ");
			String password = sc.nextLine();
			
			System.out.println("이름 : ");
			String name = sc.nextLine();
			
			boolean ok = mc.joinMembership(id, new Member(password, name));
			System.out.println(ok ? "성공적으로 회원가입 완료하였습니다." : "중복된 아이디입니다. 다시 입력해주세요.");
		}
	}
	
	public boolean logIn() {
		for(int i=0;i<3;i++) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			
			System.out.println("비밀번호 : ");
			String password = sc.nextLine();
			
			String name = mc.logIn(id, password);
			
			if(name != null) {
				System.out.println(name + "님, 환영합니다.");
				return true;
			} 
			System.out.println("틀린 아이디 도는 비밀번호입니다. 다시 입력해주세요.");
			return false;
		}
	}
	
	private void memberMenu() {
		while (true) {
			System.out.println("=====***** 회원 메뉴 *****===== ");
			System.out.println("1. 회원가입 ");
			System.out.println("2. 로그인 ");
			System.out.println("3. 같은 이름 회원 찾기 ");
			System.out.println("9. 종료 ");
			System.out.print("메뉴 번호 입력 : ");
			
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
				case 1:{
					joinMembership();
					break;
				}
				case 2:{
					logIn();
					break;
				}
				case 3:{
					sameName();
					break;
				}
				case 9:{
					System.out.println("프로그램 종료.");
					return;
				}
				default:
					System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
		}
	}
	
	public void changePassword() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String oldpwd = sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String newpwd = sc.nextLine();
		boolean isCh = mc.changePassword(id, oldpwd, newpwd);
		if(isCh) {
			System.out.println("비밀번호 변경 성공");
			return;
		}
		System.out.println("비밀번호 변경 실패");
	}
	
	public void changeName() {
		while(true) {	
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			
			System.out.println("비밀번호 : ");
			String password = sc.nextLine();
			
			String name = mc.logIn(id, password);
			if(name == null) {
				System.out.println("해당 정보를 찾을 수 없습니다.");
				return;
			}
			System.out.println("현재 설정한 이름 : " + name);
			System.out.print("변경할 이름 : ");
			String newName = sc.nextLine();
			
			mc.changeName(id, newName);
			System.out.println("이름 변경에 성공했습니다.");
			
		}
	}

	private void sameName() {
		System.out.println("검색할 이름 : ");
		String name = sc.nextLine();
		TreeMap<String, String> map = mc.sameName(name);
		
		for(Map.Entry<String, String> e : map.entrySet()) {
			System.out.println(e.getValue() + "-" + e.getKey());
		}
	}

}
