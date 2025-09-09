package com.kh.example.collection2;

import java.util.Objects;

import com.kh.collection.set.Human;

public class Lottery {
	private String name;
	private String phone;
	
	public Lottery() {
		super();
	}

	public Lottery(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Lottery) {
			Lottery l = (Lottery)obj;
			return this.name.equals(l.name) && this.phone.equals(l.getPhone());
		}
		return false;
	}

	@Override
	public String toString() {
		return name+"("+phone+")";
	}
	
	
}
