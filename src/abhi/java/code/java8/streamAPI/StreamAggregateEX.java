package abhi.java.code.java8.streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamAggregateEX {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(23, 45, 56, 32, 57, 33);
        // min(), max() and count()

        System.out.println(list.stream().count());

       Integer integerMin= list.stream().min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(" min value : "+integerMin);

        Integer integerMax= list.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(" max value : "+integerMax);
    }
}
