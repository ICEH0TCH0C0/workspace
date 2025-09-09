package com.kh.example.collection1;

import java.util.Comparator;

public class AscTitle implements Comparator<Object>{
	
	@Override
	public int compare(Object o1, Object o2) {
		char t1 = ((Music)o1).getTitle().charAt(0);
		char t2 = ((Music)o2).getTitle().charAt(0);
		if (t1 > t2) {
			return 1;
		} else if (t1 == t2 ) {
			char s1 = ((Music)o1).getSinger().charAt(0);
			char s2 = ((Music)o2).getSinger().charAt(0);
			if (s1 > s2) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return -1;
		}
	}

}
