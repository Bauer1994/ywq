package concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
	public static void main(String[] args) {

		Person p1 = new Person(1);
		Person p2 = new Person(2);
		Person p3 = new Person(3);
		AtomicReference<Person> ar = new AtomicReference<>(p2);
		System.out.println(ar.compareAndSet(p1, p3));
		System.out.println(ar.get().toString());
		System.out.println(ar.get().equals(p3));	
		System.out.println(ar.get().equals(p2));

		
		
	}
}

class Person {
    volatile long id;
    public Person(long id) {
        this.id = id;
    }
    public String toString() {
        return "id:"+id;
    }
}
