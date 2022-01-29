package recursion;

public class TowerHopperProblem {

  static boolean reachEnd(int[] towers, int current) {
    if (current >= towers.length) {
      return true;
    }
    if (towers[current] == 0) {
      return false;
    }
    boolean res = false;
    for (int i=1; i<=towers[current]; i++) {
        res = res || reachEnd(towers, current + i);
    }
    return res;
  }

  // Optimal Solution - https://www.youtube.com/watch?v=kHWy5nEfRIQ&list=PLBZBJbE_rGRVnpitdvpdY9952IsKMDuev&index=13
  static boolean reachEndOptimally(int[] towers, int current) {
    int max = 0, maxIndex = 0;
    for (int i=1; i<=towers[current]; i++) {
      if (current + i >= towers.length) {
        return true;
      }
      if (max < towers[current + i]) {
        max = towers[current + i];
        maxIndex = current + i;
      }
    }
    if (maxIndex == 0) {
      return false;
    }
    return reachEndOptimally(towers, maxIndex);
  }

  public static void main(String[] args) {
    int[] towers = {4, 1, 0, 0, 5, 0, 0, 0, 0, 0};
    System.out.println(reachEnd(towers, 0));
    System.out.println(reachEndOptimally(towers, 0));
  }
}
