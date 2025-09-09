package com.kh.jdbc.model.vo;

public class Book {
	private Long bookId; //래퍼클래스로 원시타입을 객체타입으로 변환 -> 기본값 null
	private String title;
	private String author;
	private String pub;

	public Book() {
		super();
	}

	public Book(Long bookId, String title, String author, String pub) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.pub = pub;
	}
	
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

	@Override
	public String toString() {
		return "[title=" + title + ", author=" + author + ", pub=" + pub + "]";
	}
	
	
}
