
import java.util.ArrayList;
import java.util.List;

public class WritingMethodsQuiz {
    
    public static int getMax(List <Integer> list){
        int max = list.get(0);
        for (int index = 0; index < list.size(); index++) {
            if(list.get(index) > max) {
                max = list.get(index);
                
            }
        }
        return max;
    }

    public static String reverse(String word) {
        String reversed = "";
        for (int i = 0; i < word.length(); i++) {
            reversed += ((word.charAt(word.length() - (1+i))));
        }
        return reversed;
    }

    public static List<String> reverseWords(List<String>words) {
        List <String> output = new ArrayList<String>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            word = reverse(word);
            output.add(word);
        }
        return output;
    }

    
}
