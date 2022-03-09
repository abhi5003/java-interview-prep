package abhi.java.code.java8.streamAPI.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamListSorting {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("Apple");
        list.add("Mango");
        list.add("pine Apple");
        list.add("Papaya");
        list.add("Orange");

        // Using comparator static method naturalOrder()
        list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("-------------------------------------------------");
        // Using comparator compare method with lambda expression
        list.stream().sorted((o1, o2)->o1.compareTo(o2)).collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        // Using sorted method in ascending order
        list.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);

        // Descending order

        System.out.println("------------------Descending order-------------------------------");
        list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("-------------------------------------------------");

        list.stream().sorted((o1, o2)->o2.compareTo(o1)).collect(Collectors.toList())
                .forEach(System.out::println);



        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee("Ramesh", 121, 15000));
        employeeList.add(new Employee("Vishal", 125, 15500));
        employeeList.add(new Employee("Neha", 124, 15600));
        employeeList.add(new Employee("Suresh", 123, 15700));
        employeeList.add(new Employee("Priya", 122, 14500));

        System.out.println("---------------------Employee Sorting by ID ---------------------------");

        employeeList.stream().sorted((o1, o2)->o1.getId()-o2.getId())
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("---------------------Employee Sorting by Name ---------------------------");
        employeeList.stream().sorted((o1, o2)->o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("---------------------Employee Sorting by Salary ---------------------------");
        employeeList.stream().sorted((o1, o2)-> (int) (o1.getSalary()-o2.getSalary()))
                .collect(Collectors.toList()).forEach(System.out::println);


        System.out.println("---------------------Employee Sorting by ID Descending order ---------------------------");

        employeeList.stream().sorted((o1, o2)->o2.getId()-o1.getId())
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("---------------------Employee Sorting by Name Descending order---------------------------");
        employeeList.stream().sorted((o1, o2)->o2.getName().compareTo(o1.getName()))
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("---------------------Employee Sorting by Salary Descending order---------------------------");
        employeeList.stream().sorted((o1, o2)-> (int) (o2.getSalary()-o1.getSalary()))
                .collect(Collectors.toList()).forEach(System.out::println);

        employeeList.stream().sorted(Comparator.comparingLong(Employee::getSalary))
                .collect(Collectors.toList()).forEach(System.out::println);

        employeeList.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed())
                .collect(Collectors.toList()).forEach(System.out::println);


        employeeList.stream().sorted(Comparator.comparingInt(Employee::getId))
                .collect(Collectors.toList()).forEach(System.out::println);

        employeeList.stream().sorted(Comparator.comparingInt(Employee::getId).reversed())
                .collect(Collectors.toList()).forEach(System.out::println);

        employeeList.stream().sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList()).forEach(System.out::println);

        employeeList.stream().sorted(Comparator.comparing(Employee::getName).reversed())
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}
