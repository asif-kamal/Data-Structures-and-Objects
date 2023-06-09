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

}
