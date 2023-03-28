package abhi.java.code.concurrency_multithreading;

public class Thread1 extends Thread{
	
	// Creating thread through extending Thread class
	
	@Override
	public void run() {
		
		for (int i = 1; i <=10; i++) {
			System.out.println("Thread1 Class" +" "+ i);
		}
	}

}
