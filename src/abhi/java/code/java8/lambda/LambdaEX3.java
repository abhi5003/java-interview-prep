package abhi.java.code.java8.lambda;

interface Addable{
    int add(int a, int b);
}
public class LambdaEX3 {
    public static void main(String[] args) {

//        Addable addable=new Addable() {
//            @Override
//            public int add(int a, int b) {
//                return a+b;
//            }
//        };
//        System.out.println(addable.add(34, 39));

        Addable addable=((a, b) -> a+b);
        System.out.println( addable.add(45, 56));
    }
}
