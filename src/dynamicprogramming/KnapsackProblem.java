package dynamicprogramming;

public class KnapsackProblem {

  // https://www.techiedelight.com/0-1-knapsack-problem/

  // https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/Knapsack01.java



  public static void main(String[] args) {
  //  int[] value = {20, 5, 10, 40, 15, 25};
  //  int[] weight = {1, 2, 3, 8, 7, 4};
    //int W=10;

    // SIMPLE
    int[] value = {1, 3, 2};
    int[] weight = {1, 2, 3};
    int W = 3;

    int result = knapsackValue(value, weight, W, 0);
    System.out.println("RESULT="+result);

    result = bottomUpDP(value, weight, W);
    System.out.println("RESULT="+result);

  }


  private static int bottomUpDP(int[] value, int[] weight, int inputWeight) {
    int[][] temp = new int[value.length+1][inputWeight+1];

    // LOOP items (an item is value and weight for an index) with given input weight (not array)
    for (int item = 1; item<=value.length; item++) {
      for (int w=1; w<=inputWeight; w++) {
        int i = item - 1;
        if (w - weight[i] >= 0) {
          temp[item][w] = Math.max(temp[item - 1][w], value[i] + temp[item - 1][w - weight[i]]);
        } else {
          temp[item][w] = temp[item - 1][w];
        }
      }
    }
    for (int j=0; j<temp.length; j++) {
      System.out.print("W"+j+" ");
    }
    System.out.println();
    for (int i=0; i<temp.length; i++) {
      for (int j=0; j<temp[0].length; j++) {
        System.out.print(temp[i][j]+" ");
      }
      System.out.println();
    }
    return temp[value.length][inputWeight];
  }

  private static int knapsackValue(int[] value, int[] weight, int w, int i) {
    if (w == 0) {
      return 0;
    }
    if (i >= value.length || w<0) {
      return Integer.MIN_VALUE;
    }
    int include = value[i] + knapsackValue(value, weight, w-weight[i], i+1);
    int exclude = knapsackValue(value, weight, w, i+1);
    return Math.max(include, exclude);
  }
}
