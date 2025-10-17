package com.kh.mybatis.model.dao;


import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.vo.Member;

public class MemberDao {
	public Member loginMember(SqlSession sqlSession, String userId,String userPwd) {
		HashMap<String, String> map = new HashMap<>();
		map.put("memberId", userId);
		map.put("memberPwd", userPwd);
		
		//member-mapper.xml의 namespace가 MemberMapper인 maaper태그에서 sql문이 loginMember를 실행
		//값을 넣은 map을 보내고 member-mapper.xml의 결과값이 Member 타입이므로 Member로 받아 리턴
		Member loginMember = sqlSession.selectOne("MemberMapper.loginMember", map);
		return loginMember;
	}
	
	//변수를 그대로 보내면, member-maaper.xml에서 #{checkId}로 받음
	//만약 int 형태로 보낼경우 #{}대신 ${}로 받으면 됨
	public int idCheck(SqlSession sqlSession, String checkId) {
		return sqlSession.selectOne("MemberMapper.idCheck", checkId);
	}
	
	//객체를 보내고 정수형태로 받아서 반환
	public int insertMember(SqlSession sqlSession, Member m) {
		return sqlSession.insert("MemberMapper.insertMember", m);
	}
	
	public int updateMember(SqlSession sqlSession, Member updateMember) {
		return sqlSession.update("MemberMapper.updateMember", updateMember);
	}
	
	public Member selectMemberByUserId(SqlSession sqlSession, String memberId) {
		Member updateMember = sqlSession.selectOne("MemberMapper.selectMemberByUserId", memberId);
		
		return updateMember;
	}
	
	public int updateMemberPwd(SqlSession sqlSession, String userId, String userPwd) {
		HashMap<String, String> map = new HashMap<>();
		map.put("memberId", userId);
		map.put("memberPwd", userPwd);
		
		return sqlSession.update("MemberMapper.updateMemberPwd", map);
	}
}