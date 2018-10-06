package concurrent.thread;

/**
 * yield不会让出锁
 * @author YWQ
 *
 */
public class Thread6 {
	
	static Object obj = new Object();
	
	public static void main(String[] args) {
		YieldThread y1 = new YieldThread();
		YieldThread y2 = new YieldThread();

		y1.start();
		y2.start();
	}
	public static class YieldThread extends Thread {

		@Override
		public void run() {
//			synchronized (obj) {   
			//加在一个对象上的对象锁，不会让出CPU
//				for (int i = 0; i < 3; i++) {
//					System.out.println(Thread.currentThread().getName() + " " + getPriority() + " " + i);
//
//					if (i%2 == 0)
//						 Thread.yield();
//					
//				}
//			}
			
			
			//会让出CPU
			for (int i = 0; i < 3; i++) {
				System.out.println(Thread.currentThread().getName() + " " + getPriority() + " " + i);

				if (i%2 == 0)
					 Thread.yield();
				
			}	
			
		}

		
	}
}
