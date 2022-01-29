package arrays.deeper;

public class CheckIfArrayElementsAreConsecutive {

  public boolean areConsecutive(int input[]) {
    int min = Integer.MAX_VALUE;
    int sum = 0;
    for (int i = 0; i < input.length; i++) {
      if (input[i] < min) {
        min = input[i];
      }
      sum += input[i];
    }
    int n = input.length;
    int ap_sum = (2 * min + (n - 1)) * (n / 2);
    return ap_sum == sum;
  }

  public static void main(String[] args) {
    int input[] = {76,78,77,73,74, 79};
    CheckIfArrayElementsAreConsecutive obj = new CheckIfArrayElementsAreConsecutive();
    System.out.println(obj.areConsecutive(input));
  }
}
