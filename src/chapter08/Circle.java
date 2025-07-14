package chapter08;

public class Circle extends Shape implements ShapeInterface{ //interface는 여러개 가져올수있음 ,로 연결
	int radius;
	public static final double PI = 3.14;
	
	public Circle(String color, int radius) {
		super(color);
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		System.out.println(color + "원을 그립니다.");
	}

	@Override
	public double getArea() {
		double area = 0.0;
		area = radius*radius*PI;
		return area;
	}

}
