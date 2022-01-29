package javainternals;


// THIS LinkedHashMap is for Caching Purpose - Evict Old Entries based on capacity, Moves the Elements
// to front if accessed

public class LinkedHashMap<K,V> {

  static class Entry<K, V> {
    K k;
    V v;
    Entry<K, V> next;
    Entry<K, V> after;
    Entry<K, V> before;

    public Entry(K k, V v, Entry next) {
      this.k = k;
      this.v = v;
      this.next = next;
    }
  }

  private Entry<K, V> head;
  private Entry<K, V> tail;

  private Entry<K,V>[] table;
  private int buckets = 10;
  private int capacity;
  private int size;
  private boolean accessOrder;

  public LinkedHashMap(int capacity, boolean accessOrder) {
    table = new Entry[buckets];
    this.capacity = capacity;
    this.size = 0;
    this.accessOrder = accessOrder;
  }

  private void afterNodeInsert(Entry<K, V> entry) {
    if (head == null) {
      head = entry;
      head.after = null;
      head.before = null;
      tail = entry;
    } else {
      Entry<K, V> curHead = head;
      head = entry;
      head.after = curHead;
      head.before = null;
      curHead.before = head;
    }
  }


  private void evictOldEntry() {
    Entry<K, V> prevTail = tail.before;
    if (prevTail != null) {
      prevTail.after = null;
    }
    remove(tail.k);
    tail = prevTail;
  }

  private void afternodeAccess(Entry<K, V> entry) {
    if (accessOrder) {
      Entry<K,V> after = entry.after;
      Entry<K,V> before = entry.before;
      if (before == null) {
        return;
      } else {
        before.after = after;
        if (after != null) {
          after.before = before;
        } else {
          tail = before;
        }
        Entry curHead = head;
        head = entry;
        entry.after = curHead;
      }
    }
  }

  // PUT supports overwrite, new data, value cannot be null
  public void put(K k, V v) {
    if (v == null) {
      return;
    }

    if (size == capacity) {
      evictOldEntry();
    }

    int hash = k.hashCode() % buckets;
    Entry firstEntry = table[hash];
    Entry<K, V> newEntry = null;
    if (firstEntry == null) {
      newEntry = new Entry<>(k, v, null);
    } else {
      while (firstEntry != null) {
        if (firstEntry.k.equals(k)) {
          firstEntry.v = v;
          return;
        }
        firstEntry = firstEntry.next;
      }
      Entry entry = table[hash];
      newEntry = new Entry<>(k, v, entry);
    }
    table[hash] = newEntry;
    this.size++;
    afterNodeInsert(newEntry);
  }

  public V get(Object key) {
    int hash = key.hashCode() % buckets;
    Entry<K, V> firstEntry = table[hash];
    while (firstEntry != null) {
      if (firstEntry.k.equals(key)) {
        afternodeAccess(firstEntry);
        return firstEntry.v;
      }
      firstEntry = firstEntry.next;
    }
    return null;
  }

  public void remove(Object key) {
    int hash = key.hashCode() % buckets;
    Entry<K, V> prev = null;
    Entry<K, V> firstEntry = table[hash];
    while (firstEntry != null) {
      if (firstEntry.k.equals(key)) {
        break;
      }
      prev = firstEntry;
      firstEntry = firstEntry.next;
    }
    if (prev == null) {
      table[hash] = firstEntry.next;
    } else {
      prev.next = firstEntry.next;
    }
    firstEntry.next = null;
    this.size--;
  }


  public static void main(String[] args) {
    LinkedHashMap<Integer, String> data = new LinkedHashMap<>(2, true);
    data.put(1, "sachin");
    data.put(2, "ganguly");
    data.put(3, "dravid");
    data.put(4, "dhoni");

    System.out.println("GET 1="+ data.get(1));
    System.out.println("GET 2="+ data.get(2));
    System.out.println("GET 3="+ data.get(3));
    System.out.println("GET 4="+ data.get(4));

    // TEST ACCESS ORDER
    System.out.println("GET 3="+ data.get(3));

    data.put(1, "sachin");


    System.out.println("GET 1="+ data.get(1));
    System.out.println("GET 2="+ data.get(2));
    System.out.println("GET 3="+ data.get(3));
    System.out.println("GET 4="+ data.get(4));



  }

}
