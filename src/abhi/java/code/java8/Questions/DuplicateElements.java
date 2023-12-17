package abhi.java.code.java8.Questions;

import java.util.*;
import java.util.stream.*;

public class DuplicateElements {

    // How to find duplicate elements in a given integers list in java using Stream functions?

    public static void main(String[] args) {
        List<Integer> nums= Arrays.asList(10,15,8,49,25,98,98, 98,32,15);
        Set<Integer> set=new HashSet<>();
        nums.stream().filter(integer -> !set.add(integer)).distinct().forEach(System.out::println);


        System.out.println("*************************************");
         Set<Integer> duplicate = nums.stream().filter(i -> Collections.frequency(nums, i) > 1).collect(Collectors.toSet());
        System.out.println(duplicate);
    }
}
