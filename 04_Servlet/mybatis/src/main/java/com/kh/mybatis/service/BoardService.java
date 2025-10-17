package com.kh.mybatis.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.Template;
import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.model.dao.BoardDao;
import com.kh.mybatis.model.vo.Attachment;
import com.kh.mybatis.model.vo.Board;
import com.kh.mybatis.model.vo.Category;

public class BoardService {
	private BoardDao boardDao = new BoardDao();
	
	public int selectAllBoardCount() {
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = boardDao.selectAllBoardCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}
	
	public ArrayList<Board> selectAllBoard(PageInfo pi){
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Board> list = boardDao.selectAllBoard(sqlSession, pi);
		
		sqlSession.close();
		
		return list;
	}
	
	public int increaseCount(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.increaseCount(sqlSession, boardNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	public Board selectBoardByBoardNo(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Board b = boardDao.selectBoardByBoardNo(sqlSession, boardNo);
		
		sqlSession.close();
		
		return b;
	}
	
	public Attachment selectAttachment(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Attachment at = boardDao.selectAttachment(sqlSession, boardNo);
		
		sqlSession.close();
		
		return at;
	}
	
	public ArrayList<Category> selectAllCategory() {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Category> list = boardDao.selectAllCategory(sqlSession);
		
		sqlSession.close();
		
		return list;
	}
	
	public int insertBoard(Board b, Attachment at) {
		SqlSession sqlSession = Template.getSqlSession();
		
		b.setBoardType(1);
		int result = boardDao.insertBoard(sqlSession, b);
		
		if(at != null) {
			result *= boardDao.insertAttachment(sqlSession, at);
		}
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	public int deleteBoard(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.deleteBoard(sqlSession, boardNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
}