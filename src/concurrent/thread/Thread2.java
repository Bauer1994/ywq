package concurrent.thread;

public class Thread2 {

	/**
	 * ʾ��sychronized��ʹ�ã���ʱ�������==ͬ������ע�⻥����
	 * newһ�εľ��������ԣ�new��ξ�û���ˣ�����ʵ�֣�
	
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
		//���߱�������
		ThreadBase4Synchronized t1 = new ThreadBase4Synchronized();
		ThreadBase4Synchronized t2 = new ThreadBase4Synchronized();
		t1.start();
		t2.start();
	}
	
}


