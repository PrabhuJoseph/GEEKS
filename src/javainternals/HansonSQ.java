package javainternals;

import java.util.concurrent.Semaphore;

public class HansonSQ {

    Integer item = null;

    Semaphore send = new Semaphore(1);
    Semaphore sync = new Semaphore(0);
    Semaphore recv = new Semaphore(0);

    public Integer take() throws Exception {
        recv.acquire();
        Integer x = this.item;
        sync.release();
        send.release();
        return x;
    }

    public void put(Integer x) throws Exception {
        send.acquire();
        item = x;
        recv.release();
        sync.acquire();
    }

    public static void main(String[] args) throws Exception {
        HansonSQ hansonSQ = new HansonSQ();
        Thread consumer = new Thread() {
            public void run() {
                try {
                    System.out.println("TAKE ELEMENT");
                    int e = hansonSQ.take();
                    System.out.println("TOOK ELEMENT="+e);
                } catch (Exception e) {

                }
            }
        };
        consumer.start();

        Thread producer = new Thread() {
            public void run() {
                try {
                    System.out.println("PUT ELEMENT");
                    hansonSQ.put(100);
                    System.out.println("PUT ELEMENT DONE");
                } catch (Exception e) {

                }
            }
        };
        producer.start();
    }

}
