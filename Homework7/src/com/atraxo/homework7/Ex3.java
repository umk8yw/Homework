package com.atraxo.homework7;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//[ZP] - 10
public class Ex3 {

	public static void main(String[] args) throws IOException {

		Ex3 ex = new Ex3();
		List<String> lines = new ArrayList<>();
		Path file = Paths.get("File.txt");

		if (Files.exists(file))
			lines = ex.read(file);

		long startTime = System.nanoTime();
		ex.writeOS(lines);
		long stopTime = System.nanoTime();
		System.out.println("unbuffered OutputStream: " + (stopTime - startTime));

		startTime = System.nanoTime();
		ex.writeBufferedOS(lines);
		stopTime = System.nanoTime();
		System.out.println("buffered OutputStream: " + (stopTime - startTime));	
		
		startTime = System.nanoTime();
		ex.writeWritter(lines);
		stopTime = System.nanoTime();
		System.out.println("unbuffered Writer: " + (stopTime - startTime));	
		
		startTime = System.nanoTime();
		ex.writeBufferedWriter(lines);
		stopTime = System.nanoTime();
		System.out.println("buffered Writer: " + (stopTime - startTime));	
	}

	public void writeWritter(List<String> data) {

		try (Writer writer = new OutputStreamWriter(new FileOutputStream("file1.txt"));) {
			for (String line : data)
				writer.write(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeBufferedWriter(List<String> data) {

		try (Writer writer = new BufferedWriter(new FileWriter("file2.txt"))) {
			for (String line : data)
				writer.write(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeOS(List<String> data) {

		try (FileOutputStream out = new FileOutputStream(new File("file3.txt"))) {
			for (String line : data) {
				byte[] bytes = line.getBytes();
				out.write(bytes);
			}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeBufferedOS(List<String> data) {

		try (BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("file4.txt"));) {
			for (String line : data) {
				byte[] bytes = line.getBytes();
				bout.write(bytes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> read(Path file) throws IOException {

		return Files.readAllLines(file, StandardCharsets.UTF_8);
	}
}
