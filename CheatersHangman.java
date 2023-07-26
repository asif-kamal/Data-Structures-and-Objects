import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
                    // Do your thing with line
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

    public static void main(String[] args) throws IOException {
        System.out.println(generateInitialWordLists());
    }

    public static Map<String, List<String>> generateWordFamilies(Set<Character> guesses, List<String> wordList) {
        return null;
        // create new map
    }

    public static List<String> chooseNewWordList(Map<String, List<String>> families) {
        return null;

    }
}
