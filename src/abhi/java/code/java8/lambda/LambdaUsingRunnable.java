package abhi.java.code.java8.lambda;

public class LambdaUsingRunnable {
    public static void main(String[] args) {

        // Using Anonymous implementation
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Running ...");
            }
        };

        Thread thread=new Thread(runnable);
        thread.start();
    }
}
