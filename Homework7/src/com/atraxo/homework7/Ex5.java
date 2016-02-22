package com.atraxo.homework7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
//[ZP] - 10
public class Ex5 {

	public static void main(String[] args) {

		Ex5 ex = new Ex5();
		File file = new File("File.txt");
		File zipFile = ex.compress(file);
		System.out.println("compression ratio: " + ((double)file.length() / (double)zipFile.length()));
	}

	public File compress(File file) {

		File zipFile = new File("MyFile.zip");
		byte[] buffer = new byte[10240];
		try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
				FileInputStream in = new FileInputStream(file);) {
			
			ZipEntry zip = new ZipEntry(file.getName());
			zos.putNextEntry(zip);

			int lenght = 0;
			while ((lenght = in.read(buffer)) > 0) {
				zos.write(buffer, 0, lenght);
			}

			return zipFile;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
