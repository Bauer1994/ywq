package concurrent.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CopyOnWriteArraySetTest {

	private static Set<String> set = new HashSet<>();
	//»á±¨´í

	//private static Set<String> set = new CopyOnWriteArraySet<>();
	
	public static void main(String[] args) throws InterruptedException {
		MyThread m1 = new MyThread("ta");
		MyThread m2 = new MyThread("tb");
		m1.start();
		
		m2.start();
		Thread.sleep(1000);
		System.out.println(set.size());
		
	}
	
	public static void printAll() {
		
		Iterator<String> it = set.iterator();
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
				set.add(value + "-" + i + " ");
				printAll();
			}
		}
		
	}
}
