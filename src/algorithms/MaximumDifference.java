package algorithms;

public class MaximumDifference {
  // https://www.geeksforgeeks.org/maximum-difference-between-two-elements/

  private static int maxDiff(int[] arr, int size) {
    int maxDiff = arr[1] - arr[0];
    int min = arr[0];
    for (int i=1; i<arr.length; i++) {
      if (maxDiff < arr[i]-min) {
        maxDiff = arr[i] - min;
      }
      if (min > arr[i]) {
        min = arr[i];
      }
    }
    return maxDiff;
  }

  public static void main(String[] args) {
    int arr[] = {1, 2, 90, 10, 110};
    int size = arr.length;
    System.out.println("MaximumDifference is " +
        maxDiff(arr, size));
  }
}
