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
	
	// 카테고리 목록 조회
	public List<Category> selectCategory() {
		Connection conn = getConnection();
		
		List<Category> list= new BoardDao().selectCategory(conn);
		close(conn);
		return list;
	}
	
	// 게시글 등록
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
	
	// 게시글 목록 조회
	public List<Board> selectList(){
		Connection conn = getConnection();
		
		List<Board> list = new BoardDao().selectList(conn);
		close(conn);
		return list;
	}
	
	// 게시글 상세 조회 (조회수 증가)
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
	
	// 게시글 수정 페이지용 상세 조회 (조회수 증가 X)
	public Board selectUpdateBoard(int boardNo) {
		Connection conn = getConnection();
		Board b = new BoardDao().selectBoard(conn, boardNo);
		close(conn);
		return b;
	}
	
	// 게시글 수정
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
	
	// 게시글 삭제
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
