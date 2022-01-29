package stack;

import java.util.Iterator;
import java.util.Stack;

public class SortRecursion {

    public static void sortedInsert(Stack<Integer> stack, int element) {
        if (stack.size() == 0 || stack.peek() > element) {
            stack.push(element);
        } else {
            int cur = stack.pop();
            sortedInsert(stack, element);
            stack.push(cur);
        }
    }

    public static void sort(Stack<Integer> stack) {
        if (stack.size() > 0) {
            int s = stack.pop();
            sort(stack);
            sortedInsert(stack, s);
        }
    }


    public static void main(String[] args) {
      Stack<Integer> stack = new Stack();
      stack.push(10);
      stack.push(30);
      stack.push(50);
      stack.push(20);
      stack.push(40);

      sort(stack);

      Iterator<Integer> stackItr = stack.iterator();

      while (stackItr.hasNext()) {
          System.out.println(stackItr.next());
      }


    }
}
