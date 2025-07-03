package chapter07;

public class Animal {
	//Field : 전역변수
	String name;
	int age;
		
	//Constructor
	public Animal() {
		//생성자 호출시 실행되는 내용 => new Animal() 코드 실행 시 실행됨!!
		System.out.println("객체를 생성한다.");
	}
	
	//Method
	public void sleep() {
		System.out.println(name + " -> 잠을 잔다.");
	}
	
}
