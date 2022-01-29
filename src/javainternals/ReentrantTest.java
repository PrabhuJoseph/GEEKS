package javainternals;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class ReentrantTest {

   int MAX_SIZE = 3;
   Stack<Integer> stack = new Stack();

   ReentrantLock lock = new ReentrantLock();
   Condition isFull = lock.newCondition();
   Condition isEmpty = lock.newCondition();

   public void put(int element) throws Exception {
     lock.lock();
     try {
         if (stack.size() == MAX_SIZE) {
             isFull.await();
         }
         stack.push(element);
         isEmpty.signalAll();
     } finally {
       lock.unlock();
     }
   }

   public int take() throws Exception {
     lock.lock();
     try {
         if (stack.size() == 0) {
             isEmpty.await();
         }
         int x = stack.pop();
         isFull.signalAll();
         return x;
     } finally {
       lock.unlock();
     }

   }

   static class Producer extends Thread {
     ReentrantTest t;
     String name;

     Producer(ReentrantTest t, String name) {
       this.t = t;
       this.name = name;
     }

     public void run() {
       try {
         for (int i=0; i<10000; i++) {
           int element = ThreadLocalRandom.current().nextInt(1, 1000);
           System.out.println("PUT " + element + "by "+ name);
           t.put(element);
         }
       } catch (Exception e) {
         System.out.println("ERROR="+e.getMessage());
       }
     }
   }

   static class Consumer extends Thread {
     ReentrantTest t;
     String name;

     Consumer(ReentrantTest t, String name) {
       this.t = t;
       this.name = name;
     }

     public void run() {
       try {
         for (int i=0; i<10000; i++) {
             System.out.println("GET " + t.take() + "by " + name);
         }
       } catch (Exception e) {
         System.out.println("ERROR="+e.getMessage());
         e.printStackTrace();
       }
     }
   }

    public static void main(String[] args) {

     ReentrantTest test = new ReentrantTest();

     Producer p1 = new Producer(test, "p1");
     Producer p2 = new Producer(test, "p2");
     Consumer c1 = new Consumer(test, "c1");
     Consumer c2 = new Consumer(test, "c2");

     p1.start();
     p2.start();
     c1.start();
     c2.start();
   }
}
