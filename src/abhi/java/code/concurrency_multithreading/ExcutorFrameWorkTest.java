package abhi.java.code.concurrency_multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorFrameWorkTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// creates five tasks
		Runnable r1 = new Task("task 1");
		Runnable r2 = new Task("task 2");
		Runnable r3 = new Task("task 3");
		Runnable r4 = new Task("task 4");
		Runnable r5 = new Task("task 5");


		// creates a thread pool with MAX_T no. of
		// threads as the fixed pool size(Step 2)
//		ExecutorService pool = Executors.newFixedThreadPool(10);

		// threads as the single pool size

//		ExecutorService pool = Executors.newSingleThreadExecutor();

		// Cached thread pool

		ExecutorService pool = Executors.newCachedThreadPool();


		// passes the Task objects to the pool to execute (Step 3)
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);

		// pool shutdown ( Step 4)
		pool.shutdown();
	}

}

// Task that implements Runnable interface
class Task implements Runnable{

	private String name;

	public Task(String name){
		this.name=name;
	}

	@Override
	public void run() {

		try
		{
			for (int i = 0; i<=5; i++)
			{
				if (i==0)
				{
					Date d = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
					System.out.println("Initialization Time for"
							+ " task name - "+ name +" = " +ft.format(d));
					//prints the initialization time for every task
				}
				else
				{
					Date d = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
					System.out.println("Executing Time for task name - "+
							name +" = " +ft.format(d));
					// prints the execution time for every task
				}
				Thread.sleep(1000);
			}
			System.out.println(name+" complete");
		}

		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}


