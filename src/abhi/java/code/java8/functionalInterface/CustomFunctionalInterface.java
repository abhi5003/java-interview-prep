package abhi.java.code.java8.functionalInterface;

@FunctionalInterface
interface Printable{
    void print(String message);
}
public class CustomFunctionalInterface {
    public static void main(String[] args) {

/*
        Printable printable=new Printable() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        };
        printable.print("Printing ...");

*/
        // Using lambda function
        Printable printable=(message)-> System.out.println(message);
        // Calling the print function
        printable.print("Printing...");
    }
}
