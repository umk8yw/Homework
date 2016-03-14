package com.atraxo.homework10.UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class CSocket {

	public static void main(String[] args) {

		try (BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
				DatagramSocket clientSocket = new DatagramSocket()) {
			InetAddress IPAddress = InetAddress.getByName("localhost");
			byte[] sendData = new byte[1024];
			String sentence = inFromUser.readLine();
			sendData = sentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
			clientSocket.send(sendPacket);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
