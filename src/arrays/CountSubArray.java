package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


// Counts the subarrays which has same distinct elements as the original array
public class CountSubArray {

  public static boolean isDistinctSubArray(int[] arr, int distinct, int start, int end) {
    System.out.println("START="+start+"---"+(end-1));
    ArrayList<Integer> arrList = new ArrayList<>();
    for (int i=start; i<end; i++) {
      arrList.add(arr[i]);
    }
    HashSet<Integer> uniqueValues = new HashSet(arrList);
    System.out.println("RES="+(uniqueValues.size() == distinct));
    return uniqueValues.size() == distinct;
  }

  public static int distinctSubArray(int[] arr, int distinct) {
    int count = 0;
    int i = 0;
    while (i < arr.length) {
      int j = i+distinct;
      while (j <= arr.length) {
        if (isDistinctSubArray(arr, distinct, i, j)) {
          System.out.println("OUT="+(arr.length - j + 1));
          count += (arr.length - j + 1);
          break;
        }
        j++;
      }
      i++;
    }
    return count;
  }

  public static void main(String[] args) {
     int[] arr = {2, 4, 4, 2, 4};
    // int[] arr = {2, 1, 3, 2, 3};
    // int[] arr = {2, 4, 5, 2, 1};
    // int[] arr = {2, 4, 5};
    ArrayList<Integer> arrList = new ArrayList<>();
    for (int i : arr) {
      arrList.add(i);
    }
    HashSet<Integer> uniqueValues = new HashSet(arrList);
    int distinct = uniqueValues.size();
    System.out.println("DISTINCT=" + distinct);
    int output = distinctSubArray(arr, distinct);
    System.out.println("OUTPUT=" + output);
  }
}
