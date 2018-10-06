package concurrent.thread;

public class Thread5 {

//	public void consume() {
//		
//	}
//	
//	public void produce() {
//		
//	}
	
	public static void main(String[] args) {
		NotifyThread n1 = new NotifyThread();
		synchronized (n1) {
			System.out.println(Thread.currentThread().getName() +  " 开始");
			n1.start();
			
			try {
				System.out.println(Thread.currentThread().getName() + " 要调用wait了");
				
      			n1.wait();
				Thread.sleep(1000); //不影响
				System.out.println(Thread.currentThread().getName() + " 调用了wait");

			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + " 结束了");
		}
	}
}

class NotifyThread extends Thread {

	@Override
	public void run() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " 调用了notify");
			this.notify();
		}
		
	}
	
}