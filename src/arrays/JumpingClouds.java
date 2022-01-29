package arrays;

public class JumpingClouds {

  static int jumpingOnClouds(int[] c) {
    int jumps = 0;
    for (int i=0; i<c.length;) {
      System.out.println("I="+i);
      jumps++;
      if (i+2 < c.length && c[i+2] == 0) {
          i = i+2;
      } else {
          i++;
      }
    }

    return jumps-1;
  }

  public static void main(String[] args) {
    int[] clouds = new int[] {0,0,0,0,1,0};
    System.out.println(jumpingOnClouds(clouds));
  }
}
