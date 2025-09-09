package com.kh.jdbc.controller;

import com.kh.jdbc.model.vo.Book;
import com.kh.jdbc.service.BookService;
import com.kh.jdbc.view.BookMenu;

public class BookController {
	
	private BookService bs;

	public BookController(BookService bs) {
		super();
		this.bs = bs;
	}

	public void insertBoard(String title, String author, String pub) {
		Book b = new Book(null, title, author, pub);
		int result = bs.insertBook(b);
		
		if(result > 0) {
			new BookMenu().displaySuccess("도서 등록");
		} else {
			new BookMenu().displayFail("도서 등록");
		}
	}
}
