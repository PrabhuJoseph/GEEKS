package javainternals;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Iterator;

// Reference: https://www.geeksforgeeks.org/lru-cache-implementation/

/* The key to solve this problem is using a double linked list which enables us to quickly move nodes.
The LRU cache is a hash set of keys and double linked nodes. The hash set makes the time of get() to be O(1).
The list of double linked nodes make the nodes adding/removal operations O(1).
*/


public class LRUCache {


  // OR LINKEDHASHMAP

  int pages;
  Deque<Integer> cache = new LinkedList<>();
  HashSet<Integer> pageSet = new HashSet<>();

  public LRUCache(int pages) {
    this.pages = pages;
  }

  public void refer(int page) {
    if (pageSet.contains(page)) {
      cache.remove(page);
      cache.addFirst(page);
    } else {
      if (cache.size() >= pages) {
        cache.removeLast();
      }
      cache.addFirst(page);
      pageSet.add(page);
    }
  }

  public void display() {
    Iterator<Integer> itr = cache.iterator();
    while (itr.hasNext()) {
      System.out.print(itr.next() + " ");
    }
  }

  public static void main(String[] args) {
    LRUCache ca = new LRUCache(4);
    ca.refer(1);
    ca.refer(2);
    ca.refer(3);
    ca.refer(1);
    ca.refer(4);
    ca.refer(5);
    ca.display();

  }
}
