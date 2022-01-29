package dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;

public class PrintAllLongestIncreasingSubsequence {

    // https://www.techiedelight.com/longest-increasing-subsequence-using-dynamic-programming/

    private static void findLIS(int[] arr, int start, int n, int prev, int[] seq, int k) {
        if (start == n) {
          for (int x=0; x<k; x++) {
            System.out.print(seq[x] + "\t");
          }
          System.out.println();
          return;
        }

        if (arr[start] > prev) {
           seq[k] = arr[start];
          findLIS(arr, start+1, n, arr[start], seq, k+1);
        }
        findLIS(arr, start+1, n, prev, seq, k);
    }

    private static void findLISwithDistinctColors(int[] arr, int start, int n, int prev, int[] seq,
        int k, int[] colors, boolean[] visited) {
        if (start == n) {
            for (int x=0; x<k; x++) {
                System.out.print(seq[x] + "\t");
            }
            System.out.println();
            return;
        }

        if (arr[start] > prev && !visited[colors[start]-1]) {
            seq[k] = arr[start];
            visited[colors[start]-1] = true;
            findLISwithDistinctColors(arr, start+1, n, arr[start], seq, k+1, colors, visited);
        }
        findLISwithDistinctColors(arr, start+1, n, prev, seq, k, colors, visited);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 6, 3, 5};
        int[] colors = new int[]{1, 2, 3, 3};

        findLIS(arr, 0, arr.length, Integer.MIN_VALUE, new int[arr.length], 0);
    }
}
