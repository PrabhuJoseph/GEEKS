package arrays.deeper;

// https://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/

public class ReplaceGreatestElement {

  public static void printGreatestElement(int[] arr) {
    int n = arr.length;
    int max = -1;
    for (int i=n-1; i>=0; i--) {
      int temp = arr[i];
      arr[i] = max;
      max = Math.max(max, temp);
    }
    for (int x : arr) {
      System.out.print(x + "\t");
    }
  }

  public static void main(String[] args) {
    int[] arr = {10, 5, 7, 9, 2};
    printGreatestElement(arr);
  }

}
