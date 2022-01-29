package arrays.deeper;

// https://www.youtube.com/watch?v=VeJOswJTDos

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
      int[] arr = {1, 3, 4, 7, 8, 2, 5, 9, 6, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
      System.out.println(getLongestConsecutiveSequence(arr));
    }

    private static int getLongestConsecutiveSequence(int[] arr) {
      HashSet<Integer> set = new HashSet<>();
      for (int num : arr) {
        set.add(num);
      }
      int longest = Integer.MIN_VALUE;
      for (int num: arr) {
        // Find the starting point
        if (set.contains(num-1)) {
          continue;
        }
        int curNum = num;
        while (set.contains(++curNum)) {
        }
        longest = Math.max(longest, curNum-num);
      }
      return longest;
    }

}
