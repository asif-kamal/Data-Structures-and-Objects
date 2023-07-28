import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.List;

public class CheatersHangman {
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
        ArrayList<String> guessLetterShownArrList = new ArrayList<>();

        for (String word : wordList) {
            for (char character : word.toCharArray()) {
                for (char letter : guesses) {
                    if (letter == character) {

                        String regex = "[^" + escapeSpecialCharacter(letter) + "]";
                        String underscored = word.replaceAll(regex, "_");
                        // guessLetterShownArrList.add(underscored);
                        // System.out.println(guessLetterShownArrList);

                        if (!wordFamilies.containsKey(underscored)) {
                            wordFamilies.put(underscored, new ArrayList<>());
                        }
                        wordFamilies.get(underscored).add(word);

                    }
                }
            }
        }
        System.out.println(wordFamilies);
        return wordFamilies;
        // create new map
    }

    private static String escapeSpecialCharacter(char character) {
        // Check if the character is a special character in regex and escape it if
        // needed
        if ("\\[](){}.*+?|^$".indexOf(character) != -1) {
            return "\\" + character;
        }
        return String.valueOf(character);
    }

    public static List<String> chooseNewWordList(Map<String, List<String>> families) {
        return null;

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
        int wrongGuesses = scanner.nextInt();

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
