package com.kh.example.gearrent;

import java.util.Set;

public class Camera extends Device{
	//부모 클래스인 Device에 기본 생성자가 없기 때문에 생성.
	public Camera(String id, String name, String catrgory, Set<String> tags) {
		super(id, name, catrgory, tags);
	}

	@Override
	public int getBorrowLimitDays() {
		return 7;
	}

	@Override
	public int calcLateFee(int overdueDays) {
		return	300 * overdueDays;
	}
	
	
	
}
