import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static <E> boolean isPermutation(List<E> A, List<E> B) {

        if (A.size() != B.size()) {
            return false;
        }

        for (E item : A) {
            int countA = 0, countB = 0;

            for (int i = 0; i < A.size(); i++) {
                if (item.equals(A.get(i))) {
                    countA++;
                }
            }

            for (int j = 0; j < B.size(); j++) {
                if (item.equals(B.get(j))) {
                    countB++;
                }

            }
            if (countA != countB) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 555, 9327, 733, 80, 624, 23, 7));
        ArrayList<Integer> newList = new ArrayList<>(List.of(1, 9327, 733, 555, 7, 80, 23, 624));

        System.out.println(isPermutation(list, newList));
    }
}
