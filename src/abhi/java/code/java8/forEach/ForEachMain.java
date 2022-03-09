package abhi.java.code.java8.forEach;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ForEachMain {
    public static void main(String[] args) {

//        List<Person> list=new ArrayList<>();
        Set<Person> set=new HashSet<>();
        set.add(new Person("Siku", 29));
        set.add(new Person("Manish", 35));
        set.add(new Person("Abhishek", 25));
        set.add(new Person("Ram", 28));
        set.add(new Person("Mohan", 27));

        // Prior Java 8

//        for (Person person:list){
//            if (person.getName()=="Siku"){
//                System.out.println(person.getName()+" chutiya age "+person.getAge());
//            }
//            System.out.println(person.getName()+" "+person.getAge());
//        }

//        list.forEach((person)-> System.out.println(person.getName()+" "+person.getAge()));
//
//        list.stream().forEach((person)->System.out.println(person.getName()+" "+person.getAge()));

        for (Person person : set){
            System.out.println(person.getName()+" "+ person.getAge());
        }

        set.forEach((person)-> System.out.println(person.getName()+" "+person.getAge()));

        set.stream().forEach((person)->System.out.println(person.getName()+" "+person.getAge()));
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
}
