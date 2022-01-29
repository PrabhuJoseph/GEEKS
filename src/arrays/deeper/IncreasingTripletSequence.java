package arrays.deeper;


// https://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/

// https://github.com/mission-peace/interview/blob/master/src/com/interview/array/IncreasingTripletSubsequence.java

public class IncreasingTripletSequence {

  // O(n) but space complexity is O(n)
  public static void find3Numbers(int[] arr) {
    int[] minArr = new int[arr.length];
    int[] maxArr = new int[arr.length];

    minArr[0] = -1;
    maxArr[maxArr.length-1] = -1;

    int min = 0;
    int max = maxArr.length-1;

    for (int i=1; i<arr.length; i++) {
      if (arr[i] > arr[min]) {
        minArr[i] = min;
      } else {
        min = i;
        minArr[i] = -1;
      }
    }

    for (int i=arr.length-2; i>=0; i--) {
      if (arr[i] < arr[max]) {
        maxArr[i] = max;
      } else {
        max = i;
        maxArr[i] = -1;
      }
    }

    for (int i=1; i<arr.length-2; i++) {
      if (minArr[i] != -1 && maxArr[i] != -1) {
        System.out.println(arr[minArr[i]] + "\t" + arr[i] + "\t" + arr[maxArr[i]]);
      }
    }
  }


  public static void main(String[] args) {
    int arr[] = { 12, 11, 10, 5, 6, 2, 30 };
    find3Numbers(arr);
  }

}
