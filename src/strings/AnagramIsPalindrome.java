package strings;

import java.util.Arrays;

public class AnagramIsPalindrome {

  static final int NO_OF_CHARS = 256;

  // https://www.geeksforgeeks.org/check-anagram-string-palindrome-not/

  static boolean isPalindrome(String input) {
    int[] counters = new int[NO_OF_CHARS];
    for (Character c : input.toCharArray()) {
      counters[c]++;
    }
    int oddChars = 0;
    for (int c : counters) {
      if (c%2 != 0) {
        oddChars++;
      }
      if (oddChars > 1) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String input = "geeksforgeeks";
    System.out.println(isPalindrome(input));
  }

}
