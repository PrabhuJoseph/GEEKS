package dynamicprogramming;

// https://www.techiedelight.com/levenshtein-distance-edit-distance-problem/

public class LevenshteinDistance {

  // INITIAL ALGOROTHM
  public static int minimalEdit(StringBuilder A, StringBuilder B, int ai, int bi, int edits) {
    if (ai == A.length()-1 || bi == B.length()-1) {
      return edits;
    }
    System.out.println("A="+A+"--"+A.length());
    if (A.charAt(ai) == B.charAt(bi)) {
      return minimalEdit(A, B, ai+1, bi+1, edits);
    } else {
      edits++;
      StringBuilder A1 = new StringBuilder(A);
      StringBuilder A2 = new StringBuilder(A);
      StringBuilder A3 = new StringBuilder(A);
      return Math.min(Math.min(minimalEdit(A1.replace(ai, ai+1, B.charAt(bi) + ""), B, ai+1, bi+1, edits),
              minimalEdit(A2.delete(ai, ai+1), B, ai, bi, edits)),
              minimalEdit(A3.insert(ai, B.charAt(ai) + ""), B, ai+1, bi+1, edits));
    }
  }

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
    StringBuilder B = new StringBuilder("sitaen");
    int edits = minimalEdit(A, B, 0, 0, 0);
    System.out.println("MINIMAL EDITS="+edits);

    edits = minimalEdit1(A, B, A.length(), B.length());
    System.out.println("MINIMAL EDITS USING EFFICIENT ALGOROTHM="+edits);
  }
}
