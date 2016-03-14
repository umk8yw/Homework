package com.atraxo.homework10.Ex2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Clients {

	public static void main(String[] args) {
		for (int i = 1; i<=10; i++)
		new Client(i).doClient();
	}
}

class Client {
	
	int id;
	public Client(int id) {
		this.id = id;
	}
	
	void doClient() {
		try(Socket socket = new Socket("localhost", 6535)){
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream  bw = new PrintStream(socket.getOutputStream());
            bw.println("ping");
            String answer = br.readLine();
            if (answer.equalsIgnoreCase("pong"))
            	bw.println("who's there?");
            String nextAnswer1 = br.readLine();
            String nextAnswer2 = br.readLine();
            if (nextAnswer1.equalsIgnoreCase("I am the server"))
            	if(nextAnswer2.equalsIgnoreCase("who are you?"))
            		bw.println("I am the client" + this.id);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}