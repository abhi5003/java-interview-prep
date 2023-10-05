package abhi.java.code.java8.Questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.*;

public class FindMaxElement {
    // Given a list of integers, find the maximum value element present in it using Stream functions?

    public static void main(String[] args) {
        List<Integer> nums= Arrays.asList(2, 4, 55,903, 43, 292, 883);
        int max = nums.stream().max((comparingInt(o -> o))).get();
        System.out.println(max);
    }
}
