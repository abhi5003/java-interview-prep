package abhi.java.code.java8.functionalInterface;

import java.util.function.BiPredicate;

public class BiPredicateInterface {
    public static void main(String[] args) {

        // Bipredicate is functional interface which take two argument and it have test() method
        // that take two parameter and return boolean value

//        BiPredicate<Integer, Integer> biPredicate=(x, y)->{
//            if(x>y){
//                return true;
//            }else {
//                return false;
//            }
//        };
//        System.out.println(biPredicate.test(45, 67));

//        BiPredicate<String, String > biPredicate1=(s1, s2)->s1.equals(s2);
//        System.out.println(biPredicate1.test("Abhi", "Abhi"));

        BiPredicate<Integer, Integer> biPredicate2=(a, b)-> a>b;
        BiPredicate<Integer, Integer> biPredicate3=(x, y)->x==y;

        boolean result=biPredicate2.and(biPredicate3).test(10, 34);
        System.out.println(result);
    }
}
