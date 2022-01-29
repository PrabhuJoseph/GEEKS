package arrays.deeper;

// https://www.youtube.com/watch?v=VX2oZkDJeGA

// Tortoise and Hare Algorithm (Floyd's algorithm)

public class DetectCycleInArray {
  public static void main(String[] args) {
    // Cycle
    // int[] input = {1, 2, 3, 1, 5, 6};

    // No Cycle
    int[] input = {1,2,3,4,5,6};

    int A = 0;
    int B = 0;
    boolean cycleDetected = false;

    while (true) {
      if (A >= input.length || B >= input.length || A<0 || B<0) {
        break;
      }
      A = input[A];
      if (A >= input.length || A<0) {
        break;
      }
      A = input[A];
      if (A >= input.length || A<0) {
        break;
      }
      if (A == B) {
        cycleDetected = true;
        break;
      }
      B = input[B];
      if (B >= input.length || B<0) {
        break;
      }
      if (A == B) {
        cycleDetected = true;
        break;
      }
    }
    System.out.println(cycleDetected);
  }
}
