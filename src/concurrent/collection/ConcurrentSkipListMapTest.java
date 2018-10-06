package concurrent.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapTest {

	//private static Map<String, String> map = new TreeMap<>();

	private static Map<String, String> map = new ConcurrentSkipListMap<>();
	public static void main(String[] args) throws InterruptedException {
		MyThread m1 = new MyThread("ta");
		MyThread m2 = new MyThread("tb");
		m1.start();
		
		m2.start();
		Thread.sleep(1000);
		System.out.println(map.size());
		printAll();
		
	}
	
	public static void printAll() {
		
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			System.out.print(entry.getKey() + "-" + entry.getValue() + " ");
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
				map.put(value + "-" + i, "hao");
				printAll();
			}
		}
		
	}
}
