package abhi.java.code.java8.Questions;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class EvenNumber {

    // Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
    public static void main(String[] args) {

        List<Integer> nums= Arrays.asList(10,15,8,49,25,98,32);

       int sumOdd= nums.stream().filter(n->n%2!=0).mapToInt(i->i*i).sum();
        System.out.println("Sum odd " +sumOdd);

        // Even num
        nums.stream().filter(num -> num%2==0).forEach(System.out::println);


        //
        List<Integer> multiplyofFive=Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> collect = multiplyofFive.stream().map(i -> i * 5).collect(Collectors.toList());



        String str="India";
        str.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char) s))).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(i->i.getValue()>1).forEach(System.out::println);
    }
}
