package abhi.java.code.java8.Questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateElements {

    // How to find duplicate elements in a given integers list in java using Stream functions?

    public static void main(String[] args) {
        List<Integer> nums= Arrays.asList(10,15,8,49,25,98,98, 98,32,15);
        Set<Integer> set=new HashSet<>();
        nums.stream().filter(integer -> !set.add(integer)).distinct().forEach(System.out::println);
    }
}
