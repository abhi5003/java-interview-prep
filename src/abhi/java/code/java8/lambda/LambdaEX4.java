package abhi.java.code.java8.lambda;


public class LambdaEX4 {
    public static void main(String[] args) {

//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Running...");
//            }
//        };
//        Thread thread=new Thread(runnable);
//        thread.start();

        Runnable runnable=()-> System.out.println("Running...");
        Thread thread=new Thread(runnable);
        thread.start();
    }
}
