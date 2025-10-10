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

import jakarta.servlet.http.Part;

public class BoardService {
	
	// 카테고리 목록 조회
	public List<Category> selectCategory() {
		Connection conn = getConnection();
		
		List<Category> list= new BoardDao().selectCategory(conn);
		close(conn);
		return list;
	}
	
	// 게시글 등록
	public Boolean insertBoard(Board b, int categoryNo, Part file ) {
		Connection conn = getConnection();
		boolean insertcheck = false; // 플레그 생성
		
		try {
			int boardNo = new BoardDao().insertBoard(conn, b, categoryNo);
			System.out.println(boardNo);
			if(boardNo == 0) throw new Exception("Board INSERT 실패");
			// insert 실패시 오류를 만들고 던지면 밖의 catch가 잡아서 rollback
			
			if(file != null && file.getSize() > 0) {
				int result = new BoardDao().insertFile(conn, file, boardNo);
				if(result == 0) throw new Exception("파일 INSERT 실패");
				// insert 실패시 오류를 만들고 던지면 밖의 catch가 잡아서 rollback
				System.out.println(result);
			}

			commit(conn);
			insertcheck = true; //플레그 전환
			
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		return insertcheck;
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
