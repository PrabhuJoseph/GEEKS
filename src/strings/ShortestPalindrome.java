package strings;

public class ShortestPalindrome {
  private static boolean isPalindrome(final String input) {
    String reverse = new StringBuilder(input).reverse().toString();
    return input.equals(reverse);
  }

  public static String getShortestPalindrome(final String input) {
    int longest = Integer.MIN_VALUE;
    String s = "";
    for (int i=0; i<input.length(); i++) {
      String substr = input.substring(i);
      System.out.println(substr);
      if (isPalindrome(substr)) {
        if (longest < substr.length()) {
          longest = substr.length();
          s = input.substring(0, i) + substr + new StringBuilder(input.substring(0, i)).reverse();
          System.out.println("OUT:"+s);
        }
      }
    }

    for (int i=0; i<input.length(); i++) {
      String substr = input.substring(0, i+1);
      System.out.println(substr);
      if (isPalindrome(substr)) {
        if (longest < substr.length()) {
          longest = substr.length();
          s = new StringBuilder(input.substring(i+1)).reverse() + substr + input.substring(i+1);
          System.out.println("OUT:"+s);
        }
      }
    }

    return s;
  }

  public static void main(String[] args) {
    String input = "abbacd";
    String ans = getShortestPalindrome(input);
    System.out.println("Shortest Palindrome: " + ans);
  }
}
