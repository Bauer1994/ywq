package concurrent.thread;

/**
 * yield�����ó���
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
			//����һ�������ϵĶ������������ó�CPU
//				for (int i = 0; i < 3; i++) {
//					System.out.println(Thread.currentThread().getName() + " " + getPriority() + " " + i);
//
//					if (i%2 == 0)
//						 Thread.yield();
//					
//				}
//			}
			
			
			//���ó�CPU
			for (int i = 0; i < 3; i++) {
				System.out.println(Thread.currentThread().getName() + " " + getPriority() + " " + i);

				if (i%2 == 0)
					 Thread.yield();
				
			}	
			
		}

		
	}
}
