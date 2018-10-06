package reflection.classcase;

public class Test1 {

	private String name;
	
	private Integer id;
	
	private int age;
	
	
	
	public Test1() {
	}




	public Test1(String name, Integer id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}




	@Override
	public String toString() {
		return "Test1 [name=" + name + ", id=" + id + ", age=" + age + "]";
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public static void main(String[] args) throws ClassNotFoundException {


		test2();
	}
	
	

	
	private static void test0() throws ClassNotFoundException {
		Class<?> c = new Test1().getClass();
		Class<?> c1 = Test1.class;
		Class<?> c2 = Class.forName("reflection.classcase.Test1");

		System.out.println(c.getName());
		System.out.println(c1.getName());

		System.out.println(c2.getName());

	}
	
	private static void test2() {
		Class<?> c = Test1.class;
		Test1 instance = null;
		try {
			 instance = (Test1)c.newInstance();
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
		
			e.printStackTrace();
		}

		System.out.println(instance.toString());
	}
}
