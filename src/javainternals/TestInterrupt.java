package javainternals;

public class TestInterrupt {

  public static void main(String[] args) throws Exception {

    /*

    Below can be interrupted:

    Thread.sleep

    Below can't:

    any other java operations including thread io, http requests or below

     */
    Thread t = new Thread() {
      @Override
      public void run() {
        while (!Thread.currentThread().isInterrupted()) {
              for (;;) {
                  int j=1;
                  j++;
                  j--;
              }
        }
      }
    };
    t.start();
    Thread.sleep(1000);
    t.interrupt();
  }
}
