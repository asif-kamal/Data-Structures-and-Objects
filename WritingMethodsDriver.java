import java.util.ArrayList;
import java.util.List;

public class WritingMethodsDriver {
    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList <Integer>();

        int n = 21;
        for (int i = 0; i <= n; i++) {
            arr1.add(i);
        }

        int max = WritingMethodsQuiz.getMax(arr1);
        System.out.println("Max value: " + max);

        System.out.println(WritingMethodsQuiz.reverse("apple"));
     
       List<String> words = new ArrayList<>();

       words.add("Hello");
       words.add("Going");
       words.add("Is the night");
       words.add("How");
       words.add("World");

       System.out.println(WritingMethodsQuiz.reverseWords(words));

    }
}
