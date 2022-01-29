package numbers;

// https://www.youtube.com/watch?v=3QJzHqNAEXs

import java.util.Stack;

public class BuildLowestNumRemovingKDigits {
  private static String buildLowNum(String num, int k) {
    Stack<Integer> stack = new Stack<>();
    for (Character c : num.toCharArray()) {
      int curNum = Integer.parseInt(c + "");
      // Step 1: Remove maxima - wherever there is a dip
      while (!stack.empty() && stack.peek()>curNum && k>0) {
        stack.pop();
        k--;
      }
      // Step 2: Don't insert if leading zero
      if (!(stack.empty() && curNum==0)) {
        stack.push(curNum);
      }
    }
    // Step 3: Remove from back if still k>0
    while (k>0 && !stack.empty()) {
      stack.pop();
      k--;
    }

    // Step 4: Construct number from Stack
    String res = "";
    while (!stack.empty()) {
      res = stack.pop() + res;
    }
    return res;
  }

  public static void main(String[] args) {
    String num = "123456";
    int k=2;
    System.out.println("Lowest Number is: " + buildLowNum(num, k));
  }
}
