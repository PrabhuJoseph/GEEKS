package dynamicprogramming;


// https://www.techiedelight.com/shortest-common-supersequence-introduction-scs-length/

public class ShortestCommonSubsequence {

  public static int findSCS(String A, String B, int aN, int bN) {
    if (aN == 0 || bN == 0) {
      return aN + bN;
    }
    if (A.charAt(aN-1) == B.charAt(bN -1)) {
      return findSCS(A, B, aN - 1, bN - 1) + 1;
    } else {
      return Math.min(findSCS(A, B, aN -1, bN), findSCS(A, B, aN, bN-1)) + 1;
    }
  }

  public static void main(String[] args) {
    String A = "ABCBDAB";
    String B = "BDCABA";

    // ShortestCommonSubsequence = ABCBDCABA

    int result = findSCS(A, B, A.length(), B.length());
    System.out.println("RESULT="+result);
  }
}
