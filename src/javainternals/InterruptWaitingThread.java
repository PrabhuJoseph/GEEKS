package javainternals;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InterruptWaitingThread {

  static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();

  public static Runnable createRunnable() {

    return new Runnable() {
      public void run() {
        try {
          queue.take();
        } catch (Exception e) {
          System.out.println("EXCEPTION");
          e.printStackTrace();
        }
      }

      ;
    };
  }

  public static void main(String[] args) throws Exception {


    ExecutorService executor = Executors.newSingleThreadExecutor();
    executor.execute(createRunnable());

    Thread.sleep(2000);
    executor.shutdownNow();
    executor.awaitTermination(2000L, TimeUnit.MILLISECONDS);


  }

}
