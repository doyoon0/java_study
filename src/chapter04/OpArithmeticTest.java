package chapter04;

/*
 * 사칙 연산자 : +, -, *, /, % 
 */
public class OpArithmeticTest {

	public static void main(String[] args) {
		int number1 = 5;
		int number2 = 2;
		
		System.out.println("number1 + number2 = " + (number1 + number2)); //괄호 없으면 접합연산자로 인식
		System.out.println("number1 - number2 = " + (number1 - number2)); 
		System.out.println("number1 * number2 = " + (number1 * number2)); 
		System.out.println("number1 / number2 = " + (number1 / number2)); 
		System.out.println("number1 % number2 = " + (number1 % number2)); 
		
	}

}
