package com.kh.example.abstractNinterfaceVer2;

public class PhoneController {
	private String[] result = new String[1];
	
	public String[] method() {
		Phone[] phone = new Phone[1];
		phone[0] = new GalaxyNote9();
		
		if(phone[0] instanceof Phone) {
			result[0] = ((Phone)phone[0]);
		}
		return result;
	}
}
