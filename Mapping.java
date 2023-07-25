import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;

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

    public static Map<Integer, Integer> countNums(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : list) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return map;
    }

    public static boolean isPermutation(String a, String b) {

        Map<Character, Integer> aCount = new HashMap<>();
        Map<Character, Integer> bCount = new HashMap<>();
        for (char letter : a.toCharArray()) {
            if (aCount.containsKey(letter)) {
                aCount.put(letter, aCount.get(letter) + 1);
            } else {
                aCount.put(letter, 1);
            }
        }
        for (char letter : b.toCharArray()) {
            if (bCount.containsKey(letter)) {
                bCount.put(letter, bCount.get(letter) + 1);
            } else {
                bCount.put(letter, 1);
            }
        }
        for (char letter : aCount.keySet()) {
            if (aCount.get(letter) != bCount.get(letter)) {
                return false;
            }
            if (!aCount.keySet().equals(bCount.keySet())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // HashMap<String, Integer> A = new HashMap<>();
        // HashMap<String, Integer> B = new HashMap<>();
        // A.put("foo", 2);
        // A.put("hello", 5);
        // A.put("world", 10);

        // B.put("hello", 1);
        // B.put("foo", 5);
        // B.put("bar", 900);

        // System.out.println(reduce(A, B));

        // List<Integer> list = new ArrayList<Integer>(List.of(9, 1, 1, 1, 3, 1, 2, 1, 9));
        // System.out.println(countNums(list));

        String a = "palindrome";
        String b = "emordnilap";
        System.out.println(isPermuation(a, b));
    }
}
