package dynamicprogramming;

import java.util.Arrays;
import java.util.List;


// https://www.techiedelight.com/word-break-problem/

public class WordBreakProblem {


    public static void wordBreak(String str, String out, List<String> dict) {
        if (str.length() == 0) {
            System.out.println(out);
        }
        for (int i=1; i<=str.length(); i++) {
            String s = str.substring(0, i);
            if (dict.contains(s)) {
                wordBreak(str.substring(i), out + " " + s, dict);
            }
        }
    }



    public static boolean isBreakable(String word,
        List<String> dict) {
      boolean[][] dp = new boolean[word.length()][word.length()];

      for (int level=1; level<=word.length(); level++) {
        for (int i=0; i<=word.length()-level; i++) {
          System.out.println(i + "---" + (i+level-1) + "---" + word.substring(i, i+level));
          if (dict.contains(word.substring(i, i+level))) {
            dp[i][i+level-1] = true;
          } else {
            for (int k=i; k<i+level-1; k++) {
              if (dp[i][k] && dp[k+1][i+level-1]) {
                dp[i][i+level-1] = true;
              }
            }
          }
        }
      }

      for (int i=0; i<dp.length; i++) {
        for (int j=0; j<dp.length; j++) {
          System.out.print(dp[i][j] + "\t");
        }
        System.out.println();
      }

      return dp[0][word.length()-1];
    }


    public static void main(String[] args) {
        List<String> dict = Arrays.asList("this", "th", "is", "famous", "Word",
                "break", "b", "r", "e", "a", "k", "br",
                "bre", "brea", "ak", "problem");

        String str = "Wordbreakproblem";
        wordBreak(str, "", dict);
        dict = Arrays.asList("I", "AM");
        System.out.println(isBreakable("IAM", dict));
    }
}
