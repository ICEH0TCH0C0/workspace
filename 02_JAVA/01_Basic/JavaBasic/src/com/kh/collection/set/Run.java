package com.kh.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Run {
	
	/*
	 * set
	 * 순서가 없고, 중복을 허용하지 않는 자료구조
	 * index개념이 없어서 위치기반 접근(get(index))이 불가
	 * HashSet : 일반적인 해시알고리즘이 적용된 set
	 * LinkedHashSet : hashSet + 순서유지
	 * TreeSet : 자동정렬 기능 제공
	 * 
	 * */
	
	public static void main(String[] args) {
		//생성
		Set<Human> set = new HashSet<>();
		
		//추가
		set.add(new Human("홍길동", 20));
		set.add(new Human("홍길동", 25));
		set.add(new Human("홍길서", 20));
		set.add(new Human("홍길남", 25));
		System.out.println(set);
		//set에 저장해서 사용하는 객체(Human)는 equals와 hashcode를 오버라이딩해야한다.
		//set은 hashCode()로 분류 후 equals()로 바교해서 중복값을 검사함

		set.add(new Human("홍길동", 20));
		set.add(new Human("홍길동", 25));
		System.out.println(set); //동일객체는 추가가 되지 않음
		
		Human h1 = new Human("홍길남", 25);
		Human h2 = new Human("홍길남", 25);
		
		//동일객체 : (h1.equals(h2) && h1.hashCode() == h2.hashCode())
		//객체마다의 정의돈 hashCode와 equals의 결과가 모두 일치하는 객체
		//equals와 hashcode를 오버라이딩하지 않으면 Object의 equals와 hashcode를 사용
		//Object의 equals -> 주소값 비교
		//Object의 hashCode -> 주소값을 가지고 10진수형태의 해시값을 구한것
		
		//contains() 요소에 포함여부 확인
		System.out.println("홍길남이 존재? : " + set.contains(h2)); //true
		
		//remove(E e)
		set.remove(h1);
		System.out.println("삭제 후 : " + set);
		
		//size()
		System.out.println("size : " + set.size());
		
		//set의 모든 요소에 순차적으로 접근하는 방법
		//set은 index가 없기 때문에 get()을 사용할 수 없음
		
		//1. for ~ each
		for(Human h : set) {
			System.out.println(h);
		}
		
		//2. ArrayList에 담아서 반복 -> addAll(Collection c)
		ArrayList list = new ArrayList();
		list.addAll(set);
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//3. Iterator(반복자 인터페이스)를 활용
		//컬렉션에 저장된 요소를 순차적으로 접근하기 위한 인터페이스
		//순서가 없는 set같은 자료구조를 탐색할 때 반드시 필요
		//hasNext() : 다음 읽을 요소가 있으면 true, 없으면 false
		//next() : 다음 요소를 반환
		Iterator<Human> it = set.iterator();
		while(it.hasNext()) {
			Human h = it.next(); //다음 요소 꺼내기
			System.out.println(h);
		}

	}

}
