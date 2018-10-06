package concurrent.thread;

public class ThreadBase extends Thread {

	private int total = 10;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (total > 0) {
				System.out.println(Thread.currentThread().getName() + " 的总数是： " + total--);
			} else {
				System.out.println(Thread.currentThread().getName() + "卖完了");
			}
		}

		
	}
	
}