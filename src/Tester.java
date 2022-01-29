import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Tester {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        if (h<=0 && h>12) {
            throw new IllegalArgumentException("Given hour is wrong");
        }
        if (m <0 && m>=60) {
            throw new IllegalArgumentException("Given minute is wrong");
        }

        String nums[] = { "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty", "twenty one",
                "twenty two", "twenty three", "twenty four",
                "twenty five", "twenty six", "twenty seven",
                "twenty eight", "twenty nine",
        };

        if (m == 0) {
            return nums[h] + " o' clock";
        } else if (m < 10) {
            return nums[m] + " minute past " + nums[h];
        } else if (m == 15) {
            return nums[m] + " minutes past " + nums[h];
        } else if (m < 30) {
            return nums[m] + " minutes past " + nums[h];
        } else if (m == 30) {
            return "half past " + nums[h];
        } else if (m == 45) {
            return "quarter to " + nums[h+1];
        } else if (m < 60) {
            int rem = 60 - m;
            if (rem < 10) {
                return nums[rem] + " minute to " + nums[h+1];
            } else {
                return nums[rem] + " minutes to " + nums[h+1];
            }
        }
        throw new IllegalArgumentException("Invalid input");
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Tester.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
