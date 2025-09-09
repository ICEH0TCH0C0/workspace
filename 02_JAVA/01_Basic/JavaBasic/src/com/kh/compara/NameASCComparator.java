package com.kh.compara;

import java.util.Comparator;

public class NameASCComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		
		return o1.name.compareTo(o2.name); //문자열 비교(가나다/알파벳 -> 유니코드 순)
	}
	
}
