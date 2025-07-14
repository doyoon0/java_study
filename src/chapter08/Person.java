package chapter08;

public class Person extends Client {
	String name;
	String address;
	String phone;
	int age;
	
	public Person() {
		this("이순신", "강남구", "010-1234-1234", 20);
	}

	public Person(String name, String address, String phone, int age) {
		//name, age 필드는 부모클래스에서 사용!!
		//Person이 상속한 부모 클래스의 생성자를 호출하는 메서드 super() 즉, 생성자에서만 호출가능. 
		//super()가 가장 먼저 호출되어야한다. 부모가 먼저 만들어져야 하니까.
		//public Client(String name, int age) 얘를 호출하는것이다.
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}
	
	@Override
	public void register() {
		System.out.println(name + " 고객이 접수를 한다.");
	}
	
	@Override
	public void payment() {
		System.out.println("결제한다.");
	}
	
	@Override
	public void printInfo() { //부모가 가진 메소드를 똑같은 모습으로 가져옴 - 오버라이딩(Overriding)
		System.out.print("고객(Person)정보 --> ");
		System.out.print(name + ", ");
		System.out.print(age + ", ");
		System.out.print(address + ", ");
		System.out.print(phone + "\n");
	}
}
