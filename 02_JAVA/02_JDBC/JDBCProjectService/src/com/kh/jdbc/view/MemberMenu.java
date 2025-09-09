package com.kh.jdbc.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.controller.MemberController;
import com.kh.jdbc.model.vo.Member;

//View : 사용자와의 상호작용을 하는 객체 -> 입력, 출력
public class MemberMenu {
	private Scanner sc;
	private MemberController mc;

	public MemberMenu() {
		super();
		this.sc = new Scanner(System.in);
		this.mc = new MemberController();
	}
	
	/*
	 * 사용자가 보게될 첫 화면(메인화면)
	 * */
	public void mainMenu() {
		while(true) {	
			System.out.println("========== 회원관리 프로그램 ===========");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 정보 변경");
			System.out.println("4. 회원 탈퇴");
			System.out.println("5. 회원 이름으로 키워드 검색");
			System.out.println("6. 회원 일괄 추가");
			System.out.println("7. 회원 일괄 삭제");
			System.out.println("9. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			
			switch(sel) {
			case 1: insertMember(); break;
			case 2: mc.selectMember(); break;
			case 3: updateMember(); break;
			case 4: removeMember(); break;
			case 5: keywordSerch(); break;
			case 6: allInsertMember(); break;
			case 7: allDeleteMember(); break;
			case 9: 
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
			System.out.println();
		}
	}
	
	private void allDeleteMember() {
		System.out.println("========= 회원 추가 ==========");
		
		System.out.print("일괄 추가할 회원의 수를 입력해주세요. : ");
		int n = sc.nextInt();
		sc.nextLine();
		
		List<Member> list = new ArrayList<Member>();
		
		for (int i=0; i<n; i++) {
			System.out.println("아이디 : ");
			String userId = sc.nextLine();
			
			list.add(new Member(userId));
			System.out.println();
		}
		
		mc.allDeleteMember(list);
		
	}

	private void allInsertMember() {
		System.out.println("========= 회원 추가 ==========");
		
		System.out.print("일괄 추가할 회원의 수를 입력해주세요. : ");
		int n = sc.nextInt();
		sc.nextLine();
		
		List<Member> list = new ArrayList<Member>();
		
		for (int i=0; i<n; i++) {
			System.out.println("아이디 : ");
			String userId = sc.nextLine();
			
			System.out.println("비밀번호 : ");
			String userPwd = sc.nextLine();
			
			System.out.println("이름 : ");
			String userName = sc.nextLine();
			
			System.out.println("성별(M, F) : ");
			String gender = sc.nextLine();
			
			System.out.println("나이 : ");
			String age = sc.nextLine();
			
			System.out.println("이메일 : ");
			String email = sc.nextLine();
			
			System.out.println("전화번호(-제외) : ");
			String phone = sc.nextLine();
			
			System.out.println("주소 : ");
			String address = sc.nextLine();
			
			System.out.println("취미(,로 구분) : ");
			String hobby = sc.nextLine();
			
			list.add(new Member(userId, userPwd, userName, gender, Integer.parseInt(age), email, phone, address, hobby));
			System.out.println();
		}
		mc.allInsertMember(list);
		
	}

	private void keywordSerch() {
		System.out.println("========= 회원 검색 =========");
		System.out.print("검색할 회원 이름을 입력해주세요 : ");
		String keyword = sc.nextLine();
		
		mc.keywordSerch(keyword);
	}

	private void removeMember() {
		System.out.println("========= 회원 정보 삭제 ==========");
		while(true) {	
			System.out.print("정보를 삭제할 회원 아이디 : "); 
			String userId = sc.nextLine();
			
			boolean IdCheck = mc.userIdValidation(userId);
			if(IdCheck) {
				mc.removeMember(userId);
				break;
			} else {
				System.out.println("입력하시 아이디는 없는 아이디입니다. 다시 입력해주세요.");
				System.out.println();
			}
		}
	}

	public void updateMember() {
		System.out.println("========= 회원 정보 변경 ==========");
		//어떤 회원의 정보를 수정할 것인가. -> unique 
		//변경할 정보를 입력 -> 이메일, 전화번호, 주소, 취미
		
		while(true) {
			System.out.print("정보를 수정할 회원 아이디 : "); 
			String userId = sc.nextLine();
			boolean IdCheck = mc.userIdValidation(userId);
			
			if(IdCheck) {
				System.out.println();
				System.out.println("변경할 이메일 : ");
				String email = sc.nextLine();
				
				System.out.println("변경할 전화번호(-제외) : ");
				String phone = sc.nextLine();
				
				System.out.println("변경할 주소 : ");
				String address = sc.nextLine();
				
				System.out.println("변경할 취미(,로 구분) : ");
				String hobby = sc.nextLine();
				
				mc.updateMember(userId, email, phone, address, hobby);
				break;
			} else {
				System.out.println("입력하시 아이디는 없는 아이디입니다. 다시 입력해주세요.");
				System.out.println();
			}
		}
		// userId 유효성 검사.
		// 1. sql에 userId를 가져온다. -> select로 찾은 결과 값과 비교
		// 2 -1 true면 update 가능
		// 2 -2 false면 update 불가능

		
	}
	
	public void insertMember() {
		System.out.println("========= 회원 추가 ==========");
		
		System.out.println("아이디 : ");
		String userId = sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String userPwd = sc.nextLine();
		
		System.out.println("이름 : ");
		String userName = sc.nextLine();
		
		System.out.println("성별(M, F) : ");
		String gender = sc.nextLine();
		
		System.out.println("나이 : ");
		String age = sc.nextLine();
		
		System.out.println("이메일 : ");
		String email = sc.nextLine();
		
		System.out.println("전화번호(-제외) : ");
		String phone = sc.nextLine();
		
		System.out.println("주소 : ");
		String address = sc.nextLine();
		
		System.out.println("취미(,로 구분) : ");
		String hobby = sc.nextLine();
		
		mc.insertMember(userId, userPwd, userName, gender, age, email, phone, address, hobby);
		
	}
	
	//===================================응답화면==============================
	//서비스 처리 후 성공 했을 때 사용자가 보게될 화면
	//msg : 객체별로 기능별 성공 매세지
	public void displaySuccess(String msg) {
		System.out.println("\n서비스 요청 성공 : " + msg);
	}
	
	//서비스 처리 후 성공 했을 때 사용자가 보게될 화면
	//msg : 객체별로 기능별 실패 매세지
	public void displayFail(String msg) {
		System.out.println("\n서비스 요청 실패 : " + msg);
	}
	
	public void displayNoData(String msg) {
		System.out.println("\n" + msg);
	}
	
	public void displayList(List list, String title) {
		System.out.println("===========" + title + "===========");
		for(Object o : list) {
			System.out.println(o);
		}
	}

}
