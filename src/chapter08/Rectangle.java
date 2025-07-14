package chapter08;

public class Rectangle extends Shape implements ShapeInterface {
	int height;
	int width;
	
	
	public Rectangle(String color, int width, int height) {
		super(color);
		this.height = height;
		this.width = width;
	}
	
	@Override
	public void draw() {
		System.out.println(color + "사각형을 그립니다.");
	}

	@Override
	public double getArea() {
		return width * height;
	}
}
