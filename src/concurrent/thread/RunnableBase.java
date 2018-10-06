package concurrent.thread;

public class RunnableBase implements Runnable {

	@Override
	public void run() {

		synchronized(this) {
			for (int i = 0; i < 5; i++) {
				
					try {
						Thread.sleep(100);// 休眠100ms
						System.out.println(Thread.currentThread().getName() + " 的总次数是： " + i);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					} 
					
			
		}
		

	}

}
}
