package abhi.java.code.java8.lambda;


interface Printable{
    void print(String message);
}

public class LambdaEX2 {
    public static void main(String[] args) {

//        Printable printable=new Printable() {
//            @Override
//            public void print(String message) {
//                System.out.println(message);
//            }
//        };
//        printable.print("lambda example with single parameter");

        // Using java 8 lambda

        Printable printable=(message)-> System.out.println(message);
        printable.print("lambda example with single parameter");
    }
}
