package arrays;

import java.util.*;

class MinimumIncrDecrToSortArray
{

    /*
      J  1 2 3 4
    I
    0 1  0 1 2 3
    1 2  1 0 1 2
    2 1  1 1 2 3
    3 4  4 3 2 1
    4 3  6 4 2 2

    In Last Row, I=4 get minimum
     */

    static int getMinimumOps(Vector<Integer> ar) {
        int n = ar.size();
        int small = Collections.min(ar);
        int large = Collections.max(ar);

        int [][]dp = new int[n][large + 1];

        for (int j = small; j <= large; j++)
        {
            dp[0][j] = Math.abs(ar.get(0) - j);
        }

        for (int i = 1; i < n; i++)
        {
            int minimum = Integer.MAX_VALUE;
            for (int j = small; j <= large; j++)
            {
                minimum = Math.min(minimum, dp[i - 1][j]);
                dp[i][j] = minimum + Math.abs(ar.get(i) - j);
            }
        }

        for (int i=0; i<n;i++) {
            for (int j=small; j<=large; j++) {
                System.out.println("i="+i+"---"+j+"---"+dp[i][j]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = small; j <= large; j++)
        {
            ans = Math.min(ans, dp[n - 1][j]);
        }
        return ans;
    }


    public static void main(String[] args)
    {
        Integer []arr = { 1, 2, 1, 4, 3 };
        Vector<Integer> ar = new Vector<>(Arrays.asList(arr));
        System.out.println(getMinimumOps(ar));
    }
} 