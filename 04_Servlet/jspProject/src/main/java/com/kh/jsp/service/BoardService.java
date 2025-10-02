package com.kh.jsp.service;

import static com.kh.jsp.common.JDBCTemplate.close;
import static com.kh.jsp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.jsp.model.dao.BoardDao;
import com.kh.jsp.model.vo.Category;

public class BoardService {
	
	public List<Category> selectCategory() {
		Connection conn = getConnection();
		
		List<Category> list= new BoardDao().selectCategory(conn);
		close(conn);
		return list;
	}
}
