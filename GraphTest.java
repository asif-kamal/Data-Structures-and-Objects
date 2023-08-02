import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class GraphTest {

    public static <V, E> void bfs(Graph<V, E> g, V start, BasicVisualizationServer<Integer, String> vv) {
        Queue<V> queue = new LinkedList<>();
        ArrayList<V> visited = new ArrayList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            V currentVertex = (V) queue.poll();
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
                    queue.add(neighbor);
                    visited.add(neighbor);
                    vv.getPickedVertexState().pick((Integer) neighbor, true);
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

    public static void main(String[] args) {
        Graph<Integer, String> g = new SparseGraph<>();
        for (int i = 1; i < 7; i++) {
            g.addVertex(i);
        }

        g.addEdge("twoSix", 2, 6);
        g.addEdge("fiveTwo", 5, 2);
        g.addEdge("fiveOne", 5, 1);
        g.addEdge("oneThree", 1, 3);
        g.addEdge("fourThree", 4, 3);
        g.addEdge("threeTwo", 3, 2);

        FRLayout<Integer, String> layout = new FRLayout<Integer, String>(g);
        BasicVisualizationServer<Integer, String> vv = new BasicVisualizationServer<>(layout);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<>());

        JFrame frame = new JFrame("BFS Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setVisible(true);

        // Perform BFS traversal
        bfs(g, 1, vv);
    }
}
