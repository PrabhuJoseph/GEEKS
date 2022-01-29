package arrays;

import java.util.HashSet;

public class MaximumSumTriplets {

  // O(n3)
  public static int findMaxTriplet(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int i=0; i<arr.length; i++) {
      for (int j=i+1; j<arr.length; j++) {
        int sum;
        if (arr[i] < arr[j]) {
          for (int k=j+1; k<arr.length; k++) {
            if (arr[j] < arr[k]) {
              sum = arr[i] + arr[j] + arr[k];
              if (max < sum) {
                max = sum;
              }
            }
          }
        }
      }
    }
    return max;
  }

  // O(n2)
  public static int findMaxTriplet1(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int i=1; i<arr.length-1; i++) {
      int max1 = Integer.MIN_VALUE;
      int max2 = Integer.MIN_VALUE;
      for (int j=0; j<i; j++) {
        if (arr[j] < arr[i]) {
          max1 = Math.max(max1, arr[j]);
        }
      }
      for (int k=i+1; k<arr.length; k++) {
        if (arr[k] > arr[i]) {
          max2 = Math.max(max2, arr[k]);
        }
      }
      System.out.println(max1+"----"+arr[i]+"----"+max2);
      max = Math.max(max, max1 + arr[i] + max2);
    }
    return max;
  }


  public static void main(String[] args) {
    int[] arr = new int[] {4, 3, 1, 5, 6, 2};
    System.out.println("MAX TRIPLET SUM="+ findMaxTriplet(arr));
    System.out.println("MAX TRIPLET SUM="+ findMaxTriplet1(arr));
  }
}
