package chapter07;

/*
 * 생성자 오버로딩, this() 메소드
 */
public class Animal3 {
	//Field
	int age;
	String name;
	String addr;
	
	//Constructor
	public Animal3() {
		this("홍길동", 5, "강남구");
	}
	public Animal3(int age) {
		this("홍길동", age, "강남구");
	}
	public Animal3(String name) {
		this(name, 5, "강남구"); //같은 클래스의 다른 생성자를 호출
//		this.name = name;
//		this.age = 5;
//		this.addr = "강남구";
	}
	public Animal3(String name, int age) {
		this(name, age, "강남구");
	}
	public Animal3(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	//Method
	public void info() {
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println("addr = " + addr);
	}
}
