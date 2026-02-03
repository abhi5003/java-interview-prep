package abhi.java.code.questions;


import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/create-immutable-class-java/

// final class
final class Student{

    // private final fields
    private final String name;
    private final int regNo;
    private final Map<String, String> metadata;

    public Student(String name, int regNo, Map<String, String> metadata) {

        this.name = name;
        this.regNo = regNo;

        // crating deep copy map
        Map<String, String> copyMap=new HashMap<>();

        for (Map.Entry<String, String> entry : metadata.entrySet()){
            copyMap.put(entry.getKey(), entry.getValue());
        }
        this.metadata = copyMap;
    }

    public String getName() {
        return name;
    }

    public int getRegNo() {
        return regNo;
    }

    public Map<String, String> getMetadata() {

        // crating deep copy map
        Map<String, String> copyMap=new HashMap<>();
        for (Map.Entry<String, String> entry : metadata.entrySet()){
            copyMap.put(entry.getKey(), entry.getValue());
        }
        return copyMap;
    }
}


 public class ImmutableClass {

     public static void main(String[] args) {

         // Creating Map object with reference to HashMap
         Map<String, String> map = new HashMap<>();

         // Adding elements to Map object
         // using put() method
         map.put("1", "first");
         map.put("2", "second");

         Student s = new Student("ABC", 101, map);

         // Calling the above methods 1,2,3 of class1
         // inside Main() method in class2 and
         // executing the print statement over them
         System.out.println(s.getName());
         System.out.println(s.getRegNo());
         System.out.println(s.getMetadata());

         // Uncommenting below line causes error
         // s.regNo = 102;

         map.put("3", "third");
         // Remains unchanged due to deep copy in constructor
         System.out.println(s.getMetadata());
         s.getMetadata().put("4", "fourth");
         // Remains unchanged due to deep copy in getter
         System.out.println(s.getMetadata());
     }

}
