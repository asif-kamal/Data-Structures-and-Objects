import java.util.ArrayList;
import java.util.List;

public class ListMethodsAndStrings {

    public static <E> boolean unique(List<E> list) {

        return (list.stream().distinct().count() == list.size());
    }

    public static List<Integer> allMultiples(List<Integer> list, int myInt) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index) % myInt == 0) {
                newList.add(list.get(index));
            }
        }
        return newList;
    }

    public static List<String> allStringsOfSize(List<String> list, int length) {
        // find strings of certain characters long based on int length
        ArrayList<String> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == length) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }

    public static List<String> stringToListOfWords(String words) {
        ArrayList<String> newList = new ArrayList<>();

        String[] newList2 = words.split("[\\p{Punct}\\s]+");
        for (int i = 0; i < newList2.length; i++) {
            newList.add(newList2[i]);
        }
        return newList;
    }

}
