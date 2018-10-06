package concurrent.thread;

public class Synchronized4Base {

	public synchronized void fun1() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + ": non-static func 1");
		}

	}

	public synchronized void fun2() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + ": non-static func 2");
		}
	}

	public static synchronized void fun3() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + ": static func 1");
		}
	}

	public static synchronized void fun4() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + ": static func 2");
		}
	}
}
