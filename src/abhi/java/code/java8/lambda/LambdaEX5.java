package abhi.java.code.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaEX5 {
    public static void main(String[] args) {

        List<String> list= Arrays.asList("Java", "C", "Python", "JavaScript", "Rust", "Go", "R");
        list.forEach(s -> System.out.println(s));
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }
}
