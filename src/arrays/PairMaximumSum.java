package arrays;

public class PairMaximumSum {
  // https://www.geeksforgeeks.org/find-a-pair-nr-in-an-integer-array-such-that-value-of-npr-is-maximum/?ref=leftbar-rightbar

  static class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static Pair getMaxPair(int[] arr) {
    int max1, max2;
    if (arr[0] > arr[1]) {
      max1 = arr[0];
      max2 = arr[1];
    } else {
      max1 = arr[1];
      max2 = arr[0];
    }

    for (int i = 2; i < arr.length; i++) {
      if (arr[i] > max1) {
        max2 = max1;
        max1 = arr[i];
      } else if (arr[i] > max2) {
        max2 = arr[i];
      }
      System.out.println(arr[i]+"----"+max1+"----"+max2);
    }
    return new Pair(max1, max2);
  }

  public static void main(String[] args) {
    int[] arr = new int[] {7, 6, 5, 4, 9};
    Pair maxPair = getMaxPair(arr);
    System.out.println("MAX PAIR: (" + maxPair.x + "," + maxPair.y + ")");
  }
}
