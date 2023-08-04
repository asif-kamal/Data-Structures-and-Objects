import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class GraphTestTwo {

    public static <V, E> void dfs(Graph<V, E> g, V start, BasicVisualizationServer<Integer, String> vv) {
        Set<V> visited = new HashSet<>();
        Stack<V> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            V currentVertex = stack.pop();
            if (!visited.contains(currentVertex)) {
                visited.add(currentVertex);
                System.out.println("Visited: " + currentVertex);
                vv.getPickedVertexState().pick((Integer) currentVertex, true);
                vv.repaint();

                try {
                    Thread.sleep(1000); // Pause for visualization
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (V neighbor : g.getNeighbors(currentVertex)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                        vv.getPickedEdgeState().pick((String) g.findEdge(currentVertex, neighbor), true);
                        vv.repaint();

                        try {
                            Thread.sleep(1000); // Pause for visualization
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph<Integer, String> g = new SparseGraph<>();
        // for (int i = 1; i < 7; i++) {
        //     g.addVertex(i);
        // }

        // g.addEdge("twoSix", 2, 6);
        // g.addEdge("fiveTwo", 5, 2);
        // g.addEdge("fiveOne", 5, 1);
        // g.addEdge("oneThree", 1, 3);
        // g.addEdge("fourThree", 4, 3);
        // g.addEdge("threeTwo", 3, 2);

        g.addEdge("a", 0, 1);
        g.addEdge("b", 0, 2);
        g.addEdge("c", 1, 2);
        g.addEdge("d", 2, 0);
        g.addEdge("e", 2, 3);
        g.addEdge("f", 3, 3);

        // g.addEdge("Edge_A", 0, 1);
        // g.addEdge("Edge_B", 0, 3);
        // g.addEdge("Edge_c", 0, 4);
        // g.addEdge("Edge_D", 3, 4);
        // g.addEdge("Edge_E", 1, 3);
        // g.addEdge("Edge_F", 1, 4);
        // g.addEdge("Edge_G", 0, 2);
        // g.addEdge("Edge_H", 2, 6);
        // g.addEdge("Edge_g", 2, 5);
        // g.addEdge("Edge_l", 5, 6);

        FRLayout<Integer, String> layout = new FRLayout<Integer, String>(g);
        BasicVisualizationServer<Integer, String> vv = new BasicVisualizationServer<>(layout);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<>());

        JFrame frame = new JFrame("DFS Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setVisible(true);

        // Perform DFS traversal
        dfs(g, 2, vv);
    }
}
