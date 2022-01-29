package javainternals;

import java.util.function.Function;

public class LambdaFunction {

  private static <T,R> R executeFunction(Function<T, R> func, T input) {
      R r =  func.apply(input);
      return r;
  }

  public static void main(String[] args) {
    Function<String, Boolean> equals = (String input) -> {
        boolean ret = input.equals("PRABHU");
        return ret;
    };

    boolean ret = executeFunction(equals, "PRABHU");
    System.out.println("OUTPUT="+ret);
  }

}
