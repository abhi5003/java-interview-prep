package abhi.java.code.design_Patterns;

import java.util.*;

public class ImmutableClassDemo {

    // https://salithachathuranga94.medium.com/implement-immutable-classes-with-java-df5b5b66ffd9
    public static void main(String[] args) throws CloneNotSupportedException {

        Address address1 = new Address("s1", "c1");
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("123345");
        phoneNumbers.add("456789");
        Map<String, String> metadata = new HashMap<>();
        metadata.put("hobby", "Watching Movies");
        Employee e = new Employee("John", 23, address1, phoneNumbers, metadata);

        // modifications
        e.getAddress().setCity("c3");
        e.getAddress().setStreet("s3");
        e.getPhoneNumbers().add("1234");
        e.getMetadata().put("skill", "Java");
        e.getMetadata().put("designation", "HR");

        System.out.println(e.getEmpName());
        System.out.println(e.getAge());
        System.out.println(e.getAddress());
        System.out.println(e.getPhoneNumbers());
        System.out.println(e.getMetadata());

    }
}

final class Employee {
    private final String empName;
    private final int age;
    private final Address address;
    private final List<String> phoneNumbers;
    private final Map<String, String> metadata;

    public Employee(String name, int age, Address address, List<String> phoneNumbers, Map<String, String> metadata) {
        super();
        this.empName = name;
        this.age = age;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.metadata = metadata;
    }

    public String getEmpName() {
        return empName;
    }

    public int getAge() {
        return age;
    }

    // clone the address object
    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }

    // deep copy the list of phone numbers
    public List<String> getPhoneNumbers() {
        return new ArrayList<>(phoneNumbers);
    }

    // deep copy the map of metadata
    public Map<String, String> getMetadata() {
        return new HashMap<>(metadata);
    }
}

final class Address implements Cloneable {

    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "{Street: " + street + ", City: " + city + "}";
    }

}
