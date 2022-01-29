package arrays.deeper;

// https://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/

public class MaxRepeatingNumber {

  public static void main (String[] args) {
    int arr[] = {2, 6, 6, 5, 6, 4, 1, 7, 7, 7};
    int n = arr.length;
    int k=8;
    System.out.println("Maximum repeating element is: " +
      maxRepeating(arr,n,k));
  }

  private static int maxRepeating(int[] arr, int n, int k) {
    int max = Integer.MIN_VALUE;
    int max_idx = -1;
    for (int i=0; i<n; i++) {
      int idx = arr[i] % k;
      arr[idx] += k;
      if (max < arr[idx]) {
        max = arr[idx];
        max_idx = idx;
      }
    }
    return max_idx;
  }
}
