package strings;

// https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/

// https://www.youtube.com/watch?v=UflHuQj6MVA

public class LongestPalindromeDynamicProgramming {

    // Driver program to test above functions
    public static void main(String[] args) {
      //String str = "forgeeksskeegfor";
      String str = "Geeks";
      System.out.println("Length is: " + longestPalSubstr(str));
    }

    private static int longestPalSubstr(String str) {
      int maxLength;
      if (str.length()>0) {
        maxLength = 1;
      } else {
        return 0;
      }
      boolean[][] table = new boolean[str.length()][str.length()];
      for (int i=0; i<str.length(); i++) {
        table[i][i] = true;
      }
      for (int i=0; i<str.length()-1; i++) {
        if (str.charAt(i) == str.charAt(i+1)) {
          table[i][i + 1] = true;
          maxLength = 2;
        }
      }
      for (int level=3; level<str.length(); level++) {
        for (int i=0; i<str.length()-level; i++) {
          if (table[i+1][i+level-1] && str.charAt(i) == str.charAt(i+level)) {
            table[i][i+level] = true;
            maxLength = level+1;
          }
        }
      }
      return maxLength;
    }
}

// This code is contributed by Sumit Ghosh
