package concurrent.thread;

public class ThreadBase4Synchronized extends Thread {

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(100);// ����100ms
					System.out.println(Thread.currentThread().getName() + " ���ܴ����ǣ� " + i);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				} 
				
			}
		}
		

		
	}
	
}