import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Mapping {

    // public static Map<Integer, List<Integer>> categorizeEvenOdds(List<Integer>
    // list) {
    // Map<Integer, List<Integer>> map = new HashMap<>();
    // map.put(0, new ArrayList<>());
    // map.put(1, new ArrayList<>());
    // for (Integer num : list) {
    // map.get(num % 2).add(num);
    // }
    // return map;
    // }

    // public static Map<Integer, List<String>> stringsByLength(List<String> list) {
    // Map<Integer, List<String>> wordsbySize = new HashMap<>();
    // for (String word : list) {
    // if (!wordsbySize.containsKey(word.length())) {
    // wordsbySize.put(word.length(), new ArrayList<>());
    // }
    // wordsbySize.get(word.length()).add(word);
    // }
    // return wordsbySize;
    // }

    public static HashMap<String, Integer> reduce(HashMap<String, Integer> A, HashMap<String, Integer> B) {
        HashMap<String, Integer> both = new HashMap<>();
        for (String word : A.keySet()) {
            both.put(word, A.get(word));
        }
        for (String word : B.keySet()) {
            if (both.containsKey(word)) {
                both.put(word, both.get(word) + B.get(word));
            } else {
                both.put(word, B.get(word));
            }
        }

        return both;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> A = new HashMap<>();
        HashMap<String, Integer> B = new HashMap<>();
        A.put("foo", 2);
        A.put("hello", 5);
        A.put("world", 10);

        B.put("hello", 1);
        B.put("foo", 5);
        B.put("bar", 900);

        System.out.println(reduce(A, B));
    }
}
