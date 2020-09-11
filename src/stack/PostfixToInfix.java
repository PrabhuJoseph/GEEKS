package stack;

import java.util.Stack;

public class PostfixToInfix {
  // https://www.youtube.com/watch?v=vS_lYbc6BUk


  /*
  Postfix: ab+c*

  Infix: ((a+b)*c)
   */

  private static boolean isOperand(char x) {
    return (x >= 'a' && x <= 'z') ||
        (x >= 'A' && x <= 'Z');
  }

  private static String postfixToInfix(String exp) {
    Stack<String> stack = new Stack<String>();
    String result = "";
    for (Character cur : exp.toCharArray()) {
      if (isOperand(cur)) {
        stack.push(cur+"");
      } else {
        String op2 = stack.pop();
        String op1 = stack.pop();
        stack.push("(" + op1 + cur + op2 + ")");
      }
    }
    return stack.peek();
  }

  public static void main(String[] args) {
    String exp = "a+b*(c^d-e)^(f+g*h)-i";
    // exp = "a+b";
    exp = "ab+c*";
    System.out.println(postfixToInfix(exp));
  }
}
