package abhi.java.code.java8.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumber {

    // Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
    public static void main(String[] args) {

        List<Integer> nums= Arrays.asList(10,15,8,49,25,98,32);
        nums.stream().filter(num -> num%2==0).forEach(System.out::println);
    }
}
