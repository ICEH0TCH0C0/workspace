package com.kh.thread.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) {
		String serverIP = "192.168.10.51";
		int port = 3000;
		
		try {
			Socket socket = new Socket(serverIP, port);
			if(socket != null) {
				ClientRecevie cr = new ClientRecevie(socket);
				cr.start();
				
				ClientSend cs = new ClientSend(socket);
				cs.start();
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
