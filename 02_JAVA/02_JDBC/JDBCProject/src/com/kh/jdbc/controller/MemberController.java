package com.kh.jdbc.controller;

import java.util.List;

import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.view.MemberMenu;

/*
 * Controller : view를 통해서 사용자가 요청한 기능에 대해 처리하는 객체
 * 				해당 메서드로 전달된 데이터를 가공한 후 dao로 전달하여 기능을 수행
 * 				dao로부터 반환받은 결과에 따라서 성공/실패 여부를 판단해서 응답화면 결정 -> View호출
 * 
 * */

public class MemberController {
	private MemberDao md;
	/*
	 * 사용자의 추가 요청을 처리하는 메서드
	 * userId ~ hobby : 사용자가 입력한 정보를 매개변수로 받음
	 * */
	public MemberController() {
		super();
		this.md  = new MemberDao();
	}
	
	public void insertMember(String userId, String userPwd, String userName, String gender, String age, String email,
			String phone, String address, String hobby) {
		//View로부터 전달받은 값을 바로 dao에 전달 x
		//vo에 잘 담아서 전달
		Member m = new Member(userId, userPwd, userName, gender, 
								Integer.parseInt(age), email, phone, address, hobby);
		
		int result = md.insertMember(m);
		
		if(result > 0) {
			//성공화면
			new MemberMenu().displaySuccess("성공적으로 회원이 추가되었습니다.");
		} else {
			//실패화면
			new MemberMenu().displayFail("회원 추가를 실패하였습니다.");
		}
	}
	
	//회원 모두 조회
	public void selectMember() {
		List<Member> list = md.selectMemberList();
		
		//조회된 결과에 따라서 사용자가 보게될 화면
		if(list.isEmpty()) {
			new MemberMenu().displayNoData("회원목록 조회 결과가 없습니다.");
		} else {
			new MemberMenu().displayList(list, "회원목록");
		}
	}
	
	//userId, email, phone, address, hobby를 전달받아 
	//Member를 수정하는 메서드
	public void updateMember(String userId, String email, 
				String phone, String address, String hobby) {
		
		Member m = new Member();
		m.setUserId(userId);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		m.setHobby(hobby);
		
		int result = md.updateMember(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원정보를 수정하였습니다.");
		} else {
			new MemberMenu().displayFail("회원정보를 수정하는데 실패하였습니다.");
		}
	}
	
	public void removeMember(String userId) {
		Member m = new Member();
		m.setUserId(userId);
		
		int result = md.removeMemeber(m);
		
		
		if(result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원정보를 삭제하였습니다.");
		} else {
			new MemberMenu().displaySuccess("회원정보를 삭제하는데 실패하였습니다.");
		}
	}
	
	public boolean userIdValidation(String userId) {
		Member m = new Member();
		m.setUserId(userId);
		
		boolean check = md.userIdValidation(m);
		
		if(!check) {
			new MemberMenu().displayNoData("회원목록 조회 결과가 없습니다.");
		} else {
			new MemberMenu().displaySuccess("입력하신 아이디가 존재합니다.");
			return true;
		}
		return false;
	}
}
