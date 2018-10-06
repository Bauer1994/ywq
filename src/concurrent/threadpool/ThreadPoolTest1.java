package concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest1 {

	public static void main(String[] args) {
		
		ExecutorService  executor = Executors.newFixedThreadPool(2);
		executor.execute(new MyThread("a"));
		executor.execute(new MyThread("b"));

		executor.execute(new MyThread("c"));

		System.out.println(executor.isShutdown());
		System.out.println(executor.isTerminated());

		executor.shutdown();
		System.out.println(executor.isShutdown());
		System.out.println(executor.isTerminated());


	}
	
	
}

class MyThread extends Thread {

	private String name;
	
	public MyThread(String name) {
		super(name);
		
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
	}
	
}
