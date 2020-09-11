package dynamicprogramming;

import java.util.Arrays;
import java.util.List;


// https://www.techiedelight.com/word-break-problem/

public class WordBreakProblem {


    public static void wordBreak(String str, String out, List<String> dict) {
        if (str.length() == 0) {
            System.out.println(out);
        }
        for (int i=1; i<=str.length(); i++) {
            String s = str.substring(0, i);
            if (dict.contains(s)) {
                wordBreak(str.substring(i), out + " " + s, dict);
            }
        }
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("this", "th", "is", "famous", "Word",
                "break", "b", "r", "e", "a", "k", "br",
                "bre", "brea", "ak", "problem");


        String str = "Wordbreakproblem";
        wordBreak(str, "", dict);
    }
}
