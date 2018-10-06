package concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerTest {
	static AtomicInteger at = new AtomicInteger(1);
	
	public static void main(String[] args) {
		System.out.println(at.intValue());
		System.out.println(at.incrementAndGet());
		System.out.println(at.get());
		System.out.println(at.getAndIncrement());
		System.out.println(at.addAndGet(6));
		System.out.println(at.decrementAndGet());
		System.out.println(at.getAndDecrement());
		System.out.println(at.compareAndSet(7, 1));
		System.out.println(at.getAndSet(6));
		System.out.println(at.get());


		System.out.println("---------------------------");
		test4AtomitIntegerArray();
	}
	
	public static void test4AtomitIntegerArray() {

		int[] value = new int[] { 1, 2 };
  
	    AtomicIntegerArray ai = new AtomicIntegerArray(value);
  
		ai.getAndSet(0, 3);

		System.out.println(ai.get(0));
	    
		System.out.println(value[0]);
		System.out.println(ai.incrementAndGet(0));
	}
	
	




	

}
