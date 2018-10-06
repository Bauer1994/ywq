package concurrent.lock;

import java.util.concurrent.CyclicBarrier;

/**
 * ��������
 * @author YWQ
 *
 */
public class CyclicBarrierTest {

	private static CyclicBarrier barrier = new CyclicBarrier(3);

	public static void main(String[] args) {

		System.out.println("main start!");
		new MyThread("ta", barrier).start();
		new MyThread("tb", barrier).start();
		new MyThread("tc", barrier).start();

		System.out.println("main finish!");

	}

	private static class MyThread extends Thread {

		private String name;

		private CyclicBarrier barrier;

		public MyThread(String name, CyclicBarrier cyclicBarrier) {
			super(name);
			this.name = name;
			this.barrier = cyclicBarrier;
		}

		@Override
		public void run() {
			try {
				String value = Thread.currentThread().getName();

				System.out.println("������" + value + " ��ʼִ�У�");

				Thread.sleep(1000);
				barrier.await();
				System.out.println("������" + value + " ִ�н�����");

			} catch (Exception e) {

			}

		}
	}

}
