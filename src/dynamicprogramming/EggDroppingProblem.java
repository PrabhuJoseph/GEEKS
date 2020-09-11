package dynamicprogramming;

public class EggDroppingProblem {

  // https://www.youtube.com/watch?v=3hcaVyX00_4


  public static int calculateRecursive(int eggs, int floors) {
    if (eggs == 1) {
      return floors;
    }
    if (floors == 0) {
      return 0;
    }

    int min = Integer.MAX_VALUE;
    for (int i=1; i<=floors; i++) {
      int res = 1 + Math.max(calculateRecursive(eggs-1, i-1), calculateRecursive(eggs, floors-i));
      min = Math.min(min, res);
    }
    return min;
  }


  public static int calaculateBottomUP(int eggs, int floors) {
    int[][] temp = new int[eggs+1][floors+1];
    // From any floor, with one egg the max attempt = floor (i)
    for (int i=0; i<=floors; i++) {
      temp[1][i] = i;
    }

    for (int e=2; e<=eggs; e++) {
      for (int f=1; f<=floors; f++) {
        temp[e][f] = Integer.MAX_VALUE;
        for (int k=1; k<=f; k++) {
          int c = 1 + Math.max(temp[e-1][k-1], temp[e][f-k]);
          temp[e][f] = Math.min(temp[e][f], c);
        }
      }
    }
    return temp[eggs][floors];
  }



  public static void main(String[] args) {


    /*
    4 Floors, 2 Eggs = 3 Attempts => start one egg at 3rd floor, it it does not break (3 to 1) = max 3 attempts

    3 Floors, 2 Eggs = 2 Attempts => start one egg at 2nd Floor, it it breaks / does not break = one more floor left = max 2 attempts

Eggs Floors Attempts

1 1 => 1

1 2 => 2

1 3 => 3

1 4 => 4


2 1 => 1

2 2 => 2

2 3 => 2

2 4 => 3

2 5 => 3

2 6 => 4

2 7 => 4

2 8 => 4

     */

    int floors = 7;
    int eggs = 2;
    int maxAttempts = calculateRecursive(eggs, floors);
    System.out.println("MAX ATTEMPTS to break egg using Recursion(Top Down): " + maxAttempts);
    maxAttempts = calaculateBottomUP(eggs, floors);
    System.out.println("MAX ATTEMPTS to break egg Using Bottom Up: " + maxAttempts);
  }
}
