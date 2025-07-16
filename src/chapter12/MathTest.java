package chapter12;

public class MathTest {

	public static void main(String[] args) {
		//모든 메소드가 static으로 정의되어 있음 : 클래스명.메소드명()
		System.out.println(Math.abs(-100));
		System.out.println(Math.floor(123.4567));
		System.out.println(Math.max(100,200));
		System.out.println(Math.min(100,200));
		System.out.println(Math.floor(Math.random()*10));
		System.out.println();
	}

}
