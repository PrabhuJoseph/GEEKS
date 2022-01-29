package algorithms;

public class GreatestCommonDivisor {

  public static int generalizedGCD(int num, int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int i=0; i<arr.length; i++) {
      if (max < arr[i]) {
        max = arr[i];
      }
    }

    int max_element = -1;
    int finalMax = 0, curMax;
    for (int i=1; i<=max; i++) {
      curMax = 0;
      for (int x : arr) {
        if (x % i == 0) {
          curMax++;
        }
      }
      if (finalMax <= curMax) {
        finalMax = curMax;
        max_element = i;
      }
    }

    return max_element;

  }

  public static void main(String[] args) {
    int[] arr = {2,4,6,8,10};
    int num = 5;
    int result = generalizedGCD(num, arr);
    System.out.println("Greatest Common Divisor: " + result);
  }
}
