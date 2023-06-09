import java.util.ArrayList;
import java.util.List;

public class ListMethodsAndStringsDriver {

    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();

        myList.add("AfaA");
        myList.add("AbaA");
        myList.add("ApaA");
        myList.add("AajA");
        myList.add("AdaA");


        System.out.println(ListMethodsAndStrings.unique(myList));

        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(2);
        newList.add(100);
        newList.add(33);
        newList.add(25);
        newList.add(39);
        newList.add(12);
        newList.add(300);
        newList.add(2278);

        System.out.println(ListMethodsAndStrings.allMultiples(newList, 2));
    }

    


}