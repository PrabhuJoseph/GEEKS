package recursion;/*

https://www.hackerrank.com/rest/contests/master/challenges/password-cracker/hackers/divyam01986/download_solution

 */

import java.io.*;
import java.util.*;

public class Perms {


    // Refer Word Break Problem for another way usin Dynamic Programming

    public static String merge(List<String> res) {
        String out = "";
        for (String r : res) {
            out += r;
        }
        return out;
    }

    private static boolean isValidPass(String input, String pass, Set<String> dict, List<String> res) {
        for (int i=0;i<pass.length();i++) {
            String str = pass.substring(0, i+1);
            if (dict.contains(str)) {
              res.add(str);
              isValidPass(input, pass.substring(i+1, pass.length()), dict, res);
            }
        }

        if (merge(res).equals(input)) {
            return true;
        } else {
            if (res.size() >= 1)
            res.remove(res.size() -1);
            return false;
        }
    }

    public static void main(String[] args) {


                String[] wrds = {"abc", "defg", "de", "f"};
                String pass = "abcdefg";
                Set<String> dict = new HashSet<>();
                dict.addAll(Arrays.asList(wrds));
                List<String> res = new ArrayList<>();
                isValidPass(pass, pass,dict, res);
                if(res.isEmpty()){
                    System.out.println("WRONG PASSWORD");
                }else{
                    for(int i = 0; i < res.size(); i++){
                        System.out.print(res.get(i) + " ");
                    }
                    System.out.print('\n');
                }
    }
}