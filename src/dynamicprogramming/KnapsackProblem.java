package dynamicprogramming;

public class KnapsackProblem {

  // https://www.techiedelight.com/0-1-knapsack-problem/

  // https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/Knapsack01.java


  public static int knapsackValue(int[] value, int[] weight, int W, int n) {
    if (W == 0) {
      return 0;
    }

    if (W<0 || n<0) {
      return Integer.MIN_VALUE;
    }

    int include = value[n] + knapsackValue(value, weight, W-weight[n], n-1);
    int exclude = knapsackValue(value, weight, W, n-1);
    return Math.max(include, exclude);
  }


  /**
   * Solves 0/1 knapsack in bottom up dynamic programming
   */
  public static int bottomUpDP(int val[], int wt[], int W){
    int K[][] = new int[val.length+1][W+1];
    for(int i=0; i <= val.length; i++){
      for(int j=0; j <= W; j++){
        if(i == 0 || j == 0){
          K[i][j] = 0;
          continue;
        }
        if(j - wt[i-1] >= 0){
          K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
        }else{
          K[i][j] = K[i-1][j];
        }
      }
    }

    for (int j=0; j<W+1; j++) {
      System.out.print("W"+j+" ");
    }
    System.out.println();
    for (int i=0; i<val.length+1; i++) {
      for (int j=0; j<W+1; j++) {
        System.out.print(K[i][j]+" ");
      }
      System.out.println();
    }

    return K[val.length][W];
  }


  public static void main(String[] args) {
  //  int[] value = {20, 5, 10, 40, 15, 25};
  //  int[] weight = {1, 2, 3, 8, 7, 4};
    //int W=10;

    // SIMPLE
    int[] value = {1, 3, 2};
    int[] weight = {1, 2, 3};
    int W = 3;

    int result = knapsackValue(value, weight, W, value.length-1);
    System.out.println("RESULT="+result);

    result = bottomUpDP(value, weight, W);
    System.out.println("RESULT="+result);

  }
}
