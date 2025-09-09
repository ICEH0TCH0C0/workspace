package com.kh.compara;

import java.util.Comparator;

public class ScoreDESCComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		//내림차순 o2 vs o1
		return o2.getScore() - o1.getScore();
	}
	
}
