package com.atraxo.homework7;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
//[ZP] - 0
public class Ex1 {

	public static void main(String[] args) {

		Path filePath = Paths.get("File.txt");
		
		if (Files.exists(filePath)) {

			try {
				//[ZP] - this read all lines from the file. The requirement was to read one line at a time.	
				List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);

				for (String line : lines) {

					System.out.println(line);
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
