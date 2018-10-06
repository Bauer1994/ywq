package concurrent.thread;

public class Thread2 {

	/**
	 * 示范sychronized的使用，这时候对象锁==同步锁，注意互斥性
	 * new一次的具有排他性，new多次就没有了（两种实现）
	
	public static void main(String[] args) {
		RunnableBase r1 =new RunnableBase();
          
          //		RunnableBase r2 =new RunnableBase();//Thread t2 = new Thread(r2);
		
		Thread t1 = new Thread(r1);
		
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
	
	}
	 */
	public static void main(String[] args) {
		//不具备互斥性
		ThreadBase4Synchronized t1 = new ThreadBase4Synchronized();
		ThreadBase4Synchronized t2 = new ThreadBase4Synchronized();
		t1.start();
		t2.start();
	}
	
}


