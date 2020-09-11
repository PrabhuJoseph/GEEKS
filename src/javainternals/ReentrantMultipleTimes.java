package javainternals;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantMultipleTimes {

  private static ReentrantLock lock = new ReentrantLock();

  private static void reentrantLock() {
    Thread t = new Thread() {
      @Override
      public void run() {
        lock.lock();
        lock.lock();
        lock.unlock();
      }
    };
    t.start();
    // This won't get lock as previous thread still has lock
    lock.lock();
  }

  private void recursiveSynchronized(int i) {
    synchronized (this) {
      System.out.println(i);
      if (i>0)
      recursiveSynchronized(i-1);
    }
  }


  public static void main(String[] args) throws InterruptedException {
    //reentrantLock();
    new ReentrantMultipleTimes().recursiveSynchronized(10);

    Object obj = new Object();
    synchronized (obj) {
      synchronized (obj) {
        System.out.println("MULTIPLE SYNCH WORKS");
      }
    }

  }

}
