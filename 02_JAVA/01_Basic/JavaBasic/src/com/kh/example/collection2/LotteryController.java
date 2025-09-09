package com.kh.example.collection2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class LotteryController {
	HashSet<Lottery> lottery = new HashSet<>();
	HashSet<Lottery> win = new HashSet<>();
	
	public boolean insertObject(Lottery l) {
		return lottery.add(l); //성공시 true
	}
	
	public boolean deleteObject(Lottery l) {
		boolean isRemove = lottery.remove(l);
		if(win!= null && isRemove) {
			win.remove(l);
		}
		return isRemove;
	}
	
	public HashSet<Lottery> winObject() {
		//남은 인원만 선발
		if(win.size() < 4) {
			Random read = new Random();
			
			ArrayList<Lottery> list = new ArrayList<>();
			list.addAll(lottery);
			
			while(win.size() < 4 && win.size() != lottery.size()) {
				int index = read.nextInt(list.size()); //0~size()-1 중 랜덤으로 정수 추출
				win.add(list.get(index)); 
				//list는 순번이 있기 때문에 list의 크기만큼의 정수를 추출해서 win에 add
			}
		}
		return win;
	}
	
	public boolean searchWinner(Lottery l) {
		return win.contains(l); //매개변수 l의 값이 win에 존재하는 지 확인.
	}
}
