package com.kh.example.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class MemberController {
	HashMap<String, Member> map = new HashMap<>();
	
	public boolean joinMembership(String id, Member m) {
		if (map.containsKey(id)) {
			return false;
		} else {
			map.put(id, m);
			return true;
		}
	}
	
	public String logIn(String id, String password) {
		Member m = map.get(id);
		if(m != null && m.getPassword().equals(password)) {
			return m.getName();
		} else {
			return null;
		}
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		Member m = map.get(id);
		if(m != null && m.getPassword().equals(oldPw)) {
			m.setPassword(newPw);
			return true;
		} 
		return false;
	}
	
	public void changeName(String id, String newName) {
		Member m = map.get(id);
		if(m != null) {
			m.setName(newName);
		}
	}
	
	public TreeMap<String, String> sameName(String name) {
		TreeMap<String, String> tMap = new TreeMap<>();
		for (Map.Entry<String, Member> e : map.entrySet()) {
			Member m = e.getValue();
			if(m != null && m.getName().equals(name)) {
				tMap.put(e.getKey(), m.getName());
			}
		}
		return tMap;
	}
}
