package algorithms;


import java.util.HashSet;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;



public class RoutesMerger {
  /**
  Given a list of [origin, destination] pairs (you could think of them as plane tickets), sort them into a single continuous route.

  Sample Input

  [
   ["SFO", "EWR"], - read
   ["SJC", "LAX"], -
   ["DFW", "SJC"],
   ["EWR", "OAK"], - read
   ["LAX", "SFO"] -
  ]

  Desired output

  ["DFW", "SJC", "LAX", "SFO", "EWR", "OAK"]
  */

  public static void main(String[] args) {
    // Available Routes
    Map<String, String> routes = new LinkedHashMap<>();
    routes.put("SFO", "EWR");
    routes.put("SJC", "LAX");
    routes.put("DFW", "SJC");
    routes.put("EWR", "OAK");
    routes.put("LAX", "SFO");

    // Traverse all starting point and find the complete route
    HashSet<String> visited = new HashSet<>();
    LinkedList<List> finalRoute = new LinkedList();
    for (Map.Entry<String, String> route : routes.entrySet()) {
      LinkedList<String> currentRoute = new LinkedList<>();
      String next = route.getKey();
      if (!visited.contains(next)) {
          currentRoute.add(route.getKey());
          visited.add(route.getKey());
          currentRoute.add(route.getValue());
          String nextKey = route.getValue();
          String nextValue = routes.get(route.getValue());
          while (!visited.contains(nextKey) && nextValue != null) {
              currentRoute.add(nextValue);
              visited.add(nextKey);
              nextKey = nextValue;
              nextValue = routes.get(nextKey);
          }
          if (finalRoute.size() > 0) {
            currentRoute.removeLast();
          }
          finalRoute.addFirst(currentRoute);
      }
    }

    // Output the complete route
    for (List<String> route : finalRoute) {
      for (String place : route)
      System.out.print(place + "->");
    }
    System.out.println();

  }
}
