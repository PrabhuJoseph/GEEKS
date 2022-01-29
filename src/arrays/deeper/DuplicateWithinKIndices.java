package arrays.deeper;

// https://github.com/mission-peace/interview/blob/master/src/com/interview/array/DuplicateWithinkIndices.java

import java.util.HashSet;

public class DuplicateWithinKIndices {

  public static void main(String[] args) {
    int arr[] = {1,2,3,11,4,5,6,4};
    DuplicateWithinKIndices dk = new DuplicateWithinKIndices();
    System.out.println(dk.duplicate(arr, 3));
  }

  private boolean duplicate(int[] arr, int K) {
    HashSet<Integer> set = new HashSet<>();
    for (int i=0; i<arr.length; i++) {
      if (set.contains(arr[i])) {
        return true;
      }
      if (i >= K) {
        set.remove(arr[i-K]);
      }
      set.add(arr[i]);
    }
    return false;
  }
}
