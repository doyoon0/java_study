package chapter07;

public class SingletonTest {

	public static void main(String[] args) {
//		Singleton singleton = new Singleton();	//생성자가 private으로 접근제어 됨
		
		Singleton singleton = Singleton.getInstance();
		singleton.setName("싱글톤");
		
		System.out.println("name : " + singleton.getName());
	}

}
