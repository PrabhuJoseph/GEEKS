package dynamicprogramming;

// https://www.techiedelight.com/levenshtein-distance-edit-distance-problem/

public class LevenshteinDistance {

  // EFFICIENT ALGOROTHM
  public static int minimalEdit1(StringBuilder A, StringBuilder B, int ai, int bi) {
    if (ai == 0) {
      return bi;
    }
    if (bi == 0) {
      return ai;
    }

    if (A.charAt(ai-1) == B.charAt(bi-1)) {
      return minimalEdit1(A, B, ai-1, bi-1);
    } else {
      return Math.min(Math.min(minimalEdit1(A, B, ai-1, bi-1) + 1,
              minimalEdit1(A, B, ai, bi-1) + 1),
              minimalEdit1(A, B, ai-1, bi) + 1);
    }
  }

  public static void main(String[] args) {
    StringBuilder A = new StringBuilder("kitten");
    StringBuilder B = new StringBuilder("sitan");

    int edits = minimalEdit1(A, B, A.length(), B.length());
    System.out.println("MINIMAL EDITS USING EFFICIENT ALGOROTHM="+edits);
  }
}
