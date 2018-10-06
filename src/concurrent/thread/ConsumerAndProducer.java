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
	//����
	private int capacity;
    //ʵ������
	private int size;

	public Repository(int capacity) {
		this.capacity = capacity;
		this.size = 0;
	}

	public synchronized void produce(int val)  {
		// left ��ʾ����Ҫ������������(�п���������̫�࣬��������)
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
			 // ֪ͨ�������ߡ����������ˡ�
			  System.out.println( Thread.currentThread().getName() + " ������ " + val + "��ʣ�� " + left + " δ������" + "�ֿ����� "+increment +"���ڲֿ��С"+  size);
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
			System.out.println( Thread.currentThread().getName() + " ���M�� " + val + "��ʣ�� " + left + " δ���ѣ�" + "�ֿ���� "+decrement +"���ڲֿ��С"+  size);

			notifyAll();
		}
		

	}
}