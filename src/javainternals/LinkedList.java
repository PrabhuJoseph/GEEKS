package javainternals;

public class LinkedList<E> {

  static class Node<E> {
    E item;
    Node<E> prev;
    Node<E> next;

    public Node(E item, Node<E> prev, Node<E> next) {
      this.item = item;
      this.next = next;
      this.prev = prev;
    }
  }

  int size;
  Node<E> first;
  Node<E> last;

  public void add(E item) {
    if (last != null) {
      Node<E> node = new Node<>(item, last, null);
      last.next = node;
      last = node;
    } else {
      Node<E> node = new Node<>(item, null, null);
      last = node;
      first = node;
    }
  }

  public Node<E> get(E item) {
    Node<E> start = first;
    while (start != null) {
      if (start.item.equals(item)) {
        return start;
      }
      start = start.next;
    }
    return null;
  }

  public void remove(E item) {
    Node<E> dNode = get(item);
    if (dNode != null) {
      if (dNode == first) {
        if (dNode.next != null) {
          dNode.next.prev = null;
        }
        if (dNode == last) {
          last = null;
        }
        first = dNode.next;
      } else if (dNode == last) {
        if (dNode.prev != null) {
          dNode.prev.next = null;
        }
        if (dNode == first) {
          first = null;
        }
        last = dNode.prev;
      } else {
        Node<E> prev = dNode.prev;
        Node<E> next = dNode.next;
        prev.next = next;
        next.prev = prev;
        dNode.next = dNode.prev = null;
        dNode.item = null;
      }
    }
  }

  public void traverse() {
    Node<E> start = first;
    while (start != null) {
      System.out.println(start.item);
      start = start.next;
    }
  }

  public static void main(String[] args) {
    Integer one = new Integer(1);
    Integer two = new Integer(2);
    Integer three = new Integer(3);
    Integer four = new Integer(4);

    LinkedList<Integer> list = new LinkedList<>();
    list.add(one);
    list.add(two);
    list.add(three);
    list.add(four);

    list.traverse();

    list.remove(three);
    list.traverse();

    list.remove(one);
    list.traverse();

    System.out.println(list.get(one));

    System.out.println(list.get(four).item);

  }

}
