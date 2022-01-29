package arrays.deeper;

public class MinimumDistanceBetweenTwoNumbers {


  public static void main(String[] args) {
    MinimumDistanceBetweenTwoNumbers min = new MinimumDistanceBetweenTwoNumbers();
    int arr[] = { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 };
    int n = arr.length;
    int x = 3;
    int y = 6;

    System.out.println("Minimum distance between " + x
        + " and " + y + " is "
        + min.minDist(arr, n, x, y));
  }

  private int minDist(int[] arr, int n, int x, int y) {
    int start_index = -1;
    int minDistance = Integer.MAX_VALUE;
    for (int i=0; i<arr.length; i++) {
      if (arr[i]==x || arr[i]==y) {
        if (start_index == -1) {
          start_index = i;
        } else {
          if (arr[start_index] == arr[i]) {
            start_index = i;
          } else {
            minDistance = Math.min(minDistance, i-start_index);
          }
        }
      }
    }
    return minDistance;
  }
}
