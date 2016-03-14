package com.atraxo.homework10.question4;

import java.net.ServerSocket;

public class SSocket {

	public static void main(String[] args) {
		try (ServerSocket socket = new ServerSocket(Integer.parseInt(args[0]))) { 
			System.out.println("Socket is waiting for a client");
			socket.accept();
			System.out.println("Conection received");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}