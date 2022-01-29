package strings;

public class FindMissingNumber {
  // https://www.geeksforgeeks.org/find-missing-number-string-numbers-no-separator/

    public static int findMissingNumber(String input) {
      int maxLen = input.length();
      for (int i=1; i<maxLen/2; i++) {
        int start = 0;

        boolean missingFound = false;
        String missingNumber = "";

        int curNumber = Integer.parseInt(input.substring(start, i));
        start = i;

        while (start < input.length()) {
          String next = (curNumber + 1) + "";
          String subqnext = (curNumber + 2) + "";

          // Move to Next Number
          String nextNumber = input.substring(start, start + next.length());
          if (nextNumber.equals(next + "")) {
            start = start + nextNumber.length();
            curNumber = Integer.parseInt(nextNumber);
            continue;
          }

          // Check if Missing Number
          if (missingFound) {
           break;
          }

          missingNumber = input.substring(start, start + subqnext.length());
          if (missingNumber.equals(subqnext + "")) {
            start = start + missingNumber.length();
            curNumber = Integer.parseInt(missingNumber);
            missingFound = true;
          }
          break;
        }
        if (missingFound && start >= input.length()) {
         return Integer.parseInt(missingNumber) - 1;
        }
      }
      return -1;
    }

    public static void main(String[] args) {
        //String input = "111112113115";
        String input = "12345679";
        System.out.println("OUTPUT=" + findMissingNumber(input));
    }
}
