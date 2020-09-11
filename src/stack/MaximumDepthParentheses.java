package stack;

import java.util.HashMap;
import java.util.Stack;

public class MaximumDepthParentheses {

    static Stack<Character> stack = new Stack<>();

    public static int maxDepth(String s) {
        int max = 0;
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            Character cur = s.charAt(i);
            if (cur == '(') {
                count++;
                if (max < count) {
                    max = count;
                }
            } else if (cur == ')'){
                count--;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        String s = "( ((X)) (((Y))) )";
        //String s = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
        //String s = "( p((q)) ((s)t) )";
        System.out.println(maxDepth(s));
    }
}
