package chapter04;
/*
 * 비교 연산자 : >, >=, <, <=, ==, !=
 * 비교 연산자의 실행 결과는 boolean 타입으로 리턴되며, 제어문 if, while 조건식에 사용됨
 */
public class OpComparisonTest {

	public static void main(String[] args) {
		int number1 = 5;
		int number2 = 2;
		boolean result = number1 == number2;
				
		System.out.println("result : " + result); //false
		System.out.println(number1 > number2); //true
		System.out.println(number1 >= number2); //true
		System.out.println(number1 < number2); //false
		System.out.println(number1 <= number2); //false
		System.out.println(number1 == number2); //false
		System.out.println(number1 != number2); //true
		
	}

}
