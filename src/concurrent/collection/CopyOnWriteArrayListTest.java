package concurrent.collection;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {

	//private static List<String> list = new ArrayList<>(); »á±¨´í

	private static List<String> list = new CopyOnWriteArrayList<>();
	
	public static void main(String[] args) throws InterruptedException {
		MyThread m1 = new MyThread("ta");
		MyThread m2 = new MyThread("tb");
		m1.start();
		
		m2.start();
		Thread.sleep(1000);
		System.out.println(list.size());
		printAll();
		
	}
	
	public static void printAll() {
		
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
	}
	
	private static class MyThread extends Thread {

		private String name;
		
		
		public MyThread(String name) {
			super(name);
			this.name = name;
		}


		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				String value = Thread.currentThread().getName();
				list.add(value + "-" + i + " ");
				printAll();
			}
		}
		
	}
}
