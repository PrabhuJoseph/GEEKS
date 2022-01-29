package arrays.deeper;

// https://www.youtube.com/watch?v=EYFcQRwcqk0

import java.util.*;

public class KMostFrequentElements {

  public static void printKMostFrequentElements(int[] input, int K) {
    // Occurrences of each number
    HashMap<Integer, Integer> occurrences = new HashMap<>();
    for (int x : input) {
      if (occurrences.containsKey(x)) {
        occurrences.put(x, occurrences.get(x) + 1);
      } else {
        occurrences.put(x, 1);
      }
    }

    HashMap<Integer, List<Integer>> revOccurrences = new HashMap<>();
    for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
      if (revOccurrences.containsKey(entry.getValue())) {
        revOccurrences.get(entry.getValue()).add(entry.getKey());
        System.out.println("Exist List: " + entry.getValue() + "---" + entry.getKey());
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(entry.getKey());
        revOccurrences.put(entry.getValue(), list);
        System.out.println(entry.getValue() + "---" + entry.getKey());
      }
    }

    int i=1;
    int large=input.length;
    while (i<K && large>0) {
     if (revOccurrences.containsKey(large)) {
       List<Integer> list = revOccurrences.get(large);
       for (int x : list) {
         System.out.println(large + "---"+ x);
         i++;
       }
     }
     large--;
    }
  }

  public static void main(String[] args) {
    int[] input = {1,6,1,6,2,3};
    printKMostFrequentElements(input, 2);
  }
}
