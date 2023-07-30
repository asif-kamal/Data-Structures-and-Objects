import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.List;

public class CheatersHangman {

    private static int guessesLeft = 0;
    private static int wordLength = 0;
    private static String maxFamilyKey;
    private static String underscoredWord;
    private static Set<Character> guesses = new HashSet<>();
    private static List<String> maxFamily = new ArrayList<>();
    private static Map<Integer, List<String>> dictionary = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

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

    public static Map<String, List<String>> generateWordFamilies(Set<Character> guesses, List<String> wordList)
            throws IOException {
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

            underscoredWord = underscored.toString();
            // System.out.println(underscoredWord);
            if (!wordFamilies.containsKey(underscoredWord)) {
                wordFamilies.put(underscoredWord, new ArrayList<>());
            }
            wordFamilies.get(underscoredWord).add(word);

        }
        // System.out.println(wordFamilies);
        chooseNewWordList(wordFamilies);
        return wordFamilies;
        // create new map
    }

    public static List<String> chooseNewWordList(Map<String, List<String>> families) throws IOException {
        // List<String> maxFamily = new ArrayList<>();

        String maxKey = families.entrySet().stream()
                .max(Comparator.comparingInt(entry -> entry.getValue().size()))
                .get().getKey();

        for (Map.Entry<String, List<String>> family : families.entrySet()) {
            if (maxKey == family.getKey()) {
                maxFamily = family.getValue();
                maxFamilyKey = family.getKey();
                System.out.println(family.getKey());
            }
        }
        // System.out.println(maxFamily.get(0));
        return maxFamily;

    }

    public static void playHangman() throws IOException {

        Scanner scanner = new Scanner(System.in);
        Set<Character> guesses = new HashSet<>();

        dictionary = generateInitialWordLists();
        System.out.println();
        System.out.println("Enter word length: ");
        wordLength = scanner.nextInt();

        while (!dictionary.containsKey(wordLength)) {
            System.out.println("Enter word length: ");
            wordLength = scanner.nextInt();
        }

        System.out.println("Enter how many guesses you would like for this round: ");
        guessesLeft = scanner.nextInt();

        for (Map.Entry<Integer, List<String>> entry : dictionary.entrySet()) {
            if (wordLength == entry.getKey()) {
                generateWordFamilies(guesses, entry.getValue());
            }
        }

        while (guessesLeft > 0 && guesses != null) {
            System.out.println("Enter letter(s) you would like to guess: ");
            String letterGuessed = scanner.next();
            // for (int i = 0; i < lettersGuessed.length(); i++) {
            guesses.add(letterGuessed.charAt(0));
            guessesLeft--;
            System.out.println();
            System.out.println(guesses + " " + guessesLeft);
            System.out.println();
            // }
            generateWordFamilies(guesses, maxFamily);

            if (underscoredWord == maxFamilyKey.toString().toLowerCase() && guessesLeft >= 0 && guesses != null) {

                if (!(underscoredWord.contains("_"))) {
                    System.out.println();
                    System.out.println("You are a winner!");
                    System.out.println("Play again? y/n");
                    scanner.nextLine();
                    String yesNo = scanner.nextLine();
                    System.out.println();
                    if (yesNo != null && yesNo.charAt(0) == 'n') {
                        System.out.println("Thanks for playing!");
                        guessesLeft = 0;
                        scanner.close();
                        return;
                    } else if (yesNo != null && yesNo.charAt(0) == 'y') {
                        playHangman();
                    } else {
                        guessesLeft = 0;
                        scanner.close();
                        return;
                    }

                }

            } else if (underscoredWord != maxFamilyKey.toString().toLowerCase() && guessesLeft == 0
                    && guesses != null) {

                if (underscoredWord.contains("_")) {
                    System.out.println();
                    System.out.println("Word was " + maxFamily.get(0));
                    System.out.println("Sorry, you lose. Try again? y/n");
                    scanner.nextLine();
                    String yesNo = scanner.nextLine();
                    if (yesNo != null && yesNo.charAt(0) == 'n') {
                        System.out.println("Thanks for playing!");
                        guessesLeft = 0;
                        scanner.close();
                        return;
                    } else if (yesNo != null && yesNo.charAt(0) == 'y') {
                        playHangman();
                    } else {
                        guessesLeft = 0;
                        scanner.close();
                        return;
                    }

                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) throws IOException {
        playHangman();
    }
}