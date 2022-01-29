package hackerrank;

import java.util.Stack;

public class MaxIndexProduct {
  public static void main(String[] args) {
    int[] arr = {5,4,3,4,2};
    int[] lefti = new int[arr.length];
    int[] righti = new int[arr.length];
    Stack<Integer> stack = new Stack<>();

    for (int i=0; i<arr.length; i++) {
      while (!stack.empty() && arr[stack.peek()] <= arr[i])
        stack.pop();
      if (!stack.empty()) {
        lefti[i] = stack.peek() + 1;
      }
      stack.push(i);
    }

    stack.clear();
    for (int i=arr.length-1; i>=0; i--) {
      while (!stack.empty() && arr[stack.peek()] <= arr[i])
        stack.pop();
      if (!stack.empty()) {
        righti[i] = stack.peek() + 1;
      }
      stack.push(i);
    }

    for (int x : lefti) {
      System.out.println(x);
    }

    for (int x : righti) {
      System.out.println(x);
    }

    int max = Integer.MIN_VALUE;
    for (int i=0; i<arr.length; i++) {
      max = Math.max(max, lefti[i] * righti[i]);
    }
    System.out.println(max);
 }
}
