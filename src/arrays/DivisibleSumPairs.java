package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// Pairs of Songs: https://www.youtube.com/watch?v=toYgBIaUdfM

public class DivisibleSumPairs {

  static class Pair {
      int x;
      int y;

      Pair(int x, int y) {
          this.x = x;
          this.y = y;
      }
  }

  // O(n2)
  private static int getPairsUsingNaiveSolution(int[] arr, int k) {
      List<Pair> pairs = new ArrayList<>();
      for (int i=0; i<arr.length; i++) {
          for (int j=i+1; j<arr.length; j++) {
              int sum = arr[i] + arr[j];
              if (sum % k == 0) {
                  pairs.add(new Pair(i+1,j+1));
              }
          }
      }
      return pairs.size();
  }

    // O(n2)
  private static int getPairsUsingEfficientSolution(int[] arr, int k) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int x : arr) {
        int mod = x % k;
        if (map.containsKey(mod)) {
          map.put(mod, map.get(mod) + 1);
        } else {
          map.put(mod, 1);
        }
      }
      int totalPairs = 0;
      // Handle Special Cases
      int zeros = map.getOrDefault(0, 0);
      map.remove(0);
      if (zeros > 1) {
        totalPairs += zeros * (zeros - 1) / 2;
      }
      if (k % 2 == 0) {
        int half = map.getOrDefault(k/2, 0);
        map.remove(k/2);
        if (half > 1) {
          totalPairs += half * (half - 1) / 2;
        }
      }
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int pair = Math.abs(entry.getKey() - k);
        if (map.containsKey(pair)) {
          int pairCount = map.get(pair);
          totalPairs += (pairCount * entry.getValue());
          map.put(pair, 0);
          map.put(entry.getKey(), 0);
        }
      }
      return totalPairs;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1,2,3,4,5,6};
    int k = 5;
    System.out.println("Naive Solution O(n2) :" + getPairsUsingNaiveSolution(arr, k));
    System.out.println("Efficient Solution O(n) :" + getPairsUsingEfficientSolution(arr, k));
  }
}


