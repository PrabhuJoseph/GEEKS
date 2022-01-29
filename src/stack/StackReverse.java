package stack;

import java.util.Iterator;
import java.util.Stack;
public class StackReverse {

    private static Stack<Character> reverse(Stack<Character> stack) {
      Stack<Character> reverse = new Stack<>();
      int size = stack.size();
      for (int i=0; i<size; i++) {
        Character cur = stack.pop();
        reverse.push(cur);
      }
      return reverse;
    }

    public static void main(String[] args) {
       Stack<Character> stack = new Stack<>();
       stack.push('a');
       stack.push('b');
       stack.push('c');
       stack.push('d');

       System.out.println("INPUT STACK");
       Iterator<Character> itr = stack.iterator();
       while (itr.hasNext()) {
         System.out.println(itr.next());
       }

       Stack<Character> rev = reverse(stack);
       System.out.println("OUTPUT STACK");
       itr = rev.iterator();
       while (itr.hasNext()) {
         System.out.println(itr.next());
       }
    }
}
