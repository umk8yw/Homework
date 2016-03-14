package com.atraxo.homework10.question4;

import java.net.Socket;

public class CSocket {

	public static void main(String[] args) {
		try(Socket socket = new Socket("localhost", Integer.parseInt(args[0]))){
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
