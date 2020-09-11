package arrays;

// https://www.geeksforgeeks.org/find-missing-elements-from-an-array/?ref=leftbar-rightbar
import java.util.*;

class MissingElementInArray
{
    static Vector missing_elements(Vector<Integer> vec) {
      Vector<Integer> missing = new Vector<>();
      boolean[] visited = new boolean[vec.size()];
      for (int i=0; i<vec.size(); i++) {
        int x = vec.get(i);
        visited[x-1] = true;
      }
      for (int i=0; i<vec.size(); i++) {
        if (!visited[i]) {
          missing.add(i+1);
        }
      }
      return missing;
    }

    public static void main(String args[]) {
        Vector<Integer> vec = new Vector();
        vec.add(3);
        vec.add(3);
        vec.add(3);
        vec.add(5);
        vec.add(1);

        Vector miss_ele = missing_elements(vec);

        for (int i = 0; i < miss_ele.size(); i++)
            System.out.print(miss_ele.get(i) + " ");
    }
}


