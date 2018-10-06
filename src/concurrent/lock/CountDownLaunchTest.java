package concurrent.lock;

import java.util.concurrent.CountDownLatch;

/**
 * 配合线程池再使用一次
 * @author YWQ
 *
 */
public class CountDownLaunchTest {

	private static final int TOTAL_NUMBER = 5;
	private static CountDownLatch countDownLatch;
	
	public static void main(String[] args) throws Exception {
		countDownLatch = new CountDownLatch(TOTAL_NUMBER);
		System.out.println("main start!");
		long start = System.currentTimeMillis();
		for (int i = 0; i < TOTAL_NUMBER; i++) {
			new Thread(){
				public void run() {
					 try {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName() + " sleep 1000ms");

						countDownLatch.countDown();
						
					 } catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
		System.out.println("main await begin.");
		countDownLatch.await(); 
		System.out.println(System.currentTimeMillis()-start);
		System.out.println("main await finished.");
	}
}
