package com.kh.example.abstractNinterfaceVer2;

public class GalaxyNote9 extends SmartPhone implements Phone, Camera, CellPhone, TouchDisplay, NotePen{

	public GalaxyNote9() {
		this.setMaker("삼성");
	}

	public String makeCall() {
		return "번호를 누르고 통화버튼을 누름";
	}
	
	public String takeCall() {
		return "수신 버튼을 누름";
	}
	
	public String picture() {
		return "1200만 듀얼 카메라";
	}
	
	public String charge() {
		return "고속 충전, 고속 무선 충전";
	}
	
	public String touch() {
		return "정전식, 와콤펜 지원";
	}
	
	public boolean bluetoothPen() {
		return true;
	}
	
	@Override
	public String printInformation() {
		return super.printInformation();
	}
}
