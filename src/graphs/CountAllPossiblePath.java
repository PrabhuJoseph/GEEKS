package graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class CountAllPossiblePath {


    int V;
    LinkedList<Integer> adj[];

    public CountAllPossiblePath(int V) {
        this.V = V;
        adj = new LinkedList[this.V];
        for (int i=0; i<V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adj[src].add(dest);
    }


    // NOTE: This won't work in Level Order Traversal (BFS) as the parent element
    // gets marked as visited won't be traversed.

    // Depth First Traversal
    public int countAllPossiblePath(int s, int d, boolean[] visited, int count) {
        visited[s] = true;

        if (s==d) {
            count++;
        } else {
            Iterator<Integer> adjS = adj[s].iterator();
            while(adjS.hasNext()) {
                Integer adj1 = adjS.next();
                if (!visited[adj1]) {
                    count = countAllPossiblePath(adj1, d, visited, count);
                }
            }
        }
        visited[s] = false;
        return count;
    }


    public static void main(String[] args) {
        CountAllPossiblePath g = new CountAllPossiblePath(8);
        boolean visited[] = new boolean[8];
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);

        g.addEdge(2,0);
        g.addEdge(2,1);

        g.addEdge(1,3);

        int count = g.countAllPossiblePath(2, 3, visited, 0);
        System.out.println("OUTPUT=" + count);

    }

}
