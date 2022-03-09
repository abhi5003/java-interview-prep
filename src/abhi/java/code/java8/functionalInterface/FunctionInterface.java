package abhi.java.code.java8.functionalInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args) {

        // Function is functional interface and have apply() method
        // this method take one input and return other output

//        Function<String, Integer> function=new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return s.length();
//            }
//        };
//
//        System.out.println(function.apply("Abhinandan"));

        // example 1

        Function<String, Integer> function=(str)->str.length();
        System.out.println(function.apply("Abhinandan"));

        // example 2

        Function<Integer, String> function1=(integer)->{

            if (integer%2==0){
                return integer+" is even";
            }else {
                return integer+" is odd";
            }
        };

        System.out.println(function1.apply(13));

        // example 3

        Function<String, Integer> function2=(str)->str.length();
        Function<Integer, Integer> function3=(integer)->integer*2;

        Integer integer=function2.andThen(function3).apply("Ramesh");
        System.out.println(integer);

        // Example 4

//        List<String> list= Arrays.asList("Java", "Python", "JavaScript", "C", "R");
//         Map<String, Integer> map=convertListToMap(list, x->x.l)
//
//        private static <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> function){
//            Map<T, R> map=new HashMap<>();
//            for (T t:list){
//                map.put(t, function.apply(t));
//            }
//            return map;
//        }

    }
}
