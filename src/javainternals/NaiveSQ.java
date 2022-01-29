package javainternals;

public class NaiveSQ {

    Integer item = null;

    boolean isPutting = false;

    public synchronized void put(int x) throws Exception {
        while (isPutting) {
            wait();
        }
        isPutting = true;
        item = x;
        notifyAll();
        while (item != null) {
            wait();
        }
        isPutting = false;
        notifyAll();
    }

    public synchronized int take() throws Exception {
        while (item == null) {
            wait();
        }
        int ret = item;
        item = null;
        notifyAll();
        return ret;
    }

    public static void main(String[] args) throws Exception {
        NaiveSQ naiveSQ = new NaiveSQ();

        Thread producer = new Thread() {
            public void run() {
                try {
                    System.out.println("PUT ELEMENT");
                    naiveSQ.put(100);
                    System.out.println("PUT ELEMENT DONE");
                } catch (Exception e) {

                }
            }
        };
        producer.start();

        Thread producer1 = new Thread() {
            public void run() {
                try {
                    System.out.println("PUT ELEMENT");
                    naiveSQ.put(200);
                    System.out.println("PUT ELEMENT DONE");
                } catch (Exception e) {

                }
            }
        };
        producer1.start();

        Thread.sleep(1000);

        Thread consumer = new Thread() {
            public void run() {
                try {
                    System.out.println("TAKE ELEMENT");
                    int e = naiveSQ.take();
                    System.out.println("TOOK ELEMENT="+e);
                } catch (Exception e) {

                }
            }
        };
        consumer.start();

        Thread consumer1 = new Thread() {
            public void run() {
                try {
                    System.out.println("TAKE ELEMENT");
                    int e = naiveSQ.take();
                    System.out.println("TOOK ELEMENT="+e);
                } catch (Exception e) {

                }
            }
        };
        consumer1.start();
    }

}
