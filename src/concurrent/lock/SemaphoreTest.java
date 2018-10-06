package concurrent.lock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		 Semaphore semaphore = new Semaphore(5); //机器数目
		 int workers = 8; //工人数
		 
		 for (int i = 0; i < workers; i++) {
			new MyThread(Integer.toString(i), semaphore).start();
		}
		 
	}
	
	private static class MyThread extends Thread {

		private String name;

		private Semaphore semaphore;

		public MyThread(String name, Semaphore semaphore) {
			super(name);
			this.name = name;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				String value = Thread.currentThread().getName();
 
			    semaphore.acquire();

				Thread.sleep(1000);
				System.out.println("子任务" + value + " 执行结束！");
			    semaphore.release();

			} catch (Exception e) {

			}

		}
	}

}
