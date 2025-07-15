package chapter08;

public class ObjectTypeCastingTest {

	public static void main(String[] args) {
		Circle yellowC = new Circle("노랑", 1);
		Rectangle blueR = new Rectangle("파랑",1, 2);
		
		// 부모의 내용을 받아 자식이 확장되는 것이므로 메모리의 비율은 자식이 더 크다.
		Shape s = new Circle("초록색", 2); //자동(묵시적) 형변환
		Circle cs = (Circle)s; //강제(명시적) 형변환 O
//		Rectangle t = new Circle("초록색", 2); 에러남
//		Rectangle r = (Rectangle)s; Circle 타입으로 생성해놨는데 Rectangle로 만들수 없음. : 생성된 같은 모습의 자식만 가능!!
		
		Shape s2 = new Shape("빨강");
//		Circle cs2 = (Circle)s2; //강제(명시적) 형변환 X : 여기서 에러남
		
		//인터페이스를 통해 자식의 모습으로 객체를 구현하는것을 권장함!!
		ShapeInterface si = new Circle("코랄", 1);
		si.draw(); //자식인 Circle의 draw()가 호출됨
		System.out.println(si.getArea());
		System.out.println();
		Circle cs3 = (Circle)si;
		cs3.draw(); //자식인 Circle의 draw() 호출됨
		System.out.println(cs3.getArea());

		//상속받은 인터페이스를 통한 객체 생성 : 인터페이스 기반 설계!!!!!
		//사각형, 삼각형
		ShapeInterface rec = new Rectangle("코랄", 1, 1);
		rec.draw();
		System.out.println(rec.getArea());
		
		ShapeInterface tri = new Triangle("코랄");
		//(추상메소드) --다형성 구현 -- (상속받아 오버라이딩)
		tri.draw();
		System.out.println(tri.getArea());
		
		
		cs.draw();
//		cs2.draw();
		
		yellowC.draw();
		blueR.draw();
//		s.draw(); //Shape 클래스는 draw() 메소드를 정의하지 않음
		System.out.println(s.color);
	}

}
