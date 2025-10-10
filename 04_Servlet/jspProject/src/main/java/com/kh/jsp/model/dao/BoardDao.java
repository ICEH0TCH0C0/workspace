package com.kh.jsp.model.dao;

import static com.kh.jsp.common.JDBCTemplate.close;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jsp.common.JDBCTemplate;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Category;

import jakarta.servlet.http.Part;

public class BoardDao {
	private Properties prop = new Properties();
	
	public BoardDao(){
		super();
		
		String path = JDBCTemplate.class.getResource("/db/sql/board-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// DB에서 카테고리 목록 조회
	public ArrayList<Category> selectCategory(Connection conn){
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Category> list = new ArrayList<>();
		
		String sql = prop.getProperty("selectCategory");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Category c = new Category();
				
				c.setCategoryNo(rset.getInt("CATEGORY_NO"));
				c.setCategoryName(rset.getString("CATEGORY_NAME"));
				list.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	// DB에서 게시글 목록 조회
	public ArrayList<Board> selectList(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<>();
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setCategoryName(rset.getString("CATEGORY_NAME"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardWriterName(rset.getString("MEMBER_NAME"));
				b.setCount(rset.getInt("COUNT"));
				b.setCreateDate(rset.getDate("CREATE_DATE"));

				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	// DB에 게시글 삽입
	public int insertBoard(Connection conn, Board b, int categoryNo) {
		String sql = prop.getProperty("insertBoard");
		int result = 0;
		try (PreparedStatement pstmt1 = conn.prepareStatement(sql)){

			pstmt1.setInt(1, b.getBoardType());
			pstmt1.setInt(2, categoryNo);
			pstmt1.setString(3, b.getBoardTitle());
			pstmt1.setString(4, b.getBoardContent());
			pstmt1.setInt(5, Integer.parseInt(b.getBoardWriter())); // boardWriter는 회원번호이므로 int로 변환하여 설정
			
			result = pstmt1.executeUpdate();

			if(b.getBoardType() == 2) {
				try(PreparedStatement pstmt2 = conn.prepareStatement(prop.getProperty("selectBoardNo"));
					ResultSet rset = pstmt2.executeQuery()) {
					if(rset.next()) {
						result = rset.getInt(1); // insert와 boardNo 검색 성공시 BoardNo를 반환
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; 
	}
	
	public String selectFilePath(Connection conn, int boardNo) {
		String path = "";
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectFilePath");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				path = rset.getString(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return path;
	}
	
	public int insertFile(Connection conn, Part upfile, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		String fileName = Paths.get(upfile.getSubmittedFileName()).getFileName().toString(); // 파일 이름 가져오기 file.getName은 java io이며, 서블릿은 이 방법으로 사용
		
		String baseDir = "C:/workspace/04_Servlet/jspProject/fileRepository/";
		String saveDir = baseDir + boardNo + "/";
		
		File file = new File(saveDir + fileName);
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, fileName);
			pstmt.setString(3,  fileName); // CHANGE_NAME이지만, 처음은 ORIGIN_NAME와 같은 값으로 설정 후 update로 변경
			pstmt.setString(4, saveDir + fileName); // FILE PATH
			pstmt.setInt(5, file.isFile() == true ? 2 : 1); //file이 파일일경우 파일레벨을 2로 저장, 아닐경우 1로 저장. (2는 파일 시스템의 마지막 부분, 1은 file의 부모인 폴더)
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// DB에서 게시글 조회수 증가
	public int increaseCount(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// DB에서 특정 게시글 상세 조회
	public Board selectBoard(Connection conn, int boardNo) {
		Board b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO")); // selectBoard 쿼리가 없지만, 일반적인 형태로 수정
				b.setCategoryName(rset.getString("CATEGORY_NAME"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardContent(rset.getString("BOARD_CONTENT"));
				b.setBoardWriterName(rset.getString("MEMBER_NAME"));
				b.setCreateDate(rset.getDate("CREATE_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return b;
	}
	
	// DB에서 게시글 정보 수정
	public int updateBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getCategoryNo());
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setInt(4, b.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// DB에서 게시글 상태 'N'으로 변경 (삭제 처리)
	public int deleteBoard(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
