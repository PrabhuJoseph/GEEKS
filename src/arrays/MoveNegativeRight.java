package arrays;

import java.util.ArrayList;

public class MoveNegativeRight {

  public static int[] moveNegativeRight(int[] arr) {
    int[] ret = new int[arr.length];
    int positive = -1;
    int negative = arr.length;
    for (int x : arr) {
      if (x < 0) {
        ret[--negative] = x;
      } else {
        ret[++positive] = x;
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1,-2,-3,-4,-5,-6,5,6,7};
    int[] ret = moveNegativeRight(arr);
    for (int x : ret) {
      System.out.println(x);
    }
  }
}
