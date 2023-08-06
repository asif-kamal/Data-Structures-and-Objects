import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;

public class SecurityGraph {

    public static void main(String[] args) throws FileNotFoundException {
        Graph<Integer, String> g = new DirectedSparseGraph<Integer, String>();
        ArrayList<Integer> resultDigits = new ArrayList<Integer>();

        try {
            Scanner scanner = new Scanner(new File("p079_keylog.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int a = Character.getNumericValue(line.charAt(0));
                int b = Character.getNumericValue(line.charAt(1));
                int c = Character.getNumericValue(line.charAt(2)); // must convert char to int, otherwise you will get
                                                                   // ascii values

                g.addEdge(a + "" + b, a, b);
                g.addEdge(b + "" + c, b, c);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (g.getEdgeCount() != 1) {
            for (int v : g.getVertices()) {
                if (g.inDegree(v) == 0) {
                    resultDigits.add(v);
                    break;
                }
            }
            g.removeVertex(resultDigits.get(resultDigits.size() - 1));
        }

        String lastEdgeLabel = g.getEdges().toArray()[0].toString();
        for (char digitChar : lastEdgeLabel.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            resultDigits.add(digit);
        }

        // g.addEdge("52", 5, 2);
        // g.addEdge("50", 5, 0);
        // g.addEdge("40", 4, 0);
        // g.addEdge("41", 4, 1);
        // g.addEdge("23", 2, 3);
        // g.addEdge("31", 3, 1);

        System.out.println("Topological Sorting:");

        for (int i = 0; i < resultDigits.size(); i++) {
            System.out.print(resultDigits.get(i));
        }
        System.out.println();

    }
}
