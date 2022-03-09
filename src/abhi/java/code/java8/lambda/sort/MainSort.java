package abhi.java.code.java8.lambda.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainSort {
    public static void main(String[] args) {

        ArrayList<Employee> empList=new ArrayList<>();

        empList.add(new Employee("Ram", 121, 20030));
        empList.add(new Employee("Rakesh", 122, 20034));
        empList.add(new Employee("Amit", 124, 20035));
        empList.add(new Employee("Neha", 123, 20036));
        empList.add(new Employee("Satyam", 126, 20037));
        empList.add(new Employee("Suresh", 125, 20028));


        // using comparable by implementation of comparable interface in employee class

//        Collections.sort(empList);
//        System.out.println(empList);

        // Using anonymous implementation of comparator

//        Collections.sort(empList, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getId()-o2.getId();
//            }
//        });

        // Using java 8 lambda
        // Ascending order

//        Collections.sort(empList, (o1, o2)-> o1.getId()-o2.getId());
//        System.out.println(empList);

        // Descending order

//        Collections.sort(empList, (o1, o2)->o2.getId()-o1.getId());
//        System.out.println(empList);

        // Sort by name using comparator

//        Collections.sort(empList, ((o1, o2) -> o1.getName().compareTo(o2.getName())));
//        System.out.println(empList);

        // Sort by emp salary using comparator

//        Collections.sort(empList, ((o1, o2) -> (int) (o1.getSalary()-o2.getSalary())));
//        System.out.println(empList);


    }
}
