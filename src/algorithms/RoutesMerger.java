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
      Map<String, String> routes = new LinkedHashMap<>();
      routes.put("LAX", "SFO");
      routes.put("DFW", "SJC");
      routes.put("SFO", "EWR");
      routes.put("SJC", "LAX");
      routes.put("EWR", "OAK");
      routes.put("OAK", "LON");
      routes.put("LON", "CHN");

      HashSet<String> visited = new HashSet<>();
      LinkedList<List> finalRoute = new LinkedList<>();

      for (Map.Entry<String, String> entry : routes.entrySet()) {
        LinkedList<String> currentRoute = new LinkedList<>();
        String place = entry.getKey();
        while (place!=null && !visited.contains(place)) {
          currentRoute.add(place);
          visited.add(place);
          place = routes.get(place);
        }
        finalRoute.addFirst(currentRoute);
      }
      // Output the complete route
      for (List<String> route : finalRoute) {
          for (String place : route)
              System.out.print(place + "->");
      }
      System.out.println();
  }
}
