package sorting;

import java.util.LinkedHashMap;

import java.util.Map;

// https://www.geeksforgeeks.org/pigeonhole-sort/
// https://www.youtube.com/watch?v=NVgK588uJKg

public class PigeonHoleSorting {

  public void sort(int[] arr) {
    // Find Min and Max
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int x : arr) {
      min = Math.min(min, x);
      max = Math.max(max, x);
    }

    LinkedHashMap<Integer, Integer> occurrences = new LinkedHashMap<>();
    for (int i=min; i<=max; i++) {
      occurrences.put(i, 0);
    }

    for (int x : arr) {
      occurrences.put(x, occurrences.get(x)+1);
    }

    for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
      for (int i=0; i<entry.getValue(); i++) {
        System.out.print(entry.getKey() + "\t");
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 4, 3, 2, 5, 6, 2};
    PigeonHoleSorting sort = new PigeonHoleSorting();
    sort.sort(arr);
  }
}
