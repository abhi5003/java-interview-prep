package abhi.java.code.java8.Questions;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class SortValues {

    //  Given a list of integers, sort all the values present in it using Stream functions?

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        // Ascending order
//        myList.stream().sorted().forEach(System.out::println);

        // Descening order

//        myList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        myList.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting())).entrySet().forEach(System.out::println);


    }
}
