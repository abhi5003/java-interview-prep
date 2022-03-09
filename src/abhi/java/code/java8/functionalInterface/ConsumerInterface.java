package abhi.java.code.java8.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {
    public static void main(String[] args) {

        // Consumer functional interface it has on abstract method that is accept() method

        List<Person> list=new ArrayList<>();
        list.add(new Person("Rakesh", 34));
        list.add(new Person("Suresh", 35));
        list.add(new Person("Neha", 23));
        list.add(new Person("Sony", 43));
        list.add(new Person("Abhishek", 21));

        // forEach internally use consumer

//        list.forEach((person)->{
//            System.out.println(person.getName());
//        });

        Consumer<Person> consumer=(person)->{
            System.out.println(person.getName());
            System.out.println(person.getAge());
        };

        consumer.accept(new Person("Ramesh", 45));
    }
}
