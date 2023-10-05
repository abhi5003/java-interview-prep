package abhi.java.code.java8.forEach;

import java.util.HashMap;
import java.util.Map;

public class MapForEachEX {
    public static void main(String[] args) {
        Map<Integer, Person> map=new HashMap<>();

        map.put(1, new Person("Ramesh", 45));
        map.put(2, new Person("Rakesh", 47));
        map.put(3, new Person("Ram", 43));
        map.put(4, new Person("Mukesh", 25));
        map.put(5, new Person("priya", 23));

        // use for each loop

        for (Map.Entry<Integer, Person> personMap : map.entrySet()){
            System.out.println(personMap.getKey()+" "+personMap.getValue().getName());
        }

        // using stream and lambda

        map.forEach((k, v)->{
            System.out.println(k+" "+v.getName()+" "+ v.getAge());
        });

        map.entrySet().stream().forEach((k) -> System.out.println(k.getValue().getName()));

    }
}
