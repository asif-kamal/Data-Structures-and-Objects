import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;

public class GraphTest {
    public static void main(String[] args) {
        Graph<Integer, String> g = new SparseGraph<>();
        g.addEdge("twoThree", 2, 3);
        g.addEdge("lazy", 4, 6);
        System.out.println(g);
    }
}
