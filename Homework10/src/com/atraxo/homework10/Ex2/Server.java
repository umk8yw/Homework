package com.atraxo.homework10.Ex2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	static void log(String message, boolean isClient) {
		System.out.println((isClient ? "Client: " : "Server: ") + message);
	}

	public static void main(String[] args) {
		try (ServerSocket socket = new ServerSocket(6535)) {
			while (true) {
				System.out.println("Socket is waiting for a client");

				Socket sock = socket.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				PrintStream bw = new PrintStream(sock.getOutputStream());
				String answer = br.readLine();
				log(answer, true);
				if (answer.equalsIgnoreCase("ping"))
					bw.println("pong");
				log("pong", false);
				String nextAnswer = br.readLine();
				log(nextAnswer, true);
				if (nextAnswer.equalsIgnoreCase("who's there?")) {
					bw.println("I am the server");
					log("I am the server", false);
					bw.println("who are you?");
					log("who are you?", false);
				}
				log(br.readLine(), true);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
