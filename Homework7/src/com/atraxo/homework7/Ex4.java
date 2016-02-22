package com.atraxo.homework7;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

//[ZP] - 10
public class Ex4 {

	public static void main(String[] args) {

		Ex4 ex = new Ex4();
		try (RandomAccessFile file = new RandomAccessFile(new File("IntegersFile.txt"), "rw");) {

			ex.writeRandomAccess(file);
			ex.readRandomAccess(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeRandomAccess(RandomAccessFile file) throws IOException {
		for (int i = 1; i <= 4; i++) {
			String line = String.valueOf(i) + "\n";
			file.write(line.getBytes());
		}
	}

	public void readRandomAccess(RandomAccessFile file) throws IOException {

		// ----------------------------------------
		// | file pointer | 0  1 2  3 4  5 6  7 8 |
		// | value        | 1 \n 2 \n 3 \n 4 \n   |
		// ----------------------------------------
		
		file.seek(4);
		while(file.getFilePointer() != file.length()) {
			int character = file.read() - '0';
			if(character != -38)
				System.out.println(character);
		}
	}
}
