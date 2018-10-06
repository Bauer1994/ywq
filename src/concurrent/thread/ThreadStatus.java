package concurrent.thread;

public class ThreadStatus {

	/**
	 * 线程的几种状态，以及状态间的切换 五种状态：创建、就绪、运行中、阻塞、消亡 其中：阻塞又分为：等待阻塞、同步阻塞、sleep等造成的阻塞
	 * 
	 * Object的 wait notify notifyAll Thread 的sleep join interrupt getName
	 * sychronized
	 * 
	 * 几个问题：
	 * 私有变量是线程独有的，那么如何使用共享？可以使用Runnable中的变量，原因在于只new了一次
	 * 共享数据的安全性：先使用volatile，再使用sychronized，最后是Lock
	 */
	

	/**
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		t1.start();
		t2.start();
		t3.start();
	}
 */
	
	public static void main(String[] args) {
		MyRunnale r1 = new MyRunnale();
		MyRunnale r2 = new MyRunnale();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		//Thread t2 = new Thread(r2);  这样子就不能共享了，只有0和2共享

		Thread t3 = new Thread(r1);
		t1.start();
		t2.start();
		t3.start();
	}
}

class MyThread extends Thread {

	private int total = 10;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (total > 0) {
				System.out.println(getName() + " 的总数是： " + total--);
			}
		}

	}


	
}

class MyRunnale implements Runnable {

	private int total = 10;

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			if (total > 0) {
				System.out.println(Thread.currentThread().getName() + " 的总数是： " + total--);
			}
		}

	}

}
