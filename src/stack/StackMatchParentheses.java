package stack;

import java.util.Stack;

public class StackMatchParentheses {

  static Stack<Character> stack = new Stack<>();

  public static boolean isBalanced(char[] exp) {
    for (int i=0; i<exp.length; i++) {
      Character next = exp[i];
      if (next == '{' || next == '(' || next == '[') {
        stack.push(exp[i]);
      } else if (next == '}' || next == ')' || next == ']') {
          if (stack.size() == 0) {
            return false;
          }
          Character cur = stack.pop();
          if (!((next == '}' && cur == '{') || (next == ')' && cur == '(') || (next == ']' && cur == '['))) {
            return false;
          }
      }
    }
    return stack.size() == 0;
  }

  public static void main(String[] args) {
    //char exp[] = {'{','(',')','}','[',']'};
    //char exp[] = {'{','(',')','}','[',']','{',')'};
    char exp[] = {'{','(',')','}','[',']',')'};
    System.out.println(isBalanced(exp));
  }
}
