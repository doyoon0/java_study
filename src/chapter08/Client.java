package chapter08;

// abstract 메소드를 하나라도 가지고 있으면 그 클래스는 abstract 클래스가 된다.
// abstract(추상) 클래스는 객체 생성이 불가능하다.
abstract public class Client {
	public String name;
	public int age;
	
	//부모가 가진 printInfo() 메소드를 강제적으로 상속함!!
	//오버라이드 되는 메소드는 body없이 이름만 선언됨
	//body가 없는 메소드를 추상(abstract)메소드 라고 명명함
	abstract public void printInfo();
	abstract public void register();
	abstract public void payment();
}
