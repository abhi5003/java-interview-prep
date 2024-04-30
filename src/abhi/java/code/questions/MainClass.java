package abhi.java.code.questions;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {
      List<Integer> nums= Arrays.asList(2, 3, 3, 11, 17, 5, 8, 17, 10, 47, 23, 74);

        // list of employee
        List<Employee> listOfEmp= new ArrayList<>();

        // populating employee list
        listOfEmp.add(new Employee(1, "Ashok", 10000));
        listOfEmp.add(new Employee(4, "Rounak", 40000));
        listOfEmp.add(new Employee(3, "Satish", 30000));
        listOfEmp.add(new Employee(2, "Rupesh", 20000));
        listOfEmp.add(new Employee(5, "Priya", 50000));

//        System.out.println(sortEmpBySalary(listOfEmp));

      sortMapBasedUponValue();

    }

    /*
    Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
    */
    private static void evenNum(List<Integer> nums){
        nums.stream().filter(i-> i%2==0).forEach(System.out::println);
    }

    /*
    Given a list of integers, find out all the numbers starting with 1 using Stream functions?
    */
    private  static void startWithOne(List<Integer> nums){
        nums.stream().map(i->i+"").filter(i->i.startsWith("1")).forEach(System.out::println);
    }


    /*
      How to find duplicate elements in a given integers list in java using Stream functions?
    */
    private static void findDuplicate(List<Integer> nums){
        Set<Integer> set=new HashSet<>();
        nums.stream().filter(i-> !set.add(i)).forEach(System.out::println);
    }

    private static void findDuplicateWithoutSet(List<Integer> nums){

       List<Integer> duplicateNum= nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().filter(i->i.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /*
    * Given the list of integers, find the first element of the list using Stream functions?
    * */
    private static void findFirst(List<Integer> nums){
        nums.stream().findFirst().ifPresent(System.out::println);
    }

    /*
    * Find total element in list
    * */
    private static void totalCount(List<Integer> nums){
        long count=nums.stream().count();
        System.out.println(count);
    }

    /* find max element */
    private static void maxElement(List<Integer> nums){
        nums.stream().max(Integer::compare).ifPresent(System.out::println);
    }

    private static void findFirstNonRepated(){
        String input = "Java articles are Awesome";
        Character result =input.chars()
                .mapToObj(s->Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i->i.getValue()==1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();

        System.out.println(result);
    }

    private static void findFirstRepeated(){
        String input = "Java articles are Awesome";
        Character result =input.chars()
                .mapToObj(s->Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i->i.getValue()>1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();

        System.out.println(result);
    }

    private static void sortAllValues(List<Integer> nums){
        nums.stream().sorted(Integer::compare).forEach(System.out::println);
    }

    private static List<Employee> sortEmpBySalary(List<Employee> emps){
        List<Employee> sortedEmp=null;

//        // Implementation 1
//        sortedEmp= emps.stream().sorted(((o1, o2) -> (int)(o1.getSalary() - o2.getSalary())))
//               .collect(Collectors.toList());
//
//        // Implementation 2
//        Collections.sort(emps, Comparator.comparing(Employee::getSalary));

        // Implementation 3
        sortedEmp =  emps.stream().sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());

       return sortedEmp;
    }

    private static List<Employee> sortByMultipleParameter(List<Employee> emps){

        List<Employee> sortedEmp=null;

        // Implementation 1
        emps.sort(Comparator.comparing(Employee::getId).thenComparing(Employee::getSalary)
                .thenComparing(Employee::getName));

/*
        // Implementation 2
        Collections.sort(emps, Comparator.comparing(Employee::getId).thenComparing(Employee::getSalary)
                .thenComparing(Employee::getName));

        // Implementation 3
        emps.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getId));


       // Implementation 4
        Comparator<Employee> sortByName=((o1, o2) -> o1.getName().compareTo(o2.getName()));
        Comparator<Employee> sortById= ((o1, o2) -> o1.getId() - o2.getId());
        Comparator<Employee> sortBySalary= ((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()));

        emps.stream().sorted(sortByName.thenComparing(sortById).thenComparing(sortBySalary));
*/
        return emps;

    }

    private static void sortDescending(@NotNull List<Integer> nums){
        nums.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static boolean checkDistinct(List<Integer> nums){
        Set<Integer> set=new HashSet<>();

        nums.stream().filter(i->!set.add(i)).collect(Collectors.toSet());
        if(set.size()==nums.size()){
            return true;
        }

        return false;
    }

    private static void currentDataAndTime(){
        System.out.println("Current date "+ " "+ LocalDate.now());
        System.out.println("Current date "+ " "+ LocalTime.now());
        System.out.println("Current date "+ " "+ LocalDateTime.now());
    }

    private static void concatTwoStream(){
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");

        Stream<String> concatStream=Stream.concat(list1.stream(), list2.stream());
        System.out.println(concatStream);
    }

    private static void CubeAndFilterExample(List<Integer> nums){
        nums.stream().map(i->i*i*i).filter(i->i>50).forEach(System.out::println);
    }

    private static void convertToUpperCase(){
        List<String> listOfString = Arrays.asList("explained", "through", "programs");

        listOfString.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    private static void groupByKeyBasedUponValueCount(){
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");

        Map<String, Long> groupby= names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(groupby);
    }

    private static void findDuplicateWithCount(){
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC", "LL", "BB");
        Map<String, Long> groupby=null;

//        Map<String, Long> groupby= names.stream().filter(i->Collections.frequency(names, i)>1L)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


           names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                   .entrySet().stream()
                   .filter(i->i.getValue()>1L)
                   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(groupby);
    }

    private static void findCountOfChars(){
         String s = "string data to count each character";
         Map<String, Long> str =Arrays.stream(s.split(""))
                 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        System.out.println(str);
    }

    private static void sortMapBasedUponValue(){
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        Map<String, Integer> result = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(result);
    }


    // String[] str={"Bangorle", "Delhi", "Pune", "Noiad", "Pune", "Delhi"};
    private Map<String, Long> countOcuances(String[] str){
       Map<String, Long> mapOccur=Arrays.stream(str).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return mapOccur;
    }


}
