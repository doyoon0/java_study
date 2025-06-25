package chapter03;

//import java.lang.String; 

public class Variable {
	public static void main(String[] args) {
		// 기본 자료형 변수 정의
		int age = 10;
		double aged = 10.0;
		boolean flag = true; //true(1), false(0)
		char name = '홍'; //문자(''), 문자열("")
		char name2 = '길';
		char name3 = '동';
		
		// 출력
		System.out.println("age : " + age);
		System.out.println("aged : " + aged);
		System.out.println("flag : " + flag);
		System.out.println("name : " + name);
		System.out.println("full name : " + name + name2 + name3);
		
		// 참조 자료형 변수 정의
		String sname = new String("홍길동"); //참조형(Heap) 
		
		// String 클리스는 기본형과 참조형으로 모두 사용 가능!!
		String sname2 = "홍길동";
		
		// 출력
		System.out.println("sname : " + sname);
		System.out.println("sname2 : " + sname2);
		
	}
}
