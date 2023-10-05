package abhi.java.code.java8.functionalInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerInterface {
    public static void main(String[] args) {

        // Biconsumer is functional interface which take to argument it has accept()
        // which take two parameter and return type is void

        BiConsumer<Integer, Integer> biConsumer1=(a, b)-> System.out.println(a+b);
        biConsumer1.accept(45, 78);

        BiConsumer<Integer, Integer> biConsumer2=(a, b)-> System.out.println(a-b);
        biConsumer2.accept(405, 78);

        Map<Integer, String> map=new HashMap<>();
        map.put(1, "Ramesh");
        map.put(2, "Sonu");
        map.put(3, "Neha");
        map.put(4, "Shuresh");
        map.put(5, "Rekha");

        //Bi consumer foreach method
        map.forEach((k, v)->{
            System.out.println(k+" "+v);

        });

    }
}
