package com.kh.multi;

import com.kh.thread.runable.Task;

public class Run {

	public static void main(String[] args) {
		Task t1 = new Task();
		Task t2 = new Task();
		
		t1.start();
		t2.start();
	}

}
