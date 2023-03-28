package abhi.java.code.concurrency_multithreading;

import java.util.concurrent.RecursiveTask;

public class ForkJoinPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
