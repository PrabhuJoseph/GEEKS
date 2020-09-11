package stack;

import java.util.Stack;

public class PostfixEvaluate {
  // https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/

  /*

  Infix to PostFix

  A+B => AB+

  A+B*C => ABC*+

  Postfix Evaluate

   */

  private static int evaluatePostfix(String exp) {
    Stack<Integer> stack = new Stack<>();

    for (Character cur : exp.toCharArray()) {
      if (Character.isLetterOrDigit(cur)) {
        stack.push(cur-'0');
      } else {
        int val1 = stack.pop();
        int val2 = stack.pop();
        switch (cur) {
          case '*':
            stack.push(val2 * val1);
            break;
          case '/':
            stack.push(val2 / val1);
            break;
          case '+':
            stack.push(val2 + val1);
            break;
          case '-':
            stack.push(val2 - val1);
            break;
          case '^':
            stack.push(val2 ^ val1);
            break;
        }
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) {
    String exp="231*+9-";
    System.out.println("Evaluated Result: " + evaluatePostfix(exp));
  }
}
