package concurrent.thread;

public class Thread1 {

	/**
	 * 说明start和run方法的区别
	 * 
	 */
	
	public static void main(String[] args) {
		ThreadBase t1 = new ThreadBase();
//		t1.start();t1.start();  //第二次报错
		t1.run();t1.run();
		
	}
}
