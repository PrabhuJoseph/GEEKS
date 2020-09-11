package dynamicprogramming;

import org.omg.PortableInterceptor.INACTIVE;

public class CoinChangeMaking {


  // FIND THE MINIMUM COINS - ONLY ONE COIN
  public static int findMinCoinsSingle(int[] coins, int change, int n) {
    if (change == 0) {
      return 0;
    }
    if (change < 0 || n<0) {
      return Integer.MAX_VALUE;
    }

    int minCoins = Integer.MAX_VALUE;

    int res = findMinCoinsSingle(coins, change-coins[n], n-1);
    if (res != Integer.MAX_VALUE) {
      res = res+1;
    }
    int exclude = findMinCoinsSingle(coins, change, n-1);

    minCoins = Math.min(res, exclude);
    return minCoins;
  }

  // FIND THE MINIMUM COINS - EACH COIN MULTIPLE TIMES
  public static int findMinCoinsMultiple(int[] coins, int change) {
    if (change == 0) {
      return 0;
    }
    if (change < 0) {
      return Integer.MAX_VALUE;
    }

    int minCoins = Integer.MAX_VALUE;

    for (int i=0; i<coins.length; i++) {
      int res = findMinCoinsMultiple(coins, change - coins[i]);
      if (res != Integer.MAX_VALUE) {
        res = res + 1;
      }
      minCoins = Math.min(res, minCoins);
    }
    return minCoins;
  }



  public static void main(String[] args) {
    int[] coins = new int[] {1, 3, 5, 7};

    int change = 14; //OUTPUT: 2
    int minCoins = findMinCoinsMultiple(coins, change);
    System.out.println("Minimum Coins with Multiple="+minCoins);

    change = 16; // OUTPUT: 4
    minCoins = findMinCoinsSingle(coins, change, coins.length-1);
    System.out.println("Minimum Coins With Single="+minCoins);
  }
}
