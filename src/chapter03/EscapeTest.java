package chapter03;

/*
 * 제어문자 실습 : 앞에 백슬래시(\) 붙여준다
 */
public class EscapeTest {
	public static void main(String[] arg) {
		String greet = "안녕하세요~ \n\n반갑습니다. \t\t홍길동입니다.";
		String name = "\"홍길동\"";

		System.out.println(greet);
		System.out.println(name);
	}
}
