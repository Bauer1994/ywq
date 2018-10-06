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
			System.out.println(Thread.currentThread().getName() +  " ��ʼ");
			n1.start();
			
			try {
				System.out.println(Thread.currentThread().getName() + " Ҫ����wait��");
				
      			n1.wait();
				Thread.sleep(1000); //��Ӱ��
				System.out.println(Thread.currentThread().getName() + " ������wait");

			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + " ������");
		}
	}
}

class NotifyThread extends Thread {

	@Override
	public void run() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " ������notify");
			this.notify();
		}
		
	}
	
}