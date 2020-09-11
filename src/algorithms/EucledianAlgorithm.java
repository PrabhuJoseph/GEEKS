package algorithms;

public class EucledianAlgorithm {

  // Eucledian Algorithm - https://www.geeksforgeeks.org/c-program-find-gcd-hcf-two-numbers/
  // This algorithm is used to find Greatest Common Divisor or Highest Common Factor among two numbers

  private static int getGCD(int a, int b) {
    if (a==0) {
      return b;
    }
    if (b==0) {
      return a;
    }
    if (a==b) {
      return a;
    }
    if (a>b) {
      return getGCD(a-b, b);
    }
    return getGCD(a, b-a);
  }

  public static void main(String[] args) {
    int gcd = getGCD(36, 60);
    System.out.println("Greatest Common Divisor: " + gcd);
  }
}
