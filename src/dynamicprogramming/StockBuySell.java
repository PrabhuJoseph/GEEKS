package dynamicprogramming;

public class StockBuySell {
  // https://www.geeksforgeeks.org/stock-buy-sell/

  private static int maxProfit(int[] price, int start, int end) {
    if (start >= end) {
      return 0;
    }
    int profit = Integer.MIN_VALUE;
    for (int i=start; i<end; i++) {
      for (int j=i+1; j<=end; j++) {
        if (price[j] > price[i]) {
          int curProfit = (price[j] - price[i]) + maxProfit(price, start, i-1) + maxProfit(price, j+1, end);
          profit = Math.max(profit, curProfit);
        }
      }
    }
    return profit;
  }

  public static void main(String[] args) {
    int[] price = {100, 180, 260, 310, 40, 535, 695};
    System.out.println("MAX PROFIT: " + maxProfit(price, 0, price.length-1));
  }
}
