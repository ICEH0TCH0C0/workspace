package com.kh.example.gearrent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class GearRentController {
	private HashMap<String, Device> catalog = new HashMap<>();
	private HashMap<String, Member> members = new HashMap<>();
	private HashMap<String, Loan> activeLoans = new HashMap<>();
	
	public boolean addDevice(Device device) {
		if(catalog.containsKey(device.getId())) {
			return false;
		}
		catalog.put(device.getId(), device);
		return true;
	}
	
	public boolean addMember(Member member) {
		if(members.containsKey(member.getId())) {
			return false;
		}
		members.put(member.getId(), member);
		return true;
	}
	
	public Loan borrow(String memberId, String itemId, LocalDate today) {
		//— 대여 생성; 장비의 getBorrowLimitDays()로 기한을 계산해 Loan을 만들고 activeLoans에 저장, 
		//장비 대여 수 증가 후 Loan을 반환.
		Device d = catalog.get(itemId);
		if(d == null) return null;
		
		LocalDate due = today.plusDays(d.getBorrowLimitDays());
		Loan loan = new Loan(itemId, memberId, today, due);
		if(activeLoans.containsKey(itemId)) return null;
		
		activeLoans.put(itemId, loan);
//		Loan loan = new Loan(itemId, memberId, today, today.plusDays(d.getBorrowLimitDays()));
		d.increaseBorrowCount();
		return loan;
	}
	
	public int returnItem(String itemId, LocalDate today) {
		//— 반납 처리; 대여 건의 반납일을 today로 기록하고 overdueDays(today)로 연체일을 구해(음수는 0이 되도록 구현됨)
		//장비의 calcLateFee(연체일)로 연체료를 계산, activeLoans에서 제거 후 연체료 int를 반환.
		Loan loan = activeLoans.get(itemId); //대여정보객체
		if(loan == null) return -1;
		
		loan.setReturnedDate(today); //실제 반납일 설정
		int overdueDay = loan.overdueDays(today);
		Device d = catalog.get(itemId); //기기정보객체
		int fee = d.calcLateFee(overdueDay);
		activeLoans.remove(itemId);
		return fee;
	}
	
	public ArrayList<Device> findByTag(String tag) {
		//태그 검색; tag가 null이면 빈 리스트를 반환, catalog의 장비들을 훑어 
		//hasTag(tag)가 참인 장비만 리스트에 담아 정렬 없이 그대로 반환.
		ArrayList<Device> list = new ArrayList<>();
		
		if(tag == null) return list;
		
		for(Device d : catalog.values()) {
			if(d.hasTag(tag)) {
				list.add(d);
			}
		}
		return list;
	}
	
	public ArrayList<Device> findByKeyword(String keyword) {
		//— 키워드 검색; keyword가 null이거나 빈 문자열이면 빈 리스트를 반환,
		//소문자로 통일해 이름 또는 카테고리에 포함되는 장비만 모아 정렬 없이 그대로 반환.
		ArrayList<Device> list = new ArrayList<>();
		
		if(keyword == null || keyword.equals(" ")) return list;
		
		String key = keyword.toLowerCase();
		
		for(Device d : catalog.values()) {
			String name = d.getName().toLowerCase();
			String cat = d.getCatrgory().toLowerCase();
			if(name.contains(key) || cat.contains(key)) {
				list.add(d);
			}
		}
		return list;
	}
	
	public Collection<Device> getAllDevices() {
		//전체 장비 조회; 입력 없음, catalog.values()의 읽기 전용 뷰를 반환해 외부 수정은 막고 순서는 보장하지 않음.
		//읽기 전용 뷰를 만들어준다. -> 추가/삭제/수정 불가
		return Collections.unmodifiableCollection(catalog.values()); 
	}
	
	public Collection<Loan> getActiveLoans() {
		//대여중 목록 조회; 입력 없음, activeLoans.values()의 읽기 전용 뷰를 반환해 외부 수정을 막고 순서는 보장하지 않음.
		return Collections.unmodifiableCollection(activeLoans.values()); 
	}
}
