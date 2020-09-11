package graphs;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinimumNumberOfMoves {

  static class Graph {
    int V;
    LinkedList<Integer>[] adj;

    public Graph(int V) {
      adj = new LinkedList[V];
      for (int i=0; i<V; i++) {
        adj[i] = new LinkedList<>();
      }
    }

    public void addEdge(int x, int y) {
      adj[x].add(y);
    }

    public int findMin(HashMap<Integer, Integer> distances, boolean[] visited) {
      Set<Integer> nodes = distances.keySet();
      int min = Integer.MAX_VALUE;
      int minIndex = -1;
      for (int node : nodes) {
        if (!visited[node]) {
          if (min > distances.get(node)) {
            min = distances.get(node);
            minIndex = node;
          }
        }
      }
      return minIndex;
    }

    public int findShortestPath(int s, int d, boolean[] visited, HashMap<Integer, Integer> distances) {
      distances.put(s, 0);
      for (int i=0; i< adj.length; i++) {
        int minIndex = findMin(distances, visited);
        if (minIndex != -1) {
          visited[minIndex] = true;
          for (int adj : adj[minIndex]) {
            if (!visited[adj]) {
              if (distances.get(minIndex) != Integer.MAX_VALUE && distances.get(adj) > 1 + distances.get(minIndex)) {
                  distances.put(adj, 1 + distances.get(minIndex));
              }
            }
          }
        }
      }
      return distances.get(d);
    }
  }



  public static void main(String[] args) {
    HashMap<Integer, LinkedList<Integer>> location = new HashMap<>();
    LinkedList<Integer> nodesWithMoreEdges = new LinkedList<>();
    int[] arr = {1,2,3,4,2,5};
    Graph g = new Graph(arr.length);
    for (int i=0; i<arr.length-1; i++) {
      g.addEdge(i, i+1);
      if (location.containsKey(arr[i])) {
        location.get(arr[i]).add(i);
        nodesWithMoreEdges.add(arr[i]);
      } else {
        LinkedList<Integer> listIndex = new LinkedList<>();
        listIndex.add(i);
        location.put(arr[i], listIndex);
      }
    }

    for (int node : nodesWithMoreEdges) {
      LinkedList list = location.get(node);
      Integer[] adjs = new Integer[list.size()];
      list.toArray(adjs);
      for (int i=0; i<adjs.length; i++) {
        for (int j=i+1; j<adjs.length; j++) {
          g.addEdge(adjs[i], adjs[j]);
        }
      }
    }

    boolean[] visited = new boolean[arr.length];
    HashMap<Integer, Integer> distances = new HashMap<>();
    for (int i=0; i<arr.length; i++) {
        distances.put(i, Integer.MAX_VALUE);
    }
    int minimumMove = g.findShortestPath(0, arr.length-1, visited, distances);
    System.out.println("MINIMUM MOVE="+minimumMove);
  }
}
