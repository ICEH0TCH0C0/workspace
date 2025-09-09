package com.kh.jdbc.service;

import com.kh.jdbc.model.vo.Book;

//Service는 인터페이스로 구성하고 그 구현체를 따로 생성
//인터페이스 -> 무엇을 할 수 있냐?
//구현채 -> 어떻게 할 수 있냐?

public interface BookService {
	
	public int insertBook(Book b);
	
}
