package abhi.java.code.java8.Questions;

import java.util.function.*;
import java.util.stream.*;
import java.util.*;

public class FirstNonRepeated {
    // Given a String, find the first non-repeated character in it using Stream functions?
    // refer for explains https://www.java-success.com/java-8-string-streams-finding-first-non-repeated-character-functional-programming/

    public static void main(String[] args) {
        String input = "Java articles are Awesome";
        // First non-repeated

//        Character result = input.chars() // Stream of String
//                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
//                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() == 1L)
//                .map(entry -> entry.getKey())
//                .findFirst()
//                .get();
//        System.out.println(result);

        // first repeated


        Character result = input.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println(result);


        System.out.println("************************************************");

//   Arrays.stream(input.toLowerCase().chars().toArray()).boxed().map(Character::valueOf)
//           .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
//                 .entrySet().stream().filter(i -> i.getValue() == 1).findFirst().get().getKey().

//        System.out.println(ch);

        char[] charArray = input.toCharArray();
        Map<Character, Integer> map=new LinkedHashMap();
        for (int i = 0; i < charArray.length; i++) {

            map.computeIfPresent(charArray[i], (K,v)->v+1);
            map.computeIfAbsent(charArray[i] , v-> 1);

        }

        for (Map.Entry<Character, Integer> ma : map.entrySet()){
            if (ma.getValue()==1){
                System.out.println(ma.getKey());
                break;
            }
        }

    }
}
