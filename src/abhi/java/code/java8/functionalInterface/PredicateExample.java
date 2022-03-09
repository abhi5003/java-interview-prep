package abhi.java.code.java8.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {
    public static void main(String[] args) {

        // Predicate is functional interface it hsa only one abstract that test() and
        // return boolean value

//        Predicate<Person> personPredicate=(person)->person.getAge()>30;
//        boolean result=personPredicate.test(new Person("Ramesh", 32));
//        System.out.println(result);

        Predicate<Integer>  predicate=(num)->{
            if(num%2==0){
                return true;
            }else {
                return false;
            }
        };
        System.out.println(predicate.test(23));

        // example 2

        List<Integer> list= Arrays.asList(23, 44, 56, 23, 21, 15, 34, 67);
        list.stream().filter(integer->integer%2==0).forEach(System.out::println);

        // example 3

        Predicate<Integer> predicate1=(x)->x>30;
        Predicate<Integer> predicate2=(x)->x<40;

        list.stream().filter(predicate1.and(predicate2)).collect(Collectors.toList()).forEach(System.out::println);
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}