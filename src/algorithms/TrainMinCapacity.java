package algorithms;

public class TrainMinCapacity {

  public static void main(String[] args) {
    System.out.println(minCapacity(new int[]{3,5,2,0}, new int[] {0,2,4,4}));
  }

  public static int minCapacity(int[] entry, int[] exit) {
    int prev = 0;
    int cur = 0;
    int max = Integer.MIN_VALUE;
    for (int i=0; i<entry.length; i++) {
      cur = prev + (entry[i] - exit[i]);
      max = Math.max(max, cur);
      prev = cur;
    }
    return max;
  }


}
