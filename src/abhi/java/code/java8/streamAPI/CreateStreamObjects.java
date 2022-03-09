package abhi.java.code.java8.streamAPI;

import java.util.*;
import java.util.stream.Stream;

public class CreateStreamObjects {
    public static void main(String[] args) {

        // Create a stream

//        Stream<String> stream=Stream.of("a", "b", "c");
//        stream.forEach(System.out::println);

        // Create stream from sources

//        Collection<String> collection= Arrays.asList("Java", "C", "Python", "javaScript");
//        collection.stream().forEach(System.out::println);

//        List<String> list= Arrays.asList("Java", "C", "Python", "javaScript");
//        list.stream().forEach(System.out::println);

        // using set

        Set<String> set=new HashSet<>(Arrays.asList("Java", "C", "Python", "javaScript"));
        set.stream().forEach(System.out::println);

        // using array

        String[] string={"a", "b", "c", "d"};
        Arrays.stream(string).forEach(System.out::println);
    }
}
