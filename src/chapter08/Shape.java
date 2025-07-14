package chapter08;

/*
 * 추상 클래스를 따로 모아놓은 interface가 있으니, Shape는 일반 클래스로 사용할 수 있다.
 */
public class Shape {
	String color;
	
	protected Shape(String color) {
		this.color = color;
	}
}
