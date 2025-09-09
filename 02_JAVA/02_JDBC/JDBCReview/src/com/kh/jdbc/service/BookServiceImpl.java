package com.kh.jdbc.service;

import java.sql.Connection;

import static com.kh.jdbc.common.JDBCTemplate.*;

import com.kh.jdbc.model.dao.BookDao;
import com.kh.jdbc.model.vo.Book;

public class BookServiceImpl implements BookService {
	
	@Override
	public int insertBook(Book b) {
		//Dao 추가한 후 트랜잭션 처리
		Connection conn = getConnection();
		int result = new BookDao().insertBook(b, conn);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
	
	
	
}
