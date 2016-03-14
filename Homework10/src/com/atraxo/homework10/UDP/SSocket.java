package com.atraxo.homework10.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SSocket {

	public static void main(String[] args) {

		try( DatagramSocket serverSocket = new DatagramSocket(9876)) {
			byte[] receiveData = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(receiveData , receiveData.length); 
			serverSocket.receive(receivePacket);
			System.out.println(new String( receivePacket.getData()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
