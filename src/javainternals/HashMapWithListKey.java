package javainternals;

import java.util.HashMap;
import java.util.LinkedList;

public class HashMapWithListKey {


    // DON"T USE COLLECTION AS KEY - USE A Class with equals and hashCode implemented
    // EVEN THOUGH LIST has equals() which checks size and elements inside it and same order.
    static HashMap<LinkedList<String>, String> registry = new HashMap<>();

    public static void main(String[] args) {
        LinkedList<String> B = new LinkedList<>();
        B.add("intarray");
        registry.put(B, "funcB");

        LinkedList<String> A = new LinkedList<>();
        A.add("int");
        A.add("String");
        registry.put(A, "funcA");

        LinkedList<String> C = new LinkedList<>();
        C.add("int");
        registry.put(C, "funcC");

        LinkedList<String> D = new LinkedList<>();
        D.add("int");
        D.add("String");

        String function = registry.get(D);
        System.out.println("FUNCTION="+function);

    }
}
