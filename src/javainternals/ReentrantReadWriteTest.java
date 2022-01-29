package javainternals;

import java.util.concurrent.locks.ReentrantReadWriteLock;


// 1. Only one writer can get writelock
// 2. Multiple reader can have read lock
// 3. Writer with writelock can get read lock but have to unlock both locks.

public class ReentrantReadWriteTest {

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    private static String message = "a";

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new Read());
        Thread t2 = new Thread(new WriteA());
        Thread t3 = new Thread(new WriteB());

        t1.setPriority(10);
        t2.setPriority(1);
        t3.setPriority(1);

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }

    static class Read implements Runnable {

        public void run() {
            for(int i = 0; i<= 10; i ++) {
                if(lock.isWriteLocked()) {
                    System.out.println("I'll take the lock from Write");
                }
                System.out.println("READ ATTEMPT");
                lock.readLock().lock();
                System.out.println("ReadThread " + Thread.currentThread().getId() + " ---> Message is " + message );
                lock.readLock().unlock();
            }
        }
    }

    static class WriteA implements Runnable {

        public void run() {
            for(int i = 0; i<= 10; i ++) {
                try {
                    System.out.println("WRITE ATTEMPT");
                    lock.writeLock().lock();
                    message = message.concat("a");
                    lock.readLock().lock();
                    System.out.println("WriteThread " + Thread.currentThread().getId() + " ---> Message is " + message );
                    lock.readLock().unlock();
                } finally {
                    lock.writeLock().unlock();
                }
            }
        }
    }

    static class WriteB implements Runnable {

        public void run() {
            for(int i = 0; i<= 10; i ++) {
                try {
                    lock.writeLock().lock();
                    message = message.concat("b");
                } finally {
                    lock.writeLock().unlock();
                }
            }
        }
    }
}