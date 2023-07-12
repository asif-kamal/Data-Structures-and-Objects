// package index;

import java.io.*;
import java.util.Scanner;

public class ReadingFromFileExample {

	public static void main(String[] args) {

		String fileName = "pg100.txt";
		int lineNumberCount = 0;

		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextLine()) {
				// if (scanner.nextLine() != "") {
				lineNumberCount++;
				// }
				String line = scanner.nextLine();
				System.out.println(line + " - Line Number: " + lineNumberCount);
				String[] words = line.split("\\s+");
				for (String word : words) {
					word = word.replaceAll("[\\p{Punct}\\s]+", "");
					System.out.println(word);
				}
			}
			scanner.close();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
