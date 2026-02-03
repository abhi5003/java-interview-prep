package abhi.java.code.java9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableListExample {
    public static void main(String[] args) {

        // Creating an ArrayList of String using
        List< String > fruits = new ArrayList< >();
        // Adding new elements to the ArrayList
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("mango");
        fruits.add("orange");

        // Creating Immutable List

        fruits = Collections.unmodifiableList(fruits);

        fruits.add("Strawberry");

        // Exception in thread "Main"
        // java.lang.UnsupportedOperationException<String>

        // Java 9
        // Creating Immutable List

//         fruits = List.of("Banana", "Apple", "Mango", "Orange");
        fruits.forEach(i-> System.out.println(i));
    }
}
