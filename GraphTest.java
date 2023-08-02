import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;

public class GraphTest {

    public static <V, E> void bfs(Graph<V, E> g, V start) {
        Queue<V> queue = new LinkedList<>();
        ArrayList<V> visited = new ArrayList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            V currentVertex = (V) queue.poll();
            System.out.println("Visited: " + currentVertex);

            for (V neighbor : g.getNeighbors(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph<Integer, String> g = new SparseGraph<>();
        for (int i = 1; i < 7; i++) {
            g.addVertex(i);
        }

        g.addEdge("twoThree", 2, 3);
        g.addEdge("fourSix", 4, 6);
        g.addEdge("oneFive", 5, 1);
        g.addEdge("oneSeven", 1, 7);
        g.addEdge("fourSeven", 4, 7);
        bfs(g, 1);
    }
}
