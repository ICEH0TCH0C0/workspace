package com.kh.jdbc.model.dao;

import static com.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import com.kh.jdbc.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();
	
	public MemberDao() {
		super();
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertMember(Member m, Connection conn) { //성공하면 1 실패하면 0
		//insertMember -> insert -> 처리된 행 수(int)
		
		//필요한 변수 세팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		//실행할 sql(sql뒤에 ;없어야함)
		String sql = prop.getProperty("insertMember");
		
		try {
			//Member Service에서 등록
			
			//미완성 sql문으로 ?의 값을 전부 채워야함
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//회원목록을 반환하는 메서드
	public ArrayList<Member> selectMemberList(Connection conn){
		//select문(여러개) -> ResultSet -> ArrayList 담기
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectMemberList");
		
		try {
			//완성된 sql
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				//timestamp를 사용 만약 sql에서 Timestamp타입일 경우 .toLocalDateTime()은 없어도 됨
				m.setEnrollDate(rset.getTimestamp("ENROLL_DATE").toLocalDateTime());
				
				//저장된 Member를 list를 저장 
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//Member객체 m을 통해서 update sql을 전달하는 메서드
	public int updateMember(Member m, Connection conn) {
		//update문 -> 처리된 행의 수 : int -> 트랜잭션 처리(commit or rollback)
		int result = 0;
		PreparedStatement pstmt = null;
		
		//실행할 sql(sql뒤에 ;없어야함)
		String sql = prop.getProperty("updateMember");
		
		try {
			//미완성 sql문으로 ?의 값을 전부 채워야함
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getHobby());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteMember(Member m, Connection conn) {
		//delete문 -> 처리된 행 수 : int -> 트랜잭션처리
		
		//필요한 변수 세팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		//실행할 sql(sql뒤에 ;없어야함!!!)
		String sql = prop.getProperty("deleteMember");
		
		try {	
			//아직 미완성 sql문으로 ?의 값을 전부 채워야함
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, m.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public boolean userIdValidation(Member m, Connection conn){
		boolean check = false;
		ResultSet rset = null;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("userIdValidation");
		
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			
			rset = pstmt.executeQuery();
			
			check = rset.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return check;
	}
	
	public ArrayList<Member> keywordSerch(String keyword, Connection conn){
		ArrayList<Member> list = new ArrayList<>();
		ResultSet rset = null;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("keywordSerch");
		
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				//timestamp를 사용 만약 sql에서 Timestamp타입일 경우 .toLocalDateTime()은 없어도 됨
				m.setEnrollDate(rset.getTimestamp("ENROLL_DATE").toLocalDateTime());
				
				//저장된 Member를 list를 저장 
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int[] allInsertMember(List<Member> list, Connection conn) { //성공하면 1 실패하면 0
		//insertMember -> insert -> 처리된 행 수(int)
		
		//필요한 변수 세팅
		int[] result = {};
		PreparedStatement pstmt = null;
		
		//실행할 sql(sql뒤에 ;없어야함)
		String sql = prop.getProperty("allInsertMember");
		
		try {
			//Member Service에서 등록
			
			//미완성 sql문으로 ?의 값을 전부 채워야함
			pstmt = conn.prepareStatement(sql);
			
			for (int i=0; i<list.size(); i++) {
				
				pstmt.setString(1, list.get(i).getUserId());
				pstmt.setString(2, list.get(i).getUserPwd());
				pstmt.setString(3, list.get(i).getUserName());
				pstmt.setString(4, list.get(i).getGender());
				pstmt.setInt(5, list.get(i).getAge());
				pstmt.setString(6, list.get(i).getEmail());
				pstmt.setString(7, list.get(i).getPhone());
				pstmt.setString(8, list.get(i).getAddress());
				pstmt.setString(9, list.get(i).getHobby());
				
				pstmt.addBatch();
			}
			
			result = pstmt.executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int[] allDeleteMember(List<Member> list, Connection conn) { //성공하면 1 실패하면 0
		//insertMember -> insert -> 처리된 행 수(int)
		
		//필요한 변수 세팅
		int[] result = {};
		PreparedStatement pstmt = null;
		
		//실행할 sql(sql뒤에 ;없어야함)
		String sql = prop.getProperty("allDeleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for (int i=0; i<list.size(); i++) {
				
				pstmt.setString(1, list.get(i).getUserId());
				
				pstmt.addBatch();
			}
			
			result = pstmt.executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
