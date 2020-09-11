package dynamicprogramming;

public class RodCutting {

  // RECURSION

  /*
  price[1] + [3]
   price[1] + [2]
      price[1] + [1]
	     price[1] + [0] = 1
	  proce[2] + [0]
   price[2] + [1]
   price[3] + [0]
  price[2] + [2]
  price[3] + [1]
  proce[4] + [0]
   */

  public static int rodCutUsingrecursion(int[] price, int n) {
    if (n == 0) {
      return 0;
    }
    int max = Integer.MIN_VALUE;
    // Same Number can be used - rod can be cut into 1,1,1...
    for (int i=1; i<=n; i++) {
      max = Math.max(max, price[i-1] + rodCutUsingrecursion(price, n-i));
    }
    return max;
  }

  /*

  T[1] = price[0] + T[0]
  T[2] = price[1] + T[1] or price[2] + T[0]

   */

    public static int bottomUp(int[] price, int n) {
      int T[] = new int[n+1];
      for (int i=1; i<=n; i++) {
        for (int j=1; j<=i; j++) {
          T[i] = Math.max(T[i], price[j-1] + T[i-j]);
        }
      }
      return T[n];
    }


  public static void main(String[] args) {
    int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
    int n = 4;
    System.out.print("Profit is " + rodCutUsingrecursion(price, n)+"-----Using bottomUp="+bottomUp(price, n));
  }
}