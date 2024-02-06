package abhi.java.code.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Concurrentmodificationexception {
    public static void main(String[] args) {

        // What causes a ConcurrentModificationException?

        // Removing an element from the list
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));

        for (String name : names) {
            if (name.equals("Bob")) {
                names.remove(name); // Throws ConcurrentModificationException
            }
        }

       // Adding an element to the list
        for (String name : names) {
            if (name.equals("Bob")) {
                names.add("David"); // unsafe modification
            }
        }

    }


}
