import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class DFS {
    public static <V, E> void dfsMethod(Graph<V, E> g, V start) {
        Set<V> visited = new HashSet<>();
        dfsRecursive(g, start, visited);
    }

    private static <V, E> void dfsRecursive(Graph<V, E> graph, V currentNode, Set<V> visited) {
        visited.add(currentNode);
        System.out.print(currentNode + " ");
        for (E edge : graph.getOutEdges(currentNode)) {
            V neighbor = graph.getOpposite(currentNode, edge);
            if (!visited.contains(neighbor)) {
                dfsRecursive(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph<Integer, String> g = new SparseGraph<>();
        g.addEdge("Edge_A", 0, 1);
        g.addEdge("Edge_B", 0, 3);
        g.addEdge("Edge_c", 0, 4);
        g.addEdge("Edge_D", 3, 4);
        g.addEdge("Edge_E", 1, 3);
        g.addEdge("Edge_F", 1, 4);
        g.addEdge("Edge_G", 0, 2);
        g.addEdge("Edge_H", 2, 6);
        g.addEdge("Edge_g", 2, 5);
        g.addEdge("Edge_l", 5, 6);

        FRLayout<Integer, String> layout = new FRLayout<>(g);
        BasicVisualizationServer<Integer, String> vv = new BasicVisualizationServer<>(layout);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<>());

        JFrame frame = new JFrame("DFS Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setVisible(true);

        // Perform DFS traversal
        dfsMethod(g, 0);
    }
}
