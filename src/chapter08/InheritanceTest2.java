package chapter08;

public class InheritanceTest2 {
	public static void main(String[] args) {
		
		Circle c1 = new Circle("빨강색", 5);
		Circle c2 = new Circle("파랑색", 4);
		Rectangle r1 = new Rectangle("노랑색", 3, 4);
		Rectangle r2 = new Rectangle("초록색", 15, 23);
		Triangle t1 = new Triangle("주황색");
		
		c1.draw();
		c2.draw();
		r1.draw();
		r2.draw();
		t1.draw();
		System.out.println();
		System.out.println("파랑색 원의 넓이 : " + c2.getArea());
		System.out.println("노랑색 사각형의 넓이 : " + r1.getArea());
		System.out.println("초록색 사각형의 넓이 : " + r2.getArea());
	}
}
