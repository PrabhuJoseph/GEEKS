package arrays.deeper;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

// https://www.geeksforgeeks.org/pigeonhole-sort/
// https://www.geeksforgeeks.org/maximum-adjacent-difference-array-sorted-form/

public class MaximumGap {

    public int getMaximumGap(int[] arr) {
        // Find Min and Max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int x : arr) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        // Perform PigeonHole Sorting
        LinkedHashMap<Integer, Integer> occurrences = new LinkedHashMap<>();
        for (int i=min; i<=max; i++) {
            occurrences.put(i, 0);
        }

        for (int x : arr) {
            occurrences.put(x, occurrences.get(x)+1);
        }

        for (int i=min; i<=max; i++) {
          System.out.println(i + "--" + occurrences.get(i));
        }

        // Find the Maximum Gap
        int prev=-1, cur=-1;

        int maxGap = Integer.MIN_VALUE;

        List<Integer> values = occurrences.values().stream().toList();

        int start = -1;
        for (int i=0; i<values.size(); i++) {
          if (values.get(i) == 0) {
            start = i;
            while (values.get(i)==0 && i<values.size()) {
              i++;
            }
            maxGap = Math.max(maxGap, i-start);
          }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 2, 5, 10, 2};
        MaximumGap gapObj = new MaximumGap();
        System.out.println(gapObj.getMaximumGap(arr));
    }
}

