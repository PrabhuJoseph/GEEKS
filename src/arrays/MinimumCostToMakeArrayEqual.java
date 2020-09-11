package arrays;

public class MinimumCostToMakeArrayEqual {


  // INCREASE OR DECREASE BY 1
  public static void main(String[] args) {
    System.out.println("Minimum Cost="+minimumCost(new int[]{1,2,3,4,5}));
  }

  public static int minimumCost(int[] arr) {
    int odd = 0;
    int even = 0;
    for (int x : arr) {
      if (x % 2 == 0) {
        even++;
      } else {
        odd++;
      }
    }
    return Math.min(even, odd);
  }

}
