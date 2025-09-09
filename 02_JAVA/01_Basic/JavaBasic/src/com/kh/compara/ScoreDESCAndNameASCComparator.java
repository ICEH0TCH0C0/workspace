package com.kh.compara;

import java.util.Comparator;

public class ScoreDESCAndNameASCComparator implements Comparator<Student>{
	//제네릭이 없을 경우 Object이므로 instanceof로 일일이 다 체크해야함
	@Override
	public int compare(Student o1, Student o2) {
		int sort = o2.getScore() - o1.getScore();
		if(sort == 0) {
			sort = o1.name.compareTo(o2.name);
		}
		return 0;
	} 

}
