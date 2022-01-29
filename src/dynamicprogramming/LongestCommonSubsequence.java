package dynamicprogramming;

import java.util.Arrays;


// https://www.techiedelight.com/longest-common-subsequence/

public class LongestCommonSubsequence {

  static String A = "ABCD";
  static String B = "ABD";

  // Longest Common Subsequence is ABD


  static int[][] memoization = new int[A.length()][B.length()];

  static {
    for (int i=0; i<memoization.length; i++) {
      Arrays.fill(memoization[i], -1);
    }
  }

  // Memoization using Top Down Approach
  public static int maxLCSWithMemoization(String A, String B, int aN, int bN) {
    if (aN == 0 || bN == 0) {
      return 0;
    }
    if (memoization[aN-1][bN-1] !=-1) {
      return memoization[aN-1][bN-1];
    }
    if (A.charAt(aN-1) == B.charAt(bN -1)) {
      int res = maxLCSWithMemoization(A, B, aN -1 , bN -1) + 1;
      memoization[aN-1][bN-1] = res;
      return res;
    }
    int res = Math.max(maxLCSWithMemoization(A, B, aN-1, bN), maxLCSWithMemoization(A, B, aN, bN-1));
    memoization[aN-1][bN-1] = res;
    return res;
  }

  public static int maxLCS(String A, String B, int aN, int bN) {
    if (aN == 0 || bN == 0) {
      return 0;
    }
    if (A.charAt(aN-1) == B.charAt(bN -1)) {
      return maxLCS(A, B, aN -1 , bN -1) + 1;
    }
    return Math.max(maxLCS(A, B, aN-1, bN), maxLCS(A, B, aN, bN-1));
  }

  // Bottom Up Approach

  /*

  LookUp Table:

    0 A B C D

 0 0 0 0 0 0

 A 0 1 1 1 1

 B 0 1 2 2 2

 D 0 1 2 2 3

   */

  public static int maxLCSBottomUp(String A, String B) {
    int[][] lookupTable = new int[A.length()+1][B.length()+1];

    for (int i=1; i<=A.length(); i++) {
      for (int j=1; j<=B.length(); j++) {
        if (A.charAt(i-1) == B.charAt(j-1)) {
          lookupTable[i][j] = lookupTable[i-1][j-1] + 1;
        } else {
          lookupTable[i][j] = Math.max(lookupTable[i-1][j], lookupTable[i][j-1]);
        }
      }
    }
    return lookupTable[A.length()][B.length()];
  }


  public static void main(String[] args) {
    int res = maxLCS(A, B, A.length(), B.length());
    System.out.println("OUTPUT="+res);

    res = maxLCSWithMemoization(A, B, A.length(), B.length());
    System.out.println("OUTPUT="+res);

    res = maxLCSBottomUp(A, B);
    System.out.println("OUTPUT="+res);
  }
}
