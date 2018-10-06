package concurrent.thread;

public class ConsumerAndProducer {

	public static void main(String[] args) {
		Repository repository = new Repository(20);
		Producer producer = new Producer(repository);
		Consumer consumer = new Consumer(repository);
		
		producer.produce(10);
		consumer.consume(12);
		producer.produce(21);
		//consumer.consume(23);
		
	}
}

class Producer{

	private Repository repository;
	
	public Producer(Repository repository) {
		
		this.repository = repository;
	}
	
	
	public Producer() {
		super();
	}


	public void produce(final int val) {
		new Thread(){

			@Override
			public void run() {
				repository.produce(val);
			}
			
		}.start();
	}

	
}

class Consumer  {

	private Repository repository;
	
	public Consumer(Repository repository) {
		
		this.repository = repository;
	}
	
	
	public Consumer() {
		super();
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
	//容量
	private int capacity;
    //实际数量
	private int size;

	public Repository(int capacity) {
		this.capacity = capacity;
		this.size = 0;
	}

	public synchronized void produce(int val)  {
		// left 表示“想要生产的数量”(有可能生产量太多，需多此生产)
		int left = val;
		while (left > 0) {
			while (size >= capacity)
				try {
					wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			int increment = (size + left) > capacity ? (capacity -size):  left;
			size+=increment;
			left = left - increment;
			 // 通知“消费者”可以消费了。
			  System.out.println( Thread.currentThread().getName() + " 生产了 " + val + "，剩余 " + left + " 未生产，" + "仓库增加 "+increment +"现在仓库大小"+  size);
			notifyAll();
		}
	}
	
	public synchronized void consume(int val){
		int left = val;
		while (left > 0) {
			while (capacity <= left)
				try {
					wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			
			int decrement = (size - left ) < 0 ? (size -0):left;
			size-=decrement;
			left = left-decrement;
			System.out.println( Thread.currentThread().getName() + " 消費了 " + val + "，剩余 " + left + " 未消费，" + "仓库减少 "+decrement +"现在仓库大小"+  size);

			notifyAll();
		}
		

	}
}