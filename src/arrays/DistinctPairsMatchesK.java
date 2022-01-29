package arrays;

import java.util.*;

public class DistinctPairsMatchesK {

  static class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static List<Pair> getDistinctPairsMatchesK(List<Integer> arrList, int K) {
    List<Pair> pairs = new ArrayList<>();
    HashSet set = new HashSet();
    set.addAll(arrList);
    for (int x : arrList) {
      int y = K / x;
      if (set.contains(y)) {
        pairs.add(new Pair(x, y));
        set.remove(y);
        set.remove(x);
      }
    }
    return pairs;
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList();
    list.add(1);
    list.add(2);
    list.add(16);
    list.add(4);
    list.add(4);

    List<Pair> pairs = getDistinctPairsMatchesK(list, 16);
    for (Pair pair : pairs) {
      System.out.println("(" + pair.x + "," + pair.y + ")");
    }
  }
}
