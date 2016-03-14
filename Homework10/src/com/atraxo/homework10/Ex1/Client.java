package com.atraxo.homework10.Ex1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try(Socket socket = new Socket("localhost", 6534)){
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream  bw = new PrintStream(socket.getOutputStream());
			System.out.print("Message: " );
			BufferedReader ed = new BufferedReader(new InputStreamReader(System.in));
            String temp = ed.readLine();
            bw.println(temp);
            String answer = br.readLine();
            System.out.print("Received: " + answer);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
