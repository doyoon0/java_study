package chapter08;

public class InheritanceTest {

	public static void main(String[] args) {
//		Client c1 = new Client(); //abstract 클래스이므로 객체 생성 불가!!
		Person lee = new Person();
		Person kim = new Person("김유신", "종로구", "010-9876-9876", 12);
		Animal dog = new Animal("명수" , 5, lee);
		Animal cat = new Animal("야옹이", 6, kim);
		
//		c1.printInfo();
		lee.printInfo();
		kim.printInfo();
		dog.printInfo();
		cat.printInfo();
		
		lee.register();
		kim.register();
		dog.register();
		
		dog.sound();
		cat.sound();
	}

}
