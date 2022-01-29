package algorithms;

public class Ugly {

  // UGLY Prime Number
  public static boolean isUgly(int n) {
    n = maxDivide(n, 2);
    n = maxDivide(n, 3);
    n = maxDivide(n, 5);
    return n == 1;
  }


  public static int maxDivide(int a, int b) {
    while (a % b == 0) {
      a = a/b;
    }
    return a;
  }

  public static int getUglyNumber(int n) {
    int i = 1;
    while (i <= n) {
      if (isUgly(i)) {
        i++;
      }
    }
    return i;
  }

  public static void main(String[] args) {
    System.out.println(getUglyNumber(5));
  }

}
