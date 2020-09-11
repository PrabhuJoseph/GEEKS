package javainternals;

public class DaemonThread {

  public static void main(String[] args) {

    Thread t = new Thread() {
      public void run() {
        while (true) {
          try {
              System.out.println("RUNNING");
              Thread.sleep(1000);
          } catch (Exception e) {
            System.out.println("EXCEPTION");
            e.printStackTrace();
          }
        }
      }
    };

    /*
    Daemon thread is a low priority thread that runs
    in background to perform tasks such as garbage collection.
    Properties: They can not prevent the JVM from exiting when all the user threads
    finish their execution.
     */

    t.setDaemon(true);
    t.start();
  }
}
