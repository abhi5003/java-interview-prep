package abhi.java.code.java8.Questions;

import java.util.Arrays;
import java.util.List;

public class NumberStartingWithOne {

    // Given a list of integers, find out all the numbers starting with 1 using Stream functions?
    public static void main(String[] args) {

        List<Integer> nums= Arrays.asList(10,15,8,49,25,98,32);
        // first we filtering with help of statwith method because startwith return boolean
        // then printing
        nums.stream().filter(i->i.toString().startsWith("1")).forEach(System.out::println);
    }
}
