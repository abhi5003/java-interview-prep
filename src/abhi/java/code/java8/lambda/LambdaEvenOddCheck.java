package abhi.java.code.java8.lambda;

@FunctionalInterface
interface EvenOdd{
    void check(int num);
}
public class LambdaEvenOddCheck {
    public static void main(String[] args) {

        EvenOdd evenOdd=(num)->{
            if (num%2==0){
                System.out.println(num+" is even number");
            }else {
                System.out.println(num+" is odd number");
            }
        };

        evenOdd.check(44);
    }
}
