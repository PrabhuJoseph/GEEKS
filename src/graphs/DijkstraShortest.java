package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class DijkstraShortest {


    static class Graph {
        int V;
        LinkedList<Integer>[] adj;
        public Graph(int V) {
            this.V = V;
            adj = new LinkedList[V];
            for (int i=0; i<V; i++) {
                adj[i] = new LinkedList<>();
            }
        }
        public void addEdge(int S, int D) {
            adj[S].add(D);
        }
    }

    public int findMin(boolean[] visibility, HashMap<Integer, Integer> distances) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            if (!visibility[entry.getKey()]) {
                if (entry.getValue() <= min) {
                    min = entry.getValue();
                    min_index = entry.getKey();
                }
            }
        }
        return min_index;
    }

    public void findShortestPath(int n, Graph g, boolean[] visibility, HashMap<Integer, Integer> distances) {
        distances.put(n, 0);

        for (int i=0; i< g.V; i++) {
            int min = findMin(visibility, distances);
            if (min != -1) {
                visibility[min] = true;
                for (int j : g.adj[min]) {
                    if (!visibility[j]) {
                        if (distances.get(min)!= Integer.MAX_VALUE && distances.get(j) > distances.get(min) + 1) {
                            distances.put(j, distances.get(min) + 1);
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int V = 5;
        Graph g = new Graph(V);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(0, 4);

        DijkstraShortest d = new DijkstraShortest();
        boolean[] visibility = new boolean[V];
        HashMap<Integer, Integer> distances = new HashMap<>();
        distances.put(0, Integer.MAX_VALUE);
        distances.put(1, Integer.MAX_VALUE);
        distances.put(2, Integer.MAX_VALUE);
        distances.put(3, Integer.MAX_VALUE);
        distances.put(4, Integer.MAX_VALUE);


        int S = 0;
        d.findShortestPath(S, g, visibility, distances);

        for (int i=0; i<V; i++) {
            System.out.println("DISTANCES BETWEEN " + S + " And " + i + " is : " + distances.get(i));
        }
    }
}
