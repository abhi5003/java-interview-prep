package abhi.java.code.java8.functionalInterface;

import java.util.function.BiFunction;

public class BiFunctionInterface {
    public static void main(String[] args) {

        // BiFunction is functional interface it hsa one abstract method apply() which get two
        // parameter and return result

        BiFunction<Integer, Integer, Integer> biFunction=(a, b)-> a+b;
        System.out.println(biFunction.apply(45, 67));
    }
}
