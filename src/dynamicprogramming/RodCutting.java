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

  public static int rodCutUsingrecursion(int price[],int len){
    if(len <= 0){
      return 0;
    }
    int maxValue = 0;
    for(int i=0; i < len;i++){
      int val = price[i] + rodCutUsingrecursion(price, len-i-1);
      if(maxValue < val){
        maxValue = val;
      }
    }
    return maxValue;
  }

  /*

  T[1] = price[0] + T[0]
  T[2] = price[1] + T[1] or price[2] + T[0]

   */

    public static int bottomUp1(int[] price, int len) {
      int T[][] = new int[len+1][price.length+1];

      /* Loop price target and items */
      for (int i=1; i<=len; i++) {
        for (int j=1; j<=price.length; j++) {
          if (j-i >= 0) {
            T[i][j] = Math.max(T[i-1][j], price[i-1] + T[i][j-i]);
          } else {
            T[i][j] = T[i-1][j];
          }
        }
      }
      for (int i=0; i<T.length; i++) {
        for (int j=0; j<T[0].length; j++) {
          System.out.print(T[i][j] + "\t");
        }
        System.out.println();
      }
      return T[len][price.length];
    }

  public static int bottomUp(int price[]){
    int max[] = new int[price.length+1];
    for(int i=1; i <= price.length; i++){
      for(int j=i; j <= price.length; j++){
        max[j] = Math.max(max[j], max[j-i] + price[i-1]);
      }
    }
    return max[price.length];
  }

  public static void main(String[] args) {
    // Similar to Knapsack problem but with little difference - check and understand
    int[] price = {1, 5, 8, 9};
    int n = price.length;
    System.out.println("Profit is " + rodCutUsingrecursion(price, n)+"-----Using bottomUp="+bottomUp1(price, n));
    System.out.println("Correct Bottom Up: " + bottomUp(price));
    }
}