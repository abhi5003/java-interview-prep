package abhi.java.code.java8.lambda;

@FunctionalInterface
interface Arithmetic {

    int operation(int a, int b);
}

public class LambdaEX6 {
    public static void main(String[] args) {

        // Anonymous class implementation

//        Arithmetic addition=new Arithmetic() {
//            @Override
//            public int operation(int a, int b) {
//                return (a+b);
//            }
//        };
//        System.out.println(addition.operation(12, 45));

        // Using java 8 lambda expression

        Arithmetic addition=(a, b)-> (a+b);
        System.out.println(addition.operation(34,56));
    }
}
