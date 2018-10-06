package concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentantLockTest {

	public static void main(String[] args) {
		Repository r = new Repository();
		Producer p = new Producer(r);
		Consumer c = new Consumer(r);
		p.produce(13);
		c.consume(1);
		p.produce(11);
		c.consume(19);
	}
}

class Producer {
	private Repository repository;

	public Producer(Repository repository) {
		this.repository = repository;
	}

	public void produce(final int val) {
		new Thread() {
			public void run() {
				repository.produce(val);
			}
		}.start();
	}
}

class Consumer {
	private Repository repository;

	public Consumer(Repository repository) {
		this.repository = repository;
	}

	public void consume(final int val) {
		new Thread() {
			public void run() {
				repository.consume(val);
			}
		}.start();
	}
}

class Repository {
	private int capacity;
	private int size;
	private Lock lock;
	private Condition fullCondition;
	private Condition emptyCondition;

	public Repository() {

		this.capacity = 20;
		this.size = 0;
		this.lock = new ReentrantLock();
		this.fullCondition = lock.newCondition();
		this.emptyCondition = lock.newCondition();

	}

	public void consume(int val) {
		lock.lock();
		try {

			int left = val;
			while (left > 0) {
				while (size <= 0)
					emptyCondition.await();
				int decrement = (size - left) > 0 ? left : size ;
				left -= decrement;
				size -= decrement;
				System.out.println(Thread.currentThread().getName() + " 消费了"
						+ decrement + ",现在的大小： " + size);

				fullCondition.signal();
			}

		} catch (Exception e) {

		} finally {
			lock.unlock();
		}

	}

	public void produce(int val) {
		lock.lock();
		try {
			int left = val;
			while (left>0) {
				while (size >= capacity) 
					fullCondition.await();
				int increment = ( left + size ) <= capacity ? left: (capacity - size);
				left -=increment;
				size+=increment;
				System.out.println( Thread.currentThread().getName() + "生产了" + increment + ",现在的大小： " + size);
			
				emptyCondition.signal();
			}
		} catch(Exception e) {
			}finally  {
		}
			lock.unlock();
		}

	}
