package algorithms;

import permutation.PermutationSubsetArray;

import java.util.LinkedList;

public class SumRecursionBruteForce {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 3};
    int sum = 6;
    LinkedList<PermutationSubsetArray.Subset> output = new LinkedList<>();
    LinkedList<PermutationSubsetArray.Subset> subsets = PermutationSubsetArray.permute(arr);
    for (PermutationSubsetArray.Subset subset : subsets) {
      int calcSum = 0;
      for (int i=0; i<subset.subset.length; i++) {
        calcSum += subset.subset[i];
      }
      if (calcSum == sum) {
        output.add(subset);
      }
    }
    System.out.println("SUM RECURSION="+output.size());
  }

}
