package concurrent.thread;

public class ThreadStatus {

	/**
	 * �̵߳ļ���״̬���Լ�״̬����л� ����״̬�������������������С����������� ���У������ַ�Ϊ���ȴ�������ͬ��������sleep����ɵ�����
	 * 
	 * Object�� wait notify notifyAll Thread ��sleep join interrupt getName
	 * sychronized
	 * 
	 * �������⣺
	 * ˽�б������̶߳��еģ���ô���ʹ�ù�������ʹ��Runnable�еı�����ԭ������ֻnew��һ��
	 * �������ݵİ�ȫ�ԣ���ʹ��volatile����ʹ��sychronized�������Lock
	 */
	

	/**
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		t1.start();
		t2.start();
		t3.start();
	}
 */
	
	public static void main(String[] args) {
		MyRunnale r1 = new MyRunnale();
		MyRunnale r2 = new MyRunnale();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		//Thread t2 = new Thread(r2);  �����ӾͲ��ܹ����ˣ�ֻ��0��2����

		Thread t3 = new Thread(r1);
		t1.start();
		t2.start();
		t3.start();
	}
}

class MyThread extends Thread {

	private int total = 10;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (total > 0) {
				System.out.println(getName() + " �������ǣ� " + total--);
			}
		}

	}


	
}

class MyRunnale implements Runnable {

	private int total = 10;

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			if (total > 0) {
				System.out.println(Thread.currentThread().getName() + " �������ǣ� " + total--);
			}
		}

	}

}
