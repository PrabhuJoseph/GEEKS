package arrays;

public class CountCorrectPosition {

  // Count of elements which are not at the correct position in an unsorted array

  // Apply Selection Sort Algorithm

  public static void main(String[] args) {
    int[] input = new int[]{1, 2, 2, 4, 2, 3};
    System.out.println("COUNT="+findCount(input));
  }

  public static int findCount(int[] arr) {
    int output = 0;
    for (int i=0; i<arr.length; i++) {
      int minIndex = findMinIndex(i, arr.length, arr);
      if (minIndex != i) {
        output++;
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
      }
    }

    for (int x: arr) {
      System.out.println(x);
    }

    return output > 0 ? output+1 : output;
  }

  public static int findMinIndex(int start, int end, int[] arr) {
    int minIndex = -1;
    int min = Integer.MAX_VALUE;
    for (int i=start; i<end; i++) {
      if (arr[i] < min) {
        min = arr[i];
        minIndex = i;
      }
    }
    return minIndex;
  }
}
