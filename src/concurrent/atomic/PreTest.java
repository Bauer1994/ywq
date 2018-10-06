
package concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;
//@Deprecated
public class PreTest {
	//@Deprecated

	static int testValue4Non = 0;
	static volatile int testValue4Volatile = 0;
	static AtomicInteger at = new AtomicInteger(0);

	
	//@Deprecated
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10000; i++) {
			new Thread() {
				public void run() {
					testValue4Non++;
				}
			}.start();
		}
		Thread.sleep(1000);
		System.out.println("non :" + testValue4Non);
		
		for (int i = 0; i < 10000; i++) {
			new Thread() {
				public void run() {
					testValue4Volatile++;
				}
			}.start();
		}
		Thread.sleep(1000);
		System.out.println("testValue4Volatile :" + testValue4Volatile);
		
		for (int i = 0; i < 10000; i++) {
			new Thread() {
				public void run() {
					at.incrementAndGet();
				}
			}.start();
		}
		Thread.sleep(1000);
		System.out.println("testAtomicInteger :" + at.intValue());
	}
}
