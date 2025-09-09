package com.kh.example.gearrent;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Loan {
	private String itemId;
	private String memberId;
	private LocalDate loanDate;//대여일
	private LocalDate dueDate;//반납 예정일
	private LocalDate returnedDate;//실제 반납일
	
	public Loan(String itemId, String memberId, LocalDate loanDate, LocalDate dueDate) {
		super();
		this.itemId = itemId;
		this.memberId = memberId;
		this.loanDate = loanDate;
		this.dueDate = dueDate;
	}
	
	public boolean isOverdue(LocalDate today) {
//		- 대여 건이 연체 상태인지 아닌지를 판단, today(현재 날짜)를 입력받아 반납 완료면 반납일,
//		미반납이면 today를 기준으로 해달 기준 날짜 이후면 true, 같거나 이전이면 false를 반환		
		
		//계산기준일(반납날짜 또는 오늘)
		LocalDate day = (returnedDate != null) ? returnedDate : today;
		
		//기준일이 마감일(dueDate)보다 늦으면 연체 발생
		return day.isAfter(dueDate);
		
	}
	
	public int overdueDays(LocalDate today) {
//		- 연체 일수를 계산, today(현재 날짜)를 입력받아 반납 완료면 반납일, 미반납이면 today를 기준으로,
//		기준 날짜가 기한을 넘겼다면 기준 날짜와 기한 사이의 경과 ‘일수’를 반환하고, 넘기지 않았다면 0을 반환.
		LocalDate day = (returnedDate != null) ? returnedDate : today;
		
		if(day.isAfter(dueDate)) {
			long days = ChronoUnit.DAYS.between(dueDate, day);
			return (int)Math.abs(days);
		} 
		return 0;
	}
	
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}

	@Override
	public String toString() {
		return "Loan [itemId=" + itemId + ", memberId=" + memberId + ", loanDate=" + loanDate + ", dueDate=" + dueDate
				+ ", returnedDate=" + returnedDate + "]";
	}
	
	
}
