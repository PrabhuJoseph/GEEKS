package javainternals;

import java.util.LinkedList;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.LinkedHashMap;

// https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html

public class JavaCollections {

  static class Data implements Comparable<Data> {
    int id;
    String name;
    public Data(int id, String name) {
      this.id = id;
      this.name = name;
    }

    @Override
    public boolean equals(Object o) {
      if (o instanceof Data) {
        return this.id == ((Data) o).id;
      }
      return false;
    }

    @Override
    public int hashCode() {
      return name.hashCode() + id * 31;
    }

    @Override
    public int compareTo(Data other) {
      if (this.id > other.id) {
        return 1;
      } else if (this.id < other.id) {
        return -1;
      } else {
        return this.name.compareTo(other.name);
      }
    }
  }

  // NO DUPLICATES + NO ORDERING
  public static void setExample() {
    Set<Integer> setA = new HashSet<>();
    setA.add(1000);
    setA.add(new Integer(1000));
    setA.add(new Integer(5000));

    System.out.println("SetA Size=" + setA.size());
  }

  // User Defined Types has to have hashCode() and equals()
  // Default Object equals() returns true only when this == obj i.e when same object
  public static void setUDFExample() {
    Set<Data> setA = new HashSet<>();
    setA.add(new Data(1, "Prabhu"));
    setA.add(new Data(2, "Joseph"));
    setA.add(new Data(3, "Prabhu"));
    setA.add(new Data(1, "Prabhu"));

    System.out.println("Set UDF Size=" + setA.size());
  }


  // Sorted Set - Comparable, Comparator
  public static void setSorted() {
    SortedSet<Data> setA = new ConcurrentSkipListSet<>();
    setA.add(new Data(3, "Prabhu"));
    setA.add(new Data(1, "Sachin"));
    setA.add(new Data(1, "Joseph"));

    System.out.println("***** COMPARABLE *******");
    for (Data data : setA) {
      System.out.println("DATA ID: " + data.id + "-" + data.name);
    }

    System.out.println("***** COMPARABLE - DESCENDING *******");
    for (Data data : ((ConcurrentSkipListSet<Data>) setA).descendingSet()) {
      System.out.println("DATA ID: " + data.id + "-" + data.name);
    }


    Comparator<Data> descComparator = new Comparator<Data>() {
      @Override
      public int compare(Data a, Data b) {
        if (a.id > b.id) {
          return -1;
        } else if (a.id < b.id) {
          return 1;
        } else {
          return b.name.compareTo(a.name);
        }
      }
    };

    System.out.println("***** COMPARATOR *******");
    SortedSet<Data> setB = new ConcurrentSkipListSet<>(descComparator);
    setB.add(new Data(3, "Prabhu"));
    setB.add(new Data(1, "Sachin"));
    setB.add(new Data(1, "Joseph"));

    for (Data data : setB) {
      System.out.println("DATA ID: " + data.id + "-" + data.name);
    }
  }


  // Navigable Set
  public static void setNavigable() {
    NavigableSet<Integer> navA = new TreeSet<>();
    navA.add(30);
    navA.add(50);
    navA.add(50);
    navA.add(10);
    navA.add(100);

    System.out.println("***** NAVIGABLE SET *******");
    System.out.println("LOWER ENTRY="+ navA.lower(50)); // If nothing, returns NULL
    System.out.println("FLOOR ENTRY="+ navA.floor(50));
    System.out.println("CEILING ENTRY="+ navA.ceiling(50));
    System.out.println("HIGHER ENTRY="+ navA.higher(50));
  }

  // ORDERED HASH SET - LinkedHashSet
  public static void testLinkedHashSet() {
    Set<Data> setA = new LinkedHashSet<>();
    setA.add(new Data(1, "Prabhu"));
    setA.add(new Data(2, "Joseph"));
    setA.add(new Data(2, "Joseph"));
    setA.add(new Data(3, "Prabhu"));

    System.out.println("***** LINKED HASH SET *******");
    for (Data data : setA) {
      System.out.println("DATA ID: " + data.id + "-" + data.name);
    }
  }

  public static void testDeque() {
    Deque<Integer> deque = new ArrayDeque<>();

    // or
    // Deque<Integer> deque1 = new LinkedList<>();

    deque.add(5);
    deque.addLast(10);
    deque.add(20);
    deque.addFirst(1);
    deque.addLast(50);

    System.out.println("***** DEQUE *******");
    for (int X : deque) {
      System.out.println(X);
    }
  }

  public static void testFIFOQueue() {
    Queue<Integer> fifo = new LinkedList<Integer>();
    fifo.offer(1);
    fifo.offer(2);

    System.out.println("***** QUEUE *******");
    System.out.println(fifo.peek());
    System.out.println(fifo.poll());
    System.out.println(fifo.poll());
    System.out.println(fifo.size());
  }

  public static void testPriorityQueue() {
    Comparator descComparator = new Comparator() {
      @Override
      public int compare(Object o1, Object o2) {
        Integer a = (Integer) o1;
        Integer b = (Integer) o2;

        if (a > b) {
          return -1;
        } else if (a < b) {
          return 1;
        } else {
          return 0;
        }
      }
    };

    Queue<Integer> pq = new PriorityQueue<>(descComparator);
    pq.offer(2);
    pq.offer(1);

    System.out.println("***** PRIORITY QUEUE *******");
    System.out.println(pq.peek());
    System.out.println(pq.poll());
    System.out.println(pq.poll());
    System.out.println(pq.size());
  }

