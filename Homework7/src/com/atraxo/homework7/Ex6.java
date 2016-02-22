package com.atraxo.homework7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//[ZP] - 10
public class Ex6 {

	public static void main(String[] args) {

		Ex6 ex = new Ex6();
		Path file = Paths.get("ShortFile.txt");
		ex.write(ex.reverse(ex.read(file)));
	}

	public List<String> read(Path file) {

		try {
			List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
			List<String> words = new ArrayList<>();
			for (String line : lines)
				words.addAll(Arrays.asList(line.split(" ")));

			return words;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> reverse(List<String> words) {

		List<String> reverseWords = new ArrayList<>();
		for (String word : words) {
			String reverse = new String();
			if (word.length() != 1) {
				if (word.endsWith(".")) {
					String l = word.substring(0, word.lastIndexOf("."));
					reverse = new StringBuilder(l).reverse().toString();
					reverse = reverse + ".";
				} else {
					reverse = new StringBuilder(word).reverse().toString();
				}
				reverseWords.add(reverse);
			} else {
				reverseWords.add(word);
			}
		}
		return reverseWords;
	}
	
	public void write(List<String> words) {
		try(BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("ShortFile_rev.txt"), StandardCharsets.UTF_8);) {
			for(String word :  words){
				word = word + " ";
				bufferedWriter.write(word);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
