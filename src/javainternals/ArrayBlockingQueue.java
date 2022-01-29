package javainternals;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueue<T> {

  ReentrantLock putLock = new ReentrantLock();
  Condition notFull = putLock.newCondition();

  ReentrantLock takeLock = new ReentrantLock();
  Condition notEmpty = takeLock.newCondition();

  AtomicInteger count = new AtomicInteger(0);
  Object[] items;

  int putIndex = 0;
  int takeIndex = 0;

  ArrayBlockingQueue(int count) {
    items = new Object[count];
  }

  public void put(T x) throws InterruptedException {
    boolean signalNotEmpty = false;
    putLock.lock();
    int c = 0;
    try {
      while (count.get() == items.length) {
        notFull.await();
      }
      if (putIndex == items.length) {
        putIndex = 0;
      }
      items[putIndex++] = x;
      c = count.getAndIncrement();
    } finally {
      putLock.unlock();
      if (c==0) {
        signalNotEmpty();
      }
    }
  }

  public void signalNotEmpty() {
    takeLock.lock();
    try {
      notEmpty.signalAll();
    } finally {
      takeLock.unlock();
    }
  }

  public void signalNotFull() {
    putLock.lock();
    try {
      notFull.signalAll();
    } finally {
      putLock.unlock();
    }
  }

  public T take() throws InterruptedException {
    takeLock.lock();
    T x;
    int c = 0;
    try {
      while (count.get() == 0) {
        notEmpty.await();
      }
      if (takeIndex == items.length) {
        takeIndex = 0;
      }
      x = (T) items[takeIndex++];
      c = count.getAndDecrement();
      return x;
    } finally {
      takeLock.unlock();
      if (c == items.length) {
        signalNotFull();
      }
    }
  }

  public static void main(String[] args) {
    ArrayBlockingQueue<Long> queue = new ArrayBlockingQueue(3);
    Thread producer = new Thread() {
      public void run() {
        try {
          long x = 0;
          for (;;) {
            x = x + 1;
            queue.put(x);
            System.out.println("Put="+x);
          }
        } catch (InterruptedException e) {
          System.err.println("Producer thread is interrupted: " + e.getMessage());
        }
      }
    };

    Thread consumer = new Thread() {
      public void run() {
        try {
          long x = 0;
          for (; ; ) {
            x = queue.take();
            System.out.println("Took="+x);
          }
        } catch (InterruptedException e) {
          System.err.println("Consumer thread is interrupted: " + e.getMessage());
        }
      }
    };

    producer.start();
    consumer.start();
  }
}
