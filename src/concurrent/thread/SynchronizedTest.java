package concurrent.thread;

public class SynchronizedTest {

	public static void main(String[] args) {

		SynchronizedTest test = new SynchronizedTest();
		//test.test1();
		//test.test2();
		//test.test3();
		test.test4();
	}

	public void test1() {
		final Synchronized4Base s1 = new Synchronized4Base();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				s1.fun1();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				s1.fun2();

			}
		});
		
		t1.start();
		t2.start();

	}
	
	
	public void test2() {
		final Synchronized4Base s1 = new Synchronized4Base();
		final Synchronized4Base s2 = new Synchronized4Base();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				s1.fun1();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				s2.fun1();

			}
		});
		
		t1.start();
		t2.start();

	}
	
	public void test3() {
		

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				Synchronized4Base.fun3();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				Synchronized4Base.fun4();

			}
		});
		
		t1.start();
		t2.start();

	}
	
	public void test4() {
		
        final Synchronized4Base s1 = new Synchronized4Base();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				Synchronized4Base.fun3();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				s1.fun4();

			}
		});
		
		t1.start();
		t2.start();

	}
}
