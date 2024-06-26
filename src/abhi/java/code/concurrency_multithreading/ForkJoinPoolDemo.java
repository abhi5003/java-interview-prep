package abhi.java.code.concurrency_multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        Fibonacci fib=new Fibonacci(10);
//		int res=fib.compute();
//		System.out.println(res);

		int n = 10; // Fibonacci number to calculate
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Fibonacci task = new Fibonacci(n);

		int result = forkJoinPool.invoke(task);
		System.out.println("Fibonacci(" + n + ") = " + result);
	}

}

// Fork join pool can use for recursive task like sorting, tree traversal
// matrix multiplication etc


class Fibonacci extends RecursiveTask<Integer>{
	final int n;
	Fibonacci(int n){
		this.n=n;
	}
	
	public Integer compute() {
		if(n<=1) return n;
		
		Fibonacci f1=new Fibonacci(n-1);
		f1.fork();
		
		Fibonacci f2=new Fibonacci(n-2);
		f2.fork();
		
		return f1.join()+f2.join();
	}
}
