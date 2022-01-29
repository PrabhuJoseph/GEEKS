package arrays;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
/*

A Student has already answered answered[i] questions for every subject.
He can answer 1 more questions overall. He has to answer needed[i] questions
to pass. Find the maximum number of subjects that can be passed.
 */

public class FindMaxSubjectsPass {
  public static int findMaxSubjectsPass(int[] ansered, int[] needed, int q) {
    int total = 0;
    // Don't use set - to subjects which need same answer will be overwritten
    List<Integer> neededAns = new ArrayList<>();
    for (int i=0; i<needed.length; i++) {
      int ansNeed = needed[i] - ansered[i];
      if (ansNeed > 0) {
        neededAns.add(ansNeed);
      } else {
        total++;
      }
    }

    // Sorting is the key
    Collections.sort(neededAns);
    for (int x : neededAns) {
      if (q-x >= 0) {
        total++;
        q = q-x;
      } else {
        break;
      }
    }
    return total;
  }

  public static void main(String[] args) {
    int[] answered = {30,30,70,20,10,60};
    int[] needed = {40, 40, 40,40,40,40};
    int q = 50;
    int clear = findMaxSubjectsPass(answered, needed, q);
    System.out.println("MAX SUBJECTS THAT CAN BE PASSED: " + clear);
  }
}