  static class DelayData implements Delayed {
    long renewalTime;
    int id;
    public DelayData(long renewalTime, int id) {
      this.renewalTime = renewalTime;
      this.id = id;
    }

    @Override
    public long getDelay(TimeUnit unit) {
      long millisLeft = renewalTime - System.currentTimeMillis();
      return unit.convert(millisLeft, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed d) {
      DelayData other = (DelayData) d;
      return this.renewalTime > other.renewalTime ? 1 :
          (this.renewalTime < other.renewalTime ? -1 : 0);
    }
  }

  public static void testDelayQueue() throws Exception {
    DelayQueue<DelayData> dq = new DelayQueue<>();
    dq.offer(new DelayData(System.currentTimeMillis() + 3000, 3));
    dq.offer(new DelayData(System.currentTimeMillis() + 1000, 1));


    System.out.println("***** DELAY QUEUE *******");
    System.out.println(dq.take().id);
    System.out.println(dq.take().id);
    System.out.println(dq.size());
  }

  private static void traverseMap(Map map) {
    Iterator<Map.Entry<Integer, String>> playerEntry = map.entrySet().iterator();
    while (playerEntry.hasNext()) {
      Map.Entry<Integer, String> entry = playerEntry.next();
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }
  }

  public static void testHashMap() {
    Map<Integer, String> players = new HashMap<>();
    players.put(1, "Sachin");
    players.put(2, "Dravid");

    System.out.println("***** HASH MAP *******");
    System.out.println("ID 1: " + players.get(1));

    System.out.println("***** HASH MAP ITERATOR *******");
    traverseMap(players);
  }

  public static void testLinkedHashMap() {

    // CAN ALSO BE USED FOR LRU CACHE
    int MAX = 3;
    Map<Integer, String> players = new LinkedHashMap<Integer, String>(3, 0.75f, true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
        return size() > MAX;
      }
    };

    players.put(2, "Dravid");
    players.put(1, "Sachin");
    players.put(3, "Ganguly");
    players.put(4, "Virat");

    System.out.println("***** LINKED HASHMAP ITERATOR *******");
    traverseMap(players);

    players.get(1);
    traverseMap(players);
  }

  public static void main(String[] args) throws Exception {

    // NO DUPLICATES + NO ORDERING
    setExample();

    // User Defined Types has to have hashCode() and equals()
    setUDFExample();

    // SORTED SET - TreeSet, ConcurrentSkipListSet - Natural Ordering or Comparator - Ascending is default
    setSorted();

    // NAVIGABLE SET - TreeSet, ConcurrentSkipListSet
    setNavigable();

    // ORDERED HASH SET - LinkedHashSet
    testLinkedHashSet();

    // DEQUE - Double Ended Queue - "Deck" - ArrayDeque, LinkedList
    testDeque();

    // QUEUE - FIFO - LinkedLast, PriorityQueue, SynchronousQueue, DelayQueue
    testFIFOQueue();

    // PRIORITY QUEUE - USE COMPARATOR
    testPriorityQueue();

    // DELAY QUEUE
    testDelayQueue();

    // Map - KEY, VALUE PAIRS; Key has to have equals(), hashCode()
    testHashMap();

    // LinkedHashMap - Keeps Ordering - FIRST ELEMENT is ELDEST either inserted / accessed
    // LAST is recently accessed / inserted
    testLinkedHashMap();

    // SORTEDMAP & NAVIGABLEMAP - TREEMAP , CONCURRENTSKIPLISTMAP - Comparator

    // READ OPERATIONS MORE, WRITE LESS (THREAD SAFE) - CopyOnWriteArrayList, CopyOnWriteArraySet

    /*

    1. BLOCKING QUEUE - ArrayBlockingQueue, LinkedBlockingQueue

    ArrayBlockingQueue - Bounded Blocking Queue
    LinkedBlockingQueue - Optionally Bounded Blocking Queue
    PriorityBlockingQueue - Unbounded Blocking Queue - based on Priority Comparator.
    DelayQueue - Unbounded Blocking Queue - uses PriorityQueue


    TransferQueue - LinkedTransferQueue - transfer(E) - waits for the receipt of conumsers take().

    SynchronousQueue - Blocking Queue in which each insert operation has to wait for corresponding take operation by another thread

    2. BLOCKING DEQUE - LinkedBlockingDeque

    */



    // LINKEDLIST - LIST, QUEUE, DEQUE



    /*

    CONCURRENT - NON BLOCKING - LOCK / WAIT FREE - CAS (CPU INSTRUCTION) - BYPASSES OS
    **********

    ConcurrentHashMap

    ConcurrentSkipListMap - Concurrent CAS - ConcurrentNavigableMap, SortedMap

    ConcurrentSkipListSet - Concurrent CAS - NavigableSet - SortedSet

    ConcurrentLinkedQueue

    ConcurrentLinkedDeque

     */

  }
}
