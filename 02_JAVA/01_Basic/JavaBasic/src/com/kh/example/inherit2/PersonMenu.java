package com.kh.example.inherit2;

import java.util.Scanner;

public class PersonMenu {
	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();
	
	public void mainManu() {
		System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
		System.out.println("현재 저장된 학생은 "+ pc.personCount()[0] +"명입니다.");
		System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
		System.out.println("현재 저장된 사원은 "+ pc.personCount()[1] +"명입니다.");
		
		while(true) {
			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
				case 1: {
					if (pc.personCount()[0] >= 3) {
						System.out.println("학생 3명이 이미 존재하기 때문에 더이상 저장할 수 없습니다.");
					}else {
						studentMenu();
					}
					break;
				}
				case 2:{
					if (pc.personCount()[1] >= 10) {
						System.out.println("사원 10명이 이미 존재하기 때문에 더이상 저장할 수 없습니다.");
					}else {
						employeeMenu();
					}
					break;
				}
				case 9: {
					System.out.println("종료합니다.");
					return;
				}
				default:
					System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void employeeMenu() {
		while(true) {
			System.out.println();
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch (select) {
				case 1:{					
					insertEmployee();
					System.out.print("그만하시려면 N(또는 n), 이어서 하시려면 아무키나 누르세요 : ");
					String input = sc.next();
					
					if (input.charAt(0) == 'n' || input.charAt(0) == 'N') {
						break;
					}else {
						insertEmployee();
					}
				}
				case 2:{
					printEmployee();
					break;
				}
				case 9:{
					return;
				}
				default:
					System.out.println("다른 번호를 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	

	private void insertEmployee() {
		if(pc.personCount()[0] >= 3) {
			System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가를 종료하고 사원 메뉴로 돌아갑니다.");
			return;
		}
		System.out.println();
		System.out.print("사원 이름 : ");
		String name = sc.next();
		
		System.out.print("사원 나이 : ");
		int age = sc.nextInt();
		
		System.out.print("사원 키 : ");
		double height = sc.nextDouble();
		
		System.out.print("사원 몸무게 : ");
		double weight = sc.nextDouble();
		
		System.out.print("사원 급여 : ");
		int salary = sc.nextInt();
		
		System.out.print("사원 부서 : ");
		String dept = sc.next();
		
		pc.insertEmployee(name, age, height, weight, salary, dept);
	}
	
	private void printEmployee() {
		Employee[] empArr = pc.printEmployee();
		for (Employee emp : empArr) {
			if (emp == null) break;
			System.out.println(emp.toString());
		}
	}

	public void studentMenu() {
		while(true) {
			System.out.println();
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch (select) {
				case 1:{					
					insertStudent();
					System.out.print("그만하시려면 N(또는 n), 이어서 하시려면 아무키나 누르세요 : ");
					String input = sc.next();
					
					if (input.charAt(0) == 'n' || input.charAt(0) == 'N') {
						break;
					}else {
						insertStudent();
					}
					break;
				}
				case 2:{
					printStudent();
					break;
				}
				case 9:{
					return;
				}
				default:
					System.out.println("다른 번호를 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	private void insertStudent() {
		if(pc.personCount()[0] >= 3) {
			System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
			return;
		}
		System.out.println();
		System.out.print("학생 이름 : ");
		String name = sc.next();
		
		System.out.print("학생 나이 : ");
		int age = sc.nextInt();
		
		System.out.print("학생 키 : ");
		double height = sc.nextDouble();
		
		System.out.print("학생 몸무게 : ");
		double weight = sc.nextDouble();
		
		System.out.print("학생 학년 : ");
		int grade = sc.nextInt();
		
		System.out.print("학생 전공 : ");
		String major = sc.next();
		
		pc.insertStudent(name, age, height, weight, grade, major);

	}

	private void printStudent() {
		Student[] stArr = pc.printStudent();
		for (Student st : stArr) {
			if (st == null) break;
			System.out.println(st.toString());
		}
	}
}
