package concurrent.thread;

public class Thread1 {

	/**
	 * ˵��start��run����������
	 * 
	 */
	
	public static void main(String[] args) {
		ThreadBase t1 = new ThreadBase();
//		t1.start();t1.start();  //�ڶ��α���
		t1.run();t1.run();
		
	}
}
