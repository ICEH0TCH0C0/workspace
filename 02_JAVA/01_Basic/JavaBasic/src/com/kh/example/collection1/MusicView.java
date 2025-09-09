package com.kh.example.collection1;

import java.util.List;
import java.util.Scanner;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	
	public void mainMenu() {
		while(true) {
			System.out.println("=====***** 메인 메뉴 *****===== ");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 수정");
			System.out.println("7. 곡 명 오름차순 정렬");
			System.out.println("8. 가수 명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
				case 1:{
					addList();
					break;
				}
				case 2:{
					addAtZero();
					break;
				}
				case 3:{
					printAll();
					break;
				}
				case 4:{
					searchMusic();
					break;
				}
				case 5:{
					removeMusic();
					break;
				}
				case 6:{
					setMusic();
					break;
				}
				case 7:{
					ascTitle();
					break;
				}
				case 8:{
					descSinger();
					break;
				}
				case 9:{
					System.out.println("프로그램 종료");
					return;
				}
			}
		}
	}

	private void addList() {
		System.out.println("****** 마지막 위치에 곡 추가 ****** ");
		System.out.print("곡 명 : ");
		String title = sc.next();
		System.out.print("가수 명 : ");
		String singer = sc.next();
		
		int result = mc.addList(new Music(title, singer));
		System.out.println(result == 1 ?"추가 성공" : "추가 실패");
	}
	

	private void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ****** ");
		System.out.print("곡 명 : ");
		String title = sc.next();
		System.out.print("가수 명 : ");
		String singer = sc.next();
		
		int result = mc.addAtZero(new Music(title, singer));
		System.out.println(result == 1 ?"추가 성공" : "추가 실패");
	}

	private void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ****** ");
		List<Music> list = mc.printAll();
		System.out.println(list);
	}

	private void searchMusic() {
		System.out.println("****** 특정 곡 검색 ****** ");
		System.out.print("검색할 곡 명 : ");
		String title = sc.next();
		Music m = mc.searchMusic(title);
		if (m == null) {
			System.out.println("검색한 곡이 없습니다.");
		} else {
			mc.searchMusic("검색한 곡은 " + m.toString() + "입니다.");
		}
	}

	private void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ****** ");
		System.out.print("검색할 곡 명 : ");
		String title = sc.next();
		Music m = mc.searchMusic(title);
		if (m == null) {
			System.out.println("삭제할 곡이 없습니다.");
		} else {
			mc.searchMusic(m.toString() + "을(를) 삭제했습니다.");
		}
	}

	private void setMusic() {
		System.out.println("****** 특정 곡 수정 ****** ");
		System.out.print("검색할 곡 명 : ");
		String oldTitle = sc.next();
		System.out.print("수정할 곡 명 : ");
		String newTitle = sc.next();
		System.out.print("수정할 곡 가수 : ");
		String newSinger = sc.next();
		
		Music m = mc.setMusic(oldTitle, new Music(newTitle, newSinger));
		if(m == null) {
			System.out.println("수정할 곡이 없습니다.");
		} else {
			System.out.println(m.toString() + "의 값이 변경되었습니다.");
		}
	}

}
