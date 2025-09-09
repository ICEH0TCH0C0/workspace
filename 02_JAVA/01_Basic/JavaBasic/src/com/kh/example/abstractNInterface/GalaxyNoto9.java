package com.kh.example.abstractNInterface;

public class GalaxyNoto9 extends SmartPhone 
	implements Phone, Camera, CellPhone, TouchDisplay, NotePen{
	
	public GalaxyNoto9() {
		setMaker("삼성");;
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
		return "정전식" + ", " + "와콤펜 지원";
	}

	public boolean bluetoothPen() {
		return PEN_BUTTON;
	}

	public String printInfomation() {
		String str = "갤럭시 노트9은 "+ getMaker() + "에서 만들어졌고 제원은 다음과 같다.\n";
		str += makeCall() + "\n";
		str += takeCall() + "\n";
		str += picture() + "\n";
		str += charge() + "\n";
		str += touch() + "\n";
		str += "블루투스 펜 탑재 여부 " + bluetoothPen() + "\n";
		return  str;
	}
}
