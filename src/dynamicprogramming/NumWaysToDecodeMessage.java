package dynamicprogramming;

public class NumWaysToDecodeMessage {
  public static void main(String[] args) {
    String data = "1234";
    int numWays = decode(data, data.length());
    System.out.println("NumWays: " + numWays);
  }

  private static int decode(String data, int length) {
    String tempStr = data.substring(data.length() - length);
    System.out.println(tempStr);
    if (tempStr.equals("")) {
      return 1;
    }
    if (tempStr.startsWith("0")) {
      return 0;
    }
    if (tempStr.length() >= 2) {
      String twoDigits = tempStr.substring(0, 2);
      int num = Integer.parseInt(twoDigits);
      if (num <= 26) {
        return decode(data, length-1) + decode(data, length -2);
      } else {
        return decode(data, length-1);
      }
    } else {
      return decode(data, length-1);
    }
  }
}
