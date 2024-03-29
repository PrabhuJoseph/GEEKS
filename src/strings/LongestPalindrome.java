package strings;

/*

  https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/

  https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/

 */
public class LongestPalindrome {
  public static boolean isPalindrome(char[] str) {
    String inputStr = new String(str);
    StringBuilder rev = new StringBuilder(inputStr);
    rev.reverse();
    if (inputStr.equals(rev.toString())) {
      System.out.println(inputStr);
    }
    return inputStr.equals(rev.toString());
  }

  private static boolean isPalindrome(char[] in, char[] out, int i, int n, int index, int k) {
    if (index==k) {
      return isPalindrome(out);
    }
    if (i >= n) {
      return false;
    }
    out[index] = in[i];
    return isPalindrome(in, out, i+1, n, index+1, k) || isPalindrome(in, out, i+1, n, index, k);
  }

  public static int longestPalindrome(char[] str) {
    for (int i=str.length; i>0; i--) {
      if (isPalindrome(str, new char[i], 0, str.length, 0, i)) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    String input = "forgeeksskeegfor";

    // Longest Palindrome is = acdeedca
    System.out.println("LONGEST PALINDROME="+longestPalindrome(input.toCharArray()));
  }
}
