package com.atraxo.homework7;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
//[ZP] - 6
public class Ex2a {

	public static void main(String[] args) {

		Ex2a ex = new Ex2a();
		Account1 account = new Account1();
		
		account.setId(12323);
		account.setPassword("Pa$$w0rd");

		ex.serialize(account);
		
		Account1 acc = new Account1();
		ex.deserialize(acc);
	}

	public void serialize(Account1 account) {

		try (FileOutputStream fileOut = new FileOutputStream("account1.ser");
				ObjectOutputStream outStream = new ObjectOutputStream(fileOut);) {

			outStream.writeObject(account);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deserialize(Account1 account) {

		try(FileInputStream fileIn = new FileInputStream("account1.ser");
				ObjectInputStream inStream = new ObjectInputStream(fileIn);){
			
			account = (Account1) inStream.readObject();
			
			System.out.println(account.getId());
			System.out.println(account.getPassword());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class Account1 implements Externalizable {

	private int id;
	private String password;

	public Account1() {
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

	//[ZP] - deserialization
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

		id = in.readInt();
//		password = (String) in.readObject();
	}

	//[ZP] - serialization
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {

		out.writeInt(id);
		//[ZP] - why??????
		out.writeObject(password);
	}
}