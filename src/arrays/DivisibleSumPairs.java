package arrays;

import java.util.ArrayList;
import java.util.List;

public class DivisibleSumPairs {

  static class Pair {
      int x;
      int y;

      Pair(int x, int y) {
          this.x = x;
          this.y = y;
      }
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1,2,3,4,5,6};
    List<Pair> pairs = new ArrayList<>();

    int k = 5;
    for (int i=0; i<arr.length; i++) {
      for (int j=i+1; j<arr.length; j++) {
        int sum = arr[i] + arr[j];
        if (sum % k == 0) {
            pairs.add(new Pair(i+1,j+1));
        }
      }
    }

    for (Pair pair : pairs) {
        System.out.println(pair.x+"---"+pair.y);
    }

  }
}


