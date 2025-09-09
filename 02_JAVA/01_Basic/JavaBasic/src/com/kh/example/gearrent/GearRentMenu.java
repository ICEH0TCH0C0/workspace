package com.kh.example.gearrent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.kh.polymorphim.Cake;

public class GearRentMenu {
	private GearRentController gc = new GearRentController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== KH 장비 대여 관리 ===");
			System.out.print("1) 장비등록\t");
			System.out.print("2) 회원등록\t");
			System.out.print("3) 대여\t");
			System.out.print("4) 반납\t");
			System.out.println("5) 태그검색");
			System.out.print("6) 키워드검색\t");
			System.out.print("7) 전체장비\t");
			System.out.print("8) 대여중목록\t");
			System.out.println("9) 종료");
			System.out.print("메뉴 : ");
			
			int n = sc.nextInt();
			sc.nextLine();
			
			switch(n) {
				case 1:{
					addDevice();
					break;
				}
				case 2:{
					addMember();
					break;
				}
				case 3:{
					borrow();
					break;
				}
				case 4:{
					returnItem();
					break;
				}
				case 5:{
					findByTag();
					break;
				}
				case 6:{
					findByKeyword();
					break;
				}
				case 7:{
					printAllDevices();
					break;
				}
				case 8:{
					printActiveLoans();
					break;
				}
				case 9:{
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				default:
					System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
			
		}
	}

	private void addDevice() {
		while(true) {
			System.out.println("유형(1:Camera, 2:Laptop): ");
			int n = sc.nextInt();
			sc.nextLine();
			
			System.out.print("id: ");
			String id = sc.nextLine();
			
			System.out.print("name: ");
			String name = sc.nextLine();
			
			System.out.print("category: ");
			String category = sc.nextLine();
			
			System.out.print("tags(쉼표로 구분): ");
			String tag = sc.nextLine().trim();
			
			Set<String> tags = new HashSet<>();
			for(String s : tag.split(",")) {
				tags.add(s.trim());
			}
			
			Device device;
			switch(n) {
				case 1:
					device = new Camera(id, name, category, tags);
					break;
				case 2:
					device = new Laptop(id, name, category, tags);
					break;
				default:
					System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
					return;
			}
			
			boolean isOk = gc.addDevice(device);
			System.out.println(isOk ? "등록 완료" : "중복된 ID입니다. 다시 입력해주세요");
		}
	}

	private void addMember() {
		System.out.print("member id: ");
		String id = sc.nextLine();
		
		System.out.print("name: ");
		String name = sc.nextLine();
		
		boolean isOk = gc.addMember(new Member(id, name));
		System.out.println(isOk ? "등록 완료" : "중복된 ID입니다. 다시 입력해주세요");
	}

	private void borrow() {
		System.out.print("memberId: ");
		String mId = sc.nextLine();
		
		System.out.print("itemId");
		String iId = sc.nextLine();
		
		System.out.print("대여일(YYYY-MM-DD): ");
		String day = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		LocalDate today = LocalDate.parse(day, formatter); 
		
		Loan loan = gc.borrow(iId, mId, today);
		if(loan == null) {
			System.out.println("대여가 불가한 장비입니다.");
			return;
		}
		System.out.println("대여 생서 완료" + loan);
		System.out.println("반납 예정일" + loan.getDueDate());
	}
	
	private void returnItem() {
		//- itemId와 반납일(YYYY-MM-DD)을 입력받아 gc.returnItem(...)으로 반납을 처리하고, 계산된 연체료 금액을 “반납 완료. 
		//연체료: {fee}원” 형식으로 출력한다. 해당 itemId의 대여 건이 없으면 오류 메시지를 안내한다.
		System.out.print("itemId");
		String iId = sc.nextLine();
		
		System.out.print("대여일(YYYY-MM-DD): ");
		String day = sc.nextLine();
		
		LocalDate today = LocalDate.parse(day);
		int fee = gc.returnItem(iId, today);
		if(fee == -1) {
			System.out.println("대여이력이 없습니다.");
		} else {
			System.out.println("반납 완료, 연체료 : " + fee + "원");
		}
	}

	private void findByTag() {
		System.out.print("검색 태그: ");
		String tag = sc.nextLine();
		
		ArrayList<Device> list = gc.findByTag(tag);
		if(list.isEmpty()) {	
				System.out.println("결과 없음");
			} else {
				for(Device d : list) {
					System.out.println(d);
			}
		}
	}

	private void findByKeyword() {
		System.out.print("키워드: ");
		String keyword = sc.nextLine();
		
		ArrayList<Device> list = gc.findByKeyword(keyword);
		if(list.isEmpty()) {
			System.out.println("결과 없음");
		} else {
			for(Device d : list) {
				System.out.println(d);
			}
		}
	}

	private void printAllDevices() {
		Collection<Device> c = gc.getAllDevices();
		if(c.isEmpty()) {	
				System.out.println("등록 장비 없음");
			} else {
				for (Device d : c) {
					System.out.println(d);
			}
		} 
	}

	private void printActiveLoans() {
		Collection<Loan> c = gc.getActiveLoans();
		if(c.isEmpty()) {	
				System.out.println("대여중 목록 없음");
			} else {
				for (Loan l : c) {
					System.out.println(l);
			}
		} 
	}
}
