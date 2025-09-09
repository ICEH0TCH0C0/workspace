package com.kh.example.abstractNInterface;

public class PhoneController{
	private String[] result = new String[2];
	
	public String[] method() {
		Phone[] phone = new Phone[2];
		
		phone[0] = new GalaxyNoto9();;
		phone[1] = new V40();
		
		for (int i=0; i<phone.length; i++) {
			if (phone[i] instanceof GalaxyNoto9) {
				result[i] = ((GalaxyNoto9)phone[0]).printInfomation();
			} else {
				result[i] = ((V40)phone[1]).printInfomation();
			}
		}
		return result;
	}
}
