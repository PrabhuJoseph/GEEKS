package recursion;

public class Fibonacci {

  public static int fibonacci(int n) {
    if (n==1 || n==2) {
      return 1;
    }
    return fibonacci(n-2) + fibonacci(n-1);
  }

  public static int fibonacci(int n, int[] memo) {
    if (memo[n-1] != 0) {
      return memo[n-1];
    }
    if (n==1 || n==2) {
      memo[n-1] = 1;
      return 1;
    }
    int result = fibonacci(n-2, memo) + fibonacci(n-1, memo);
    memo[n-1] = result;
    return result;
  }

  public static int fibonacci(int n, boolean bottomUp) {
    if (!bottomUp) {
      return fibonacci(n);
    }
    int[] fib = new int[n];
    for (int i=0; i<n; i++) {
      if (i==0 || i==1) {
        fib[i] = 1;
      } else {
        fib[i] = fib[i - 2] + fib[i - 1];
      }
    }
    return fib[n-1];
  }



  public static void main(String[] args) {
    int n = 1000;
    int[] memo = new int[n];
    System.out.println("FIBONACCI="+fibonacci(n, true));
  }
}
