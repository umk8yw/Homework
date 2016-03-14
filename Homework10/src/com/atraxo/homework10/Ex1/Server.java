package com.atraxo.homework10.Ex1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try (ServerSocket socket = new ServerSocket(6534)) { 
			System.out.println("Socket is waiting for a client");
			
			Socket sock = socket.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			PrintStream bw = new PrintStream(sock.getOutputStream());
			String temp = br.readLine();
            System.out.print("Received: " + temp);
            bw.println(new StringBuilder(temp).reverse().toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
