package arrays.deeper;

// https://www.youtube.com/watch?v=86CQq3pKSUw

public class MaxSumSubArrayKadane {

  private static int getMaxSumSubArray(int[] arr) {
    int globalMaxSum = Integer.MIN_VALUE;
    int prevBestSum = arr[0];

    for (int i=1; i<arr.length; i++) {
      if(arr[i] > arr[i] + prevBestSum) {
        prevBestSum = arr[i];
      } else {
        prevBestSum = arr[i] + prevBestSum;
      }
      globalMaxSum = Math.max(globalMaxSum, prevBestSum);
    }
    return globalMaxSum;
  }

  // Find Min Sum and subtract from Total sum
  private static int getMaxSumSubArrayCircular(int[] arr) {
    int globalMinSum = Integer.MAX_VALUE;
    int prevBestSum = arr[0];
    int totalSum = arr[0];

    for (int i=1; i<arr.length; i++) {
      if (arr[i] < arr[i] + prevBestSum) {
        prevBestSum = arr[i];
      } else {
        prevBestSum = arr[i] + prevBestSum;
      }
      System.out.println("prev: " + prevBestSum);
      globalMinSum = Math.min(globalMinSum, prevBestSum);
      System.out.println("Gobal Min Sum: " + globalMinSum);
      totalSum += arr[i];
    }
    if (globalMinSum < 0) {
      return totalSum - globalMinSum;
    } else {
      return totalSum;
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, -3, 2, 1, -1};
    int x = getMaxSumSubArray(arr);
    System.out.println(x);
    int y = getMaxSumSubArrayCircular(new int[]{-1, -3, 3, -1, 3});
    System.out.println(y);
  }

}
