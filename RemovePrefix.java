import java.util.ArrayList;
import java.util.List;

public class RemovePrefix {

    public static void removePrefixStrings(List<String> list, String prefix) {
        for (int i = list.size() - 1; i >= 0; i--) {
            String word = list.get(i);
            if (word.startsWith(prefix)) {
                list.remove(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of(
                "Hi", "how", "are", "you", "today", "fine", "thanks", "horses", "are", "doing", "fantastic", "my",
                "hoe", "is", "stuck", "in", "the", "mud", "hoping", "someone", "can", "help"));

        removePrefixStrings(list, "ho");
    }
}
