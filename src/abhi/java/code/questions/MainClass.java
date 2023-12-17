package abhi.java.code.questions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
      List<Integer> nums= Arrays.asList(2, 3, 3, 11, 17, 5, 8, 17, 10, 47, 23, 74);
        findFirstNonRepated();
    }

    /*
    Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
    */
    private static void evenNum(List<Integer> nums){
        nums.stream().filter(i-> i%2==0).forEach(System.out::println);
    }

    /*
    Given a list of integers, find out all the numbers starting with 1 using Stream functions?
    */
    private  static void startWithOne(List<Integer> nums){
        nums.stream().map(i->i+"").filter(i->i.startsWith("1")).forEach(System.out::println);
    }


    /*
      How to find duplicate elements in a given integers list in java using Stream functions?
    */
    private static void findDuplicate(List<Integer> nums){
        Set<Integer> set=new HashSet<>();
        nums.stream().filter(i-> !set.add(i)).forEach(System.out::println);
    }

    /*
    * Given the list of integers, find the first element of the list using Stream functions?
    * */
    private static void findFirst(List<Integer> nums){
        nums.stream().findFirst().ifPresent(System.out::println);
    }

    /*
    * Find total element in list
    * */
    private static void totalCount(List<Integer> nums){
        long count=nums.stream().count();
        System.out.println(count);
    }

    /* find max element */
    private static void maxElement(List<Integer> nums){
        nums.stream().max(Integer::compare).ifPresent(System.out::println);
    }

    private static void findFirstNonRepated(){
        String input = "Java articles are Awesome";
        Character result =input.chars()
                .mapToObj(s->Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i->i.getValue()==1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();

        System.out.println(result);
    }
}
