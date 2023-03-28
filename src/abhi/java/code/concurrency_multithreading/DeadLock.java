package abhi.java.code.concurrency_multithreading;



public class DeadLock {
	
	public static void main(String[] args) {
		
		System.out.println("Main starting");
		
		String lock1="Abhi";
		String lock2="Kumar";
		
		Thread thread1=new Thread(() -> {
			synchronized (lock1) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				synchronized (lock2) {
					System.out.println("Lock accuried");
				}
			}
		},"thread1");
		
		
		Thread thread2=new Thread( () -> {
			synchronized (lock2) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				synchronized (lock1) {
					System.out.println("Lock accuired");
				}
			}
			
		},"thread2");
		
		
		thread1.start(); thread2.start();
		
	}

}
