package dynamicprogramming;

import java.util.ArrayList;

public class StockBuySell {
  // https://www.geeksforgeeks.org/stock-buy-sell/

  // Two Best Transactions: https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/?ref=rp

  // K Times: https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
    // https://www.youtube.com/watch?v=oDhu5uGq_ic&t=600s


  // SECTION 1 : Any Number of transactions - but a transaction has to complete before next transaction

  // Time Complexity: Exponential
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

  // https://www.geeksforgeeks.org/stock-buy-sell/
  // Time Complexity: O(n)
  static int maxProfit(int prices[], int size) {
    int maxProfit = 0;
    for (int i = 1; i < size; i++)
      if (prices[i] > prices[i - 1])
        maxProfit += prices[i] - prices[i - 1];
    return maxProfit;
  }

  static class Interval {
    int buy, sell;
  }

  // For Two transactions: note two highest Intervl
  // https://www.geeksforgeeks.org/stock-buy-sell/
  static void stockBuySell(int price[], int n) {
    if (n == 1)
      return;

    int count = 0;

    ArrayList<Interval> sol = new ArrayList<Interval>();

    // Traverse through given price array
    int i = 0;
    while (i < n - 1) {
      while ((i < n - 1) && (price[i] >= price[i+1]))
        i++;

      if (i == n - 1)
        break;

      Interval e = new Interval();
      e.buy = i++;
      // Store the index of minima

      // Find Local Maxima.  Note that the limit is (n-1) as we are
      // comparing to previous element
      while ((i < n) && (price[i] >= price[i - 1]))
        i++;

      // Store the index of maxima
      e.sell = i - 1;
      sol.add(e);

      // Increment number of buy/sell
      count++;
    }

    // print solution
    if (count == 0)
      System.out.println("There is no day when buying the stock "
                + "will make profit");
    else
      for (int j = 0; j < count; j++)
        System.out.println("Buy on day: " + sol.get(j).buy
           + "        "
           + "Sell on day : " + sol.get(j).sell);

    return;
  }

  // K Most Transactions - dynamic programming
  // Time Complexity: O(number of days * Number of Transactions)

  /*
     3   2   1  4  5  1  3

  0  0   0   0  0  0  0  0

  1  0

  2  0


  T[i][j] = max (T[i][j-1], max (price[i]-price[m] + T[i-1][m]))
   */

  private static int maxProfitBottomUp(int[] dayPrices, int transactions) {
    int[][] T = new int[transactions+1][dayPrices.length];

    for (int i=1; i<=transactions; i++) {
      for (int j=0; j<dayPrices.length; j++) {
        if (j==0) {
          T[i][j] = 0;
        } else {
          // here j-1 is previous day profit - no transaction
          int noTransactionAmt = T[i][j-1];
          int transactionAmt = Integer.MIN_VALUE;
          for (int m=0; m<j; m++) {
            // i-1 is one less transaction
            int profit = (dayPrices[j] - dayPrices[m]) + T[i-1][m];
            transactionAmt = Math.max(transactionAmt, profit);
          }
          T[i][j] = Math.max(noTransactionAmt, transactionAmt);
        }
      }
    }

    for (int i=0; i<T.length; i++) {
      for (int j=0; j<T[0].length; j++) {
        System.out.print(T[i][j] + "\t");
      }
      System.out.println();
    }

    return T[transactions][dayPrices.length-1];
  }

  // Max Two Buy Sell

  // Time Complexity: O(N)
  static int maxtwobuysell(int []arr) {
    int first_buy = Integer.MAX_VALUE;
    int first_sell = 0;
    int second_buy = Integer.MIN_VALUE;
    int second_sell = 0;

    for(int i = 0; i < arr.length; i++) {
      first_buy = Math.min(first_buy,arr[i]);
      first_sell = Math.max(first_sell,arr[i]-first_buy);
      second_buy = Math.max(second_buy,first_sell-arr[i]);
      second_sell = Math.max(second_sell,second_buy+arr[i]);
    //  System.out.println(first_buy + "---" + first_sell + "---" + second_buy + "----" + second_sell);
    }
    return second_sell;
  }


  public static void main(String[] args) {
    int[] price = {100, 180, 260, 310, 40, 535, 695};
    System.out.println("MAX PROFIT: " + maxProfit(price, 0, price.length-1));
    System.out.println("MAX PROFIT: " + maxProfit(price, price.length));
    stockBuySell(price, price.length);

    int[] dayPrices = {3, 2, 1, 4, 5, 1, 3};
    int transactions = 2;
    System.out.println("Bottom Up: " + maxProfitBottomUp(dayPrices, transactions));

    System.out.println("Max Two Buy Sell: " + maxtwobuysell(dayPrices));

  }

}
