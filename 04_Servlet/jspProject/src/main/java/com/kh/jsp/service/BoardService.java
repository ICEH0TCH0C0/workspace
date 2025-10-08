package com.kh.jsp.service;

import static com.kh.jsp.common.JDBCTemplate.close;
import static com.kh.jsp.common.JDBCTemplate.commit;
import static com.kh.jsp.common.JDBCTemplate.getConnection;
import static com.kh.jsp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.jsp.model.dao.BoardDao;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Category;

public class BoardService {
	
	public List<Category> selectCategory() {
		Connection conn = getConnection();
		
		List<Category> list= new BoardDao().selectCategory(conn);
		close(conn);
		return list;
	}
	
	public int insertBoard(Board b, int categoryNo) {
		Connection conn = getConnection();
		
		int result = new BoardDao().insertBoard(conn, b, categoryNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public List<Board> selectList(){
		Connection conn = getConnection();
		
		List<Board> list = new BoardDao().selectList(conn);
		close(conn);
		return list;
	}
	
	public Board selectBoard(int boardNo) {
		Connection conn = getConnection();
		BoardDao boardDao = new BoardDao();
		
		// 1. 조회수 증가
		int result = boardDao.increaseCount(conn, boardNo);
		
		Board b = null;
		if(result > 0) { // 조회수 증가 성공 시
			commit(conn);
			// 2. 게시글 조회
			b = boardDao.selectBoard(conn, boardNo);
		} else { // 실패 시
			rollback(conn);
		}
		close(conn);
		return b;
	}
	
	//수정 페이지 전용 board 검색 -> count 증가하지 않기 위해 따로 추가
	public Board selectUpdateBoard(int boardNo) {
		Connection conn = getConnection();
		Board b = new BoardDao().selectBoard(conn, boardNo);
		close(conn);
		return b;
	}
	
	public int updateBoard(Board b) {
		Connection conn = getConnection();
		
		int result = new BoardDao().updateBoard(conn, b);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteBoard(int boardNo) {
		Connection conn = getConnection();
		
		int result = new BoardDao().deleteBoard(conn, boardNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
