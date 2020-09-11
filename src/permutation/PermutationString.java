package permutation;

import java.util.HashSet;
import java.util.LinkedList;

public class PermutationString {

  /*  https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

    NUMBER OF PERMUTATIONS FORMULA:

    A = 1
    AB = 2
    ABC = 6
    ABCD = 24
    ABCDE = 120
    ABCDEF = 720

    */



  public static HashSet<String> permute(String input) {
    HashSet<String> output = new HashSet<>();
    LinkedList<String> curQueue = new LinkedList();
    LinkedList<String> nextQueue = new LinkedList();
    nextQueue.add(input);
    for (int level=0; level < input.length()-1; level++) {
      curQueue.addAll(nextQueue);
      nextQueue.clear();
      while (curQueue.size() > 0) {
        String cur = curQueue.poll();
        char A = cur.charAt(level);
        for (int i=level; i<input.length(); i++) {
          StringBuilder sb = new StringBuilder(cur);
          char B = cur.charAt(i);
          sb.setCharAt(level, B);
          sb.setCharAt(i, A);
          nextQueue.add(sb.toString());
          output.add(sb.toString());
        }

      }
    }
    return output;
  }

  public static void main(String[] args) {
   // String input = "";
    String input = "ABCD";
    HashSet<String> output = permute(input);
    System.out.println("PERUMATION="+output.size());
    for (String str : output) {
      System.out.println(str);
    }
  }
}
