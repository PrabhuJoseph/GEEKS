package guavacollections;


import com.google.common.collect.*;

import java.util.HashMap;
import java.util.Map;

public class GuavaCollection {
  public static void main(String[] args) {

    // MultiSet: Internally uses ConcurrentHashMap<E, AtomicInteger>
    ConcurrentHashMultiset<String> ducks = ConcurrentHashMultiset.create();
    ducks.add("Sachin", 2);
    ducks.add("Virat", 4);
    ducks.setCount("Ganguly", 3);

    System.out.println("SACHIN DUCKS=" +ducks.count("Sachin"));


    // MultiMap: LinkedListMultiMap - Internally uses List of Nodes
    // where Node has sibling nodes for storing multiple values

    LinkedListMultimap<String, Integer> scores = LinkedListMultimap.create();
    scores.put("Sachin", 189);
    scores.put("Sachin", 145);
    scores.put("Sachin", 200);
    scores.put("Sehwag", 188);

    System.out.println("SACHIN SCORES=" + scores.get("Sachin").stream().reduce(0, Integer::sum));

    // MultiMap: ArrayListMultiMap - Internally uses HashMap of Key, ArrayList<Value>

    ArrayListMultimap<String, Integer> wickets = ArrayListMultimap.create();
    wickets.put("Zaheer Khan", 5);
    wickets.put("Zaheer Khan", 4);
    wickets.put("Yuvraj Singh", 2);

    System.out.println("ZAHEER KHAN WICKETS=" + wickets.get("Zaheer Khan").stream().reduce(0, Integer::sum));


    // BIMAP: HashBiMap - Has two hash tables one for K to V, other for V to K. BiEntry which has both key and value hash

    HashBiMap<String, Integer> userIdMap = HashBiMap.create();
    userIdMap.put("Sachin", 100);
    userIdMap.put("Sehwag", 200);

    System.out.println("SACHIN ID="+userIdMap.get("Sachin"));
    System.out.println("ID 200 is for="+userIdMap.inverse().get(200));

    // RANGESET - TREERANGESET

    RangeSet<Integer> ranges = TreeRangeSet.create();
    ranges.add(Range.closed(1,100));
    ranges.add(Range.closed(101,200));
    ranges.add(Range.closed(201,500));

    System.out.println("RANGE CHECK=" + ranges.contains(399));

    // RANGEMAP - TREERANGEMAP

    RangeMap<Integer,Integer> minuteWiseCount = TreeRangeMap.create();
    minuteWiseCount.put(Range.closed(1,100),100);
    minuteWiseCount.put(Range.closed(101,200),150);
    minuteWiseCount.put(Range.closed(201,500),350);

    System.out.println("RANGE CHECK="+minuteWiseCount.get(20));


    // TABLE - HASHBASEDTABLE - HashMap<R, HashMap<C, V>>

    // ROWKEY - COLKEY - COLVALUE
    HashBasedTable<String, String, Integer> stats = HashBasedTable.create();
    stats.put("Sachin", "Innings", 350);
    stats.put("Sachin", "Scores", 15000);
    stats.put("Sachin", "Hundreds", 100);
    stats.put("Dravid", "Innings", 250);
    stats.put("Dravid", "Scores", 11000);
    stats.put("Dravid", "Hundreds", 40);

    System.out.println("Sachin Hundreds="+ stats.get("Sachin", "Hundreds"));

    int totalHundres = stats.column("Hundreds").values().stream().reduce(0, Integer::sum);
    System.out.println("TOTAL HUNDREDS BY ALL BATSMEN="+ totalHundres);

    // ARRAYTABLE - Internally has Map of rowkey to index, Map of columnKey to Index and Array[rowkeyindex][columnkeyindex]

    // WON'T allow to create new row or column later.

    ArrayTable<String, String, Integer> t20Stats = ArrayTable.create(ImmutableList.of("Rohit","Virat"),
            ImmutableList.of("Innings", "Scores"));
    t20Stats.put("Rohit", "Innings", 50);
    t20Stats.put("Rohit", "Scores", 5000);
    t20Stats.put("Virat", "Innings", 45);
    t20Stats.put("Virat", "Scores", 4500);


    System.out.println(t20Stats.get("Rohit", "Scores"));


    // CLASS TO INSTANCE MAP

    class Data {
      int id;
      public Data(int id) {
        this.id = id;
      }
    }

    class Information {
      int id;
      public Information(int id) {
        this.id = id;
      }
    }

    // GUAVA CLASS INSTANCE MAP

    ClassToInstanceMap<Object> dataCache = MutableClassToInstanceMap.create();
    dataCache.put(Data.class, new Data(1));
    dataCache.put(Information.class, new Information(2));

    Information info = (Information) dataCache.get(Information.class);
    System.out.println("Output-"+info.id);

    // SIMILAR ONE WITHOUT GUAVA
    Map<Class, Object> instanceMap = new HashMap<>();
    instanceMap.put(Data.class, new Data(3));
    instanceMap.put(Information.class, new Information(4));
    instanceMap.put(Integer.class, new Information(6));

    Information info1 = (Information) instanceMap.get(Information.class);
    System.out.println("Output-"+info1.id);

    // RESTARICTING TO CLASSES WHICH EXTENDS INTEGER
    
    Map<Class<? extends Number>, Object> instanceMap1 = new HashMap<>();
    instanceMap1.put(Integer.class, new Data(5));
    instanceMap1.put(Double.class, new Information(6));

    Information info2 = (Information) instanceMap1.get(Double.class);
    System.out.println("Output-"+info2.id);

  }
}
