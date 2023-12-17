package abhi.java.code.java8.Questions;

import java.util.Arrays;
import java.util.List;

public class FindTheTotalNumberOfElements {
    // Given a list of integers, find the total number of elements present in the list using Stream functions?

    public static void main(String[] args) {
        List<Integer> nums= Arrays.asList(2, 4, 55, 43, 292, 883);
        int count= (int) nums.stream().count();
        System.out.println(count);
    }
}
