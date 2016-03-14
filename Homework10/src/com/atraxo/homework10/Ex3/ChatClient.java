package com.atraxo.homework10.Ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ChatClient {

	private Socket socket;
	private PrintStream printStream;
	
	ChatClient() {
		try {
			socket = new Socket("localhost", 6543);
			printStream = new PrintStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		System.out.println("~~~~~~~~~~~~ START CHAT ~~~~~~~~~~~~");
		
		ChatClient chatClient = new ChatClient();
		Thread thread = new Thread(() -> chatClient.runThread());
		thread.start();
		chatClient.runClient();
	}
	
	void runThread(){
		while (true)
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println("\n" + br.readLine());
				System.out.print(socket.getLocalPort() + " : ");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	void runClient(){
		try {
			while (true) {
				BufferedReader toSendReader = new BufferedReader(new InputStreamReader(System.in));
				System.out.print(socket.getLocalPort() + " : ");
				String toSend = toSendReader.readLine();
				printStream.println(toSend);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
