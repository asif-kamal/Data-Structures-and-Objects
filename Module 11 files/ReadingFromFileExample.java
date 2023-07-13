// package index;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class ReadingFromFileExample {

	public static void main(String[] args) {

		String fileName = "pg100.txt";
		int lineNumberCount = 0;
		Map<String, Integer> map = new HashMap<>();

		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextLine()) {
				// if (scanner.nextLine() != "") {
				lineNumberCount++;
				// }
				String line = scanner.nextLine();
				// System.out.println(line + " - Line Number: " + lineNumberCount);
				String[] words = line.split("\\s+");
				for (String word : words) {
					word = word.replaceAll("[\\p{Punct}\\s]+", "");
					map.put(word, lineNumberCount);
					// System.out.println(word);
				}
			}
			scanner.close();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
		IndexTree index = new IndexTree();
		// System.out.println(list.isEmpty());
		for (Entry<String, Integer> entry : list) {
			index.add(entry.getKey(), entry.getValue());
			//System.out.println(entry.getKey() + " : " + entry.getValue());

		}

	}

}
