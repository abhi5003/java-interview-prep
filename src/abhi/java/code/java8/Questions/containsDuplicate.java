package abhi.java.code.java8.Questions;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class containsDuplicate {

    // Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

    public static void main(String[] args) {

//        int[]nums= {5,2,3,1};
//        List<Integer> list = Arrays.stream(nums)
//                .boxed()
//                .collect(Collectors.toList());
//
//       Set<Integer> set= list.stream().filter(integer -> new HashSet<Integer>().add(integer)).collect(Collectors.toSet());
//        System.out.println(set.size()== nums.length ? "NO" : "Yes");


        String input="ilovejavatechie";
       Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().forEach(System.out::print);



    }
}
