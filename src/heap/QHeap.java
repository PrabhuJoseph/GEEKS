package heap;

public class QHeap {

    int[] heap = new int[10];
    int size = 0;

    public void insert(int element) {
      if (size <= heap.length) {
          heap[size] = element;
          size++;
      }
    }

    public void heapify(int level) {
      System.out.println("LEVEL="+level);
      int large = level;
      int left = (2 * level) + 1;
      int right = 2 * (level + 1);
      if (left < size && heap[left] > heap[large]) {
        large = left;
      }
      if (right < size && heap[right] > heap[large]) {
        large = right;
      }
      if (large != level) {
        int temp = heap[large];
        heap[large] = heap[level];
        heap[level] = temp;
        heapify(large);
      }
    }

    public int findMin() {
      for (int i=size / 2; i>=0; i--) {
        heapify(i);
      }
      return heap[0];
    }

    public static void main(String[] args) {
      QHeap heap = new QHeap();
      heap.insert(5);
      heap.insert(7);
      heap.insert(9);
      heap.insert(3);

      System.out.println(heap.findMin());
    }
}
