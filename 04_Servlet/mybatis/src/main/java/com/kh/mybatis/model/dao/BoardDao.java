package com.kh.mybatis.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.model.vo.Board;

public class BoardDao {
	
	public int selectAllBoardCount(SqlSession sqlSession) {
		return sqlSession.selectOne("BoardMapper.selectAllBoardCount");
	}
	
	public ArrayList<Board> selectAllBoard(SqlSession sqlSession, PageInfo pi){
		//mybatis에서 자체적으로 페이징 처리를 위해 RowBounds라는 class를 제공
		//offset : 몇개의 게시글을 건너뛰고 조회할 것인가
		//boardLimit : 몇개의 게시글을 가지고 올 것인가
		
		//한페이지 보여줄 boardLimit 10개
		// 1 -> 0개
		// 2 -> 10개 
		// 3 -> 20개
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("BoardMapper.selectAllBoard", null, rowBounds);
		
		return list;
		
	}
	
}
