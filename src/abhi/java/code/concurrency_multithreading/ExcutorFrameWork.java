package abhi.java.code.concurrency_multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorFrameWork {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ExecutorService service=  Executors.newFixedThreadPool(10);
		
		for (int i = 1; i <=100; i++) {
			service.execute( () -> {
				System.out.println("Thread Name" + Thread.currentThread().getName());
			});
		}
         
		System.out.println("Thread Name" + Thread.currentThread().getName());
	}

}


