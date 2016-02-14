package com.atraxo.homework7;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Ex2b {

	public static void main(String[] args) {

		Ex2b ex = new Ex2b();
		Account2 account = new Account2();
		
		account.setId(12323);
		account.setPassword("Pa$$w0rd");

		ex.serialize(account);
		
		Account2 acc = new Account2();
		ex.deserialize(acc);
	}
	
	public void serialize(Account2 account) {

		try (FileOutputStream fileOut = new FileOutputStream("account2.ser");
				ObjectOutputStream outStream = new ObjectOutputStream(fileOut);) {

			outStream.writeObject(account);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deserialize(Account2 account) {

		try(FileInputStream fileIn = new FileInputStream("account2.ser");
				ObjectInputStream inStream = new ObjectInputStream(fileIn);){
			
			account = (Account2) inStream.readObject();
			
			System.out.println(account.getId());
			System.out.println(account.getPassword());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class Account2 implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private transient String password;

	public Account2() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}