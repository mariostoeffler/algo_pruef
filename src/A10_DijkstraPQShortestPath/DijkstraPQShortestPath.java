package A10_DijkstraPQShortestPath;


import java.util.ArrayList;
import java.util.List;

public class DijkstraPQShortestPath extends FindWay {
    private int[] dist;

    public DijkstraPQShortestPath(Graph graph) {
        super(graph);
    }

    /**
     * Startentfernung initialisieren
     *
     * @param
     */
    protected void initPathSearch() {
        int numv = graph.numVertices();
        dist = new int[numv];
        for (int i = 0; i < numv; i++) {
            dist[i] = Integer.MAX_VALUE; // Summen im Graph dürfen nie mehr ergeben
            pred[i] = -1;
        }
    }

    /**
     * Berechnet *alle* kürzesten Wege ausgehend vom Startknoten Setzt dist[]-
     * und pred[]-Arrays, kein Rückgabewert
     *
     * @param from Startknoten
     */
    protected boolean calculatePath(int from, int to) {

        dist[from] = 0;
        VertexHeap heap = new VertexHeap(graph.numVertices());
        for (int i = 0; i < graph.numVertices(); i++) {
            heap.insert(new Vertex(i, dist[i]));
        }




        while (!heap.isEmpty()) {
            int v = heap.remove().vertex;
            List<WeightedEdge> edges = graph.getEdges(v);
            for (WeightedEdge we : edges) {
                int newCost = dist[v] + we.weight;
                int to_vertex = we.to_vertex;

                if (newCost < dist[to_vertex]) {
                    dist[to_vertex] = newCost;
                    heap.setCost(to_vertex, newCost);
                    pred[to_vertex] = v;
                }


            }

        }

        return (dist[to] != Integer.MAX_VALUE);


    }
}
