package com.kh.example.abstractNInterface;

public abstract class SmartPhone{
	private String maker;

	public SmartPhone() {
		super();
	}
	
	//각 인터페이스의 메서들의 반환값을 모두 조합해서 반환 (자식에서 구현)
	public abstract String printInfomation();
	
	//제조사 설정
	public void setMaker(String maker){
		this.maker = maker;
	}
	
	//제조사 반환
	public String getMaker() {
		return maker;
	}
	
	
}
