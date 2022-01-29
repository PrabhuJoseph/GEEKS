package javainternals;

public class ObjectWait {

    static Object obj = new Object();
    static Integer element = null;

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            public void run() {
                try {
                    synchronized (obj) {
                        if (element == null) {
                            obj.wait();
                        }
                    }
                    System.out.println("OUT=" + element);
                } catch (Exception e) {
                    System.out.println("Error:" + e.getMessage());
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                try {
                    synchronized (obj) {
                        element = 100;
                        obj.notify();
                    }
                } catch (Exception e) {
                    System.out.println("Error:" + e.getMessage());
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        t2.start();


    }
}
