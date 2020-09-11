package graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class FindPossiblePath {

    int V;
    LinkedList<Integer> adj[];

    public FindPossiblePath(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i=0; i<V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adj[src].add(dest);
    }


    public boolean findPath(int s, int d, boolean[] visited) {

        LinkedList<Integer> queue = new LinkedList();
        queue.add(s);
        visited[s] = true;

        while (queue.size() != 0) {
            int cur = queue.poll();
            System.out.println(cur+1);

            LinkedList list = adj[cur];
            Iterator<Integer> itr = list.listIterator();
            while (itr.hasNext()) {
                int n = itr.next();
                if (n==d) {
                    System.out.println(n+1);
                    return true;
                }
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        FindPossiblePath g = new FindPossiblePath(8);
        boolean visited[] = new boolean[8];
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,4);
        g.addEdge(0,7);
        g.addEdge(0,6);

        g.addEdge(1,0);
        g.addEdge(1,2);

        g.addEdge(2,0);
        g.addEdge(2,1);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(2,6);

        g.addEdge(3,2);
        g.addEdge(3,4);

        g.addEdge(4,0);
        g.addEdge(4,2);
        g.addEdge(4,3);
        g.addEdge(4,5);
        g.addEdge(4,6);

        g.addEdge(5,4);
        g.addEdge(5,6);

        g.addEdge(6,0);
        g.addEdge(6,2);
        g.addEdge(6,5);
        g.addEdge(6,4);
        g.addEdge(6,7);

        g.addEdge(7,0);
        g.addEdge(7,6);

        g.findPath(0, 7, visited);

    }

}
