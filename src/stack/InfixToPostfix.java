package stack;

import java.util.Stack;

public class InfixToPostfix {

  // https://www.youtube.com/watch?v=vXPL6UavUeA

  /*
  Infix: ((a+b)*c)

  Postfix: ab+c*

   */

  private static int getPrecedence(Character character) {
    switch (character) {
      case '+' :
      case '-' :
        return 1;
      case '*' :
      case '/' :
        return 2;
      case '^' :
        return 3;
    }
    return -1;
  }

  private static String infixToPostfix(String exp) {
    Stack<Character> stack = new Stack<>();
    String result = "";
    for (Character cur : exp.toCharArray()) {
      if (Character.isLetterOrDigit(cur)) {
        result += cur;
      } else if (cur.equals('(')) {
        stack.push(cur);
      } else if (cur.equals(')')) {
        while (!stack.isEmpty() && stack.peek() != '(') {
          result += stack.pop();
        }
        stack.pop();
      } else {
        while (!stack.isEmpty() && getPrecedence(cur) <= getPrecedence(stack.peek())) {
          result += stack.pop();
        }
        System.out.println("CUR="+cur);
        stack.push(cur);
      }
    }
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    return result;
  }

  public static void main(String[] args) {
    String exp = "a+b*(c^d-e)^(f+g*h)-i";
    // exp = "a+b";
    exp = "((a+b)*c)";
    System.out.println(infixToPostfix(exp));
  }
}
