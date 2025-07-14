package chapter08;

public class Triangle extends Shape implements ShapeInterface {
	public Triangle(String color) {
		super(color);
	}
	
	@Override
	public void draw() {
		System.out.println(color + "삼각형을 그립니다.");
	}

	@Override
	public double getArea() {
		return 0.0;
	}
}
