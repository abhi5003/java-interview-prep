package abhi.java.code.java8.functionalInterface;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierInterface {
    public static void main(String[] args) {

        // Supplier interface having only one abstract method that is get() which return object

//        Supplier<Person> personSupplier=()-> new Person("manish", 34);
//
//        Person person=personSupplier.get();
//        System.out.println(person.getName()+" age is :"+person.getAge());

        // Anonymous implementation of supplier interface

//        Supplier<LocalDateTime> supplier=new Supplier<LocalDateTime>() {
//            @Override
//            public LocalDateTime get() {
//                return LocalDateTime.now();
//            }
//        };
//        System.out.println(supplier.get());


        // Lambda expression

        Supplier<LocalDateTime> supplier=()->LocalDateTime.now();
        System.out.println(supplier.get());
    }
}
