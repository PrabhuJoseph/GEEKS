package algorithms;

public class TrappingRainWater {

  // https://practice.geeksforgeeks.org/problems/trapping-rain-water/0

  // https://www.geeksforgeeks.org/trapping-rain-water/

  private static int getAmountOfWater(int[] arr) {
    int[] leftMax = new int[arr.length];
    int[] rightMax = new int[arr.length];

    int max = Integer.MIN_VALUE;
    for (int i=0; i<arr.length; i++) {
      max = Math.max(max, arr[i]);
      leftMax[i] = max;
    }

    max = Integer.MIN_VALUE;
    for (int i=arr.length-1; i>=0; i--) {
      max = Math.max(max, arr[i]);
      rightMax[i] = max;
    }

    for (int i=0; i<arr.length; i++) {
      System.out.println(leftMax[i] + "----" + rightMax[i]);
    }


    int amount = 0;
    for (int i=1; i<arr.length-1; i++) {
      int min = Math.min(leftMax[i], rightMax[i]);
      if (arr[i] < min) {
          amount += (min - arr[i]);
      }
    }
    return amount;
  }

  public static void main(String[] args) {
    // int[] arr = {3, 0, 2, 0, 4};
    int[] arr = {3,2,1,2,3};
    //int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println("Total Amount of Water: " + getAmountOfWater(arr));
  }
}
