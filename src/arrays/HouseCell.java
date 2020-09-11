package arrays;

import java.util.ArrayList;
import java.util.List;

public class HouseCell {

    /*

    https://www.geeksforgeeks.org/active-inactive-cells-k-days/

    Given a binary array of size n where n > 3. A true (or 1) value in the array means active and false (or 0) means inactive.
    Given a number k, the task is to find count of active and inactive cells after k days. After every day, status of i’th cell becomes
    active if left and right cells are not same and inactive if left and right cell are same (both 0 or both 1).
    Since there are no cells before leftmost and after rightmost cells, the value cells before leftmost and after rightmost cells is
    always considered as 0 (or inactive).
    */

    private static void copyArray(int[] src, int[] dest) {
      for (int i=0; i<src.length; i++) {
        dest[i] = src[i];
      }
    }

    public List<Integer> cellCompete(int[] states, int days) {
        int[] src = states;
        int[] dest = states;
        for (int i = 0; i < days; i++) {
            dest = new int[src.length];
            copyArray(src, dest);
            for (int j = 0; j < src.length; j++) {
                if (j == 0) {
                    if (src[1] == 0) {
                        dest[j] = 0;
                    } else {
                        dest[j] = 1;
                    }
                } else if (j > 0 && j < src.length - 1) {
                    if (src[j - 1] == src[j + 1]) {
                        dest[j] = 0;
                    } else {
                        dest[j] = 1;
                    }

                } else {
                    if (src[j] == 0) {
                        dest[j] = 0;
                    } else {
                        dest[j] = 1;
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int x : dest) {
          list.add(x);
        }
        return list;
    }

}
