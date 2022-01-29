package graphs;

// Java implementation of the approach
import java.util.*;

public class MaxCliqueUsingRecurison {

    static int MAX = 100, n;
    static int []store = new int[MAX];
    static int [][]graph = new int[MAX][MAX];
    static int []d = new int[MAX];

    static boolean is_clique(int b) {
        System.out.println("Size: " + b);
        for (int i=1; i<b; i++) {
          System.out.print(store[i] + "\t");
        }
        System.out.println();

        for (int i = 1; i < b; i++) {
            for (int j = i + 1; j < b; j++)
                if (graph[store[i]][store[j]] == 0)
                    return false;
        }
        return true;
    }

    static int maxCliques(int i, int l) {
        int max_ = 0;
        for (int j = i + 1; j <= n; j++) {
            store[l] = j;
            if (is_clique(l + 1)) {
                max_ = Math.max(max_, l);
                max_ = Math.max(max_, maxCliques(j, l + 1));
            }
        }
        return max_;
    }

    // Driver code
    public static void main(String[] args)
    {
        int [][]edges = { { 1, 2 }, { 2, 3 }, { 3, 1 },
                { 4, 3 }, { 4, 1 }, { 4, 2 } };
        int size = edges.length;
        n = 4;

        for (int i = 0; i < size; i++) {
            graph[edges[i][0]][edges[i][1]] = 1;
            graph[edges[i][1]][edges[i][0]] = 1;
            d[edges[i][0]]++;
            d[edges[i][1]]++;
        }
        System.out.print(maxCliques(0, 1));
    }
}

// This code is contributed by 29AjayKumar
