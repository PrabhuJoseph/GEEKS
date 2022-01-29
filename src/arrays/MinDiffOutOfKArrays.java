package arrays;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinDiffOutOfKArrays {

    public static int minDiffOfKArray(int K, int N, int[][] karrays) {
        int kptrs[] = new int[K];
        int mindiff = Integer.MAX_VALUE;
        int br = 0;
        int prev = -1;
        int cur = -1;
        while (true) {
            int min_index = -1;
            int min = Integer.MAX_VALUE;
            for (int j=0; j<kptrs.length; j++) {
                System.out.println("PTR="+kptrs[j]+"---"+j);
                if (kptrs[j] < K) {
                    System.out.println("ELEMENT="+karrays[j][kptrs[j]]);
                }
                if (kptrs[j]<K && karrays[j][kptrs[j]] < min) {
                    min = karrays[j][kptrs[j]];
                    System.out.println("MIN="+ min);
                    min_index = j;
                }
            }
            kptrs[min_index]++;
            System.out.println("PREV="+prev);
            if (prev == -1) {
              prev = min;
            } else {
              cur = min;
              System.out.println("PREV="+prev+"---CUR="+cur);
              mindiff = Math.min(mindiff, Math.abs(prev - cur));
              prev = cur;
            }
            br++;
            if (br >= 8)  {
                break;
            }
        }
        return mindiff;
    }


    public static void main(String args[]) {
        int K = 3;
        int N = 3;
        int[][] karrays = new int[K][N];
        karrays[0] = new int[]{1, 8, 11};
        karrays[1] = new int[]{2, 4, 7};
        karrays[2] = new int[]{3, 5, 6};
        System.out.println("MIN DIFF: " + minDiffOfKArray(K, N, karrays));
    }
}

