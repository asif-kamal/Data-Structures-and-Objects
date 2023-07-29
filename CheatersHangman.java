import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.List;

public class CheatersHangman {

    private static int guessesLeft = 0;
    private static Set<Character> guesses = new HashSet<>();

    public static Map<Integer, List<String>> generateInitialWordLists() throws IOException {
        // open dictionary file
        // read in all the words
        // split them up into seperate lists based on their size
        // return the map
        String line;
        Map<Integer, List<String>> wordsbySize = new HashMap<>();

        InputStream fis = new FileInputStream("dictionary.txt");
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr);
        {
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (!wordsbySize.containsKey(word.length())) {
                        wordsbySize.put(word.length(), new ArrayList<>());
                    }
                    wordsbySize.get(word.length()).add(word);
                }
            }

            fis.close();
        }
        return wordsbySize;
    }

    /*
     * guesses e t
     * wordList [tail, soot, rook, torn, tips]
     * t___, ___t
     * 
     * { t___: [tail,torn,tips]
     * ___t: [soot]
     * ____: [rook]
     * }
     * 
     * 
     */

    public static Map<String, List<String>> generateWordFamilies(Set<Character> guesses, List<String> wordList) {
        Map<String, List<String>> wordFamilies = new HashMap<>();

        for (String word : wordList) {
            StringBuilder underscored = new StringBuilder();

            for (char character : word.toLowerCase().toCharArray()) {
                if (guesses.contains(character)) {
                    underscored.append(character);
                } else {
                    underscored.append('_');
                }
            }

            String underscoredWord = underscored.toString();
            if (!wordFamilies.containsKey(underscoredWord)) {
                wordFamilies.put(underscoredWord, new ArrayList<>());
            }
            wordFamilies.get(underscoredWord).add(word);
        }
        for (char letter : guesses) {
            System.out.println();
            System.out.print(letter + " " + (guessesLeft - 1) + " ");
        }
        // System.out.println(wordFamilies);
        chooseNewWordList(wordFamilies);
        return wordFamilies;
        // create new map
    }

    public static List<String> chooseNewWordList(Map<String, List<String>> families) {
        List<String> maxFamily = new ArrayList<>();

        String maxKey = families.entrySet().stream()
                .max(Comparator.comparingInt(entry -> entry.getValue().size()))
                .get().getKey();

        for (Map.Entry<String, List<String>> family : families.entrySet()) {
            if (maxKey == family.getKey()) {
                maxFamily = family.getValue();
                System.out.println(family.getKey());
            }
        }
        // System.out.println(maxFamily);
        return maxFamily;

    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        Map<Integer, List<String>> dictionary = new HashMap<>();
        dictionary = generateInitialWordLists();

        Set<Character> guesses = new HashSet<>();

        System.out.println("Enter word length: ");
        int wordLength = scanner.nextInt();

        while (!dictionary.containsKey(wordLength)) {
            System.out.println("Enter word length: ");
            wordLength = scanner.nextInt();
        }

        System.out.println("Enter how many guesses you would like for this round: ");
        guessesLeft = scanner.nextInt();

        System.out.println("Enter letter(s) you would like to guess: ");
        char letterGuessed = scanner.next().charAt(0);
        guesses.add(letterGuessed);

        for (Map.Entry<Integer, List<String>> entry : dictionary.entrySet()) {
            if (wordLength == entry.getKey()) {
                generateWordFamilies(guesses, entry.getValue());
            }
        }

        scanner.close();
    }
}
