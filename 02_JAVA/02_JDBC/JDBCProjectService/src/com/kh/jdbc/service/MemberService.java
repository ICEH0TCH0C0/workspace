package com.kh.jdbc.service;

import java.sql.Connection;
import java.util.List;

//static으로 import시 static 메서드를 직접 가져와서 사용할 수 있음
import static com.kh.jdbc.common.JDBCTemplate.*;
import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;

/*
 * Service
 * 트랜잭션 관리와 같은 비즈니스 로직을 처리하는 계층, Dao와 Controller의 중간역할
 * 
 * */

public class MemberService {
	private MemberDao md;
	
	public MemberService() {
		super();
		this.md = new MemberDao();
	}

	public int insertMember(Member m) {
		Connection conn = getConnection(); //JDBCTemplate의 static메서드
		
		int result = new MemberDao().insertMember(m, conn); 
		
		if(result > 0) {
			commit(conn); //JDBCTemplate의 static메서드
		} else {
			rollback(conn); //JDBCTemplate의 static메서드
		}
		close(conn);
		return result;
	} 
	
	public List<Member> selectMemberList(){
		Connection conn = getConnection(); //JDBCTemplate의 static메서드
		
		List<Member> list = new MemberDao().selectMemberList(conn);
		close(conn);
		return list;
	}
	
	public int updateMember(Member m) {
		Connection conn = getConnection(); //JDBCTemplate의 static메서드
		
		int result = new MemberDao().updateMember(m, conn); 
		
		if(result > 0) {
			commit(conn); //JDBCTemplate의 static메서드
		} else {
			rollback(conn); //JDBCTemplate의 static메서드
		}
		close(conn);
		return result;
	}
	
	public int deleteMember(Member m) {
		Connection conn = getConnection(); //JDBCTemplate의 static메서드
		
		int result = new MemberDao().deleteMember(m, conn); 
		
		if(result > 0) {
			commit(conn); //JDBCTemplate의 static메서드
		} else {
			rollback(conn); //JDBCTemplate의 static메서드
		}
		close(conn);
		return result;
	}
	
	public boolean userIdValidation(Member m) {
		Connection conn = getConnection(); //JDBCTemplate의 static메서드
		
		boolean check = new MemberDao().userIdValidation(m, conn); 
		close(conn);
		return check;
	}
	
	public List<Member> keywordSerch(String ketword) {
		Connection conn = getConnection(); //JDBCTemplate의 static메서드
		
		List<Member> list = new MemberDao().keywordSerch(ketword, conn); 
		
		close(conn);
		return list;
	}
	
	public int[] allInsertMember(List<Member> list) {
		Connection conn = getConnection(); //JDBCTemplate의 static메서드
		
		int[] result = new MemberDao().allInsertMember(list, conn); 
		
		for(int i=0;i<result.length; i++) {
			if(result[i] > 0) {
				commit(conn); //JDBCTemplate의 static메서드
			} else {
				rollback(conn); //JDBCTemplate의 static메서드
			}
		}
		close(conn);
		return result;
	} 
	
	public int[] allDeleteMember(List<Member> list) {
		Connection conn = getConnection(); //JDBCTemplate의 static메서드
		
		int[] result = new MemberDao().allDeleteMember(list, conn); 
		
		for(int i=0;i<result.length; i++) {
			if(result[i] > 0) {
				commit(conn); //JDBCTemplate의 static메서드
			} else {
				rollback(conn); //JDBCTemplate의 static메서드
			}
		}
		close(conn);
		return result;
	} 
}
