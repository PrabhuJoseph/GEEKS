package permutation;

import java.util.HashSet;
import java.util.LinkedList;

public class PermutationSubsetArray {

    /* ALGORITHM

    0 1 2 3

    Level 1 -> 0, 1 , 2 , 3

    Level 2 -> 01, 02, 03, 12, 13, 23

    Level 3 -> 012, 013, 023, 123

    Level 4 -> 0123
     */

    public static class Subset {
      public int[] subset;
      int last;
      int cur = 0;
      Subset(int size, int last) {
        this.last = last;
        subset = new int[size];
      }

      Subset(int last, int[] arr) {
        this.last = last;
        subset = arr;
      }

      public void add(int x) {
        subset[cur++] = x;
      }

      public Subset clone(int size, int last) {
          Subset clone = new Subset(size, last);
          for (int i = 0; i < subset.length; i++) {
              clone.add(subset[i]);
          }
          return clone;
      }

      public void display() {
        for (int i=0; i< subset.length; i++) {
            System.out.print(subset[i]);
            System.out.print("-");
        }
        System.out.println("\n");
      }

    }

    public static LinkedList<Subset> permute(int[] input) {
      LinkedList<Subset> current = new LinkedList<>();
      LinkedList<Subset> next = new LinkedList<>();
      LinkedList<Subset> output = new LinkedList<>();
      for (int x=0; x<input.length; x++) {
        Subset subset = new Subset(1, x);
        subset.add(input[x]);
        next.add(subset);
      }
      for (int level=1; level < input.length; level++) {
        current.addAll(next);
        output.addAll(next);
        next.clear();
        while (current.size() > 0) {
          Subset curElement = current.poll();
          for (int i = curElement.last+1; i < input.length; i++) {
            Subset clone = curElement.clone(curElement.subset.length + 1, i);
            clone.add(input[i]);
            next.add(clone);
          }
        }
      }
      if (input.length > 1) {
          output.add(new Subset(input.length, input));
      }
      return output;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        LinkedList<Subset> output = permute(input);
        System.out.println("PERMUTATION OF SUBSET="+output.size());
        for (Subset subset : output) {
          subset.display();
        }
    }
}
