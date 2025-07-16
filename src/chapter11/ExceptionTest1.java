package chapter11;

import java.util.Scanner;

public class ExceptionTest1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("num1> ");
		int num1 = scan.nextInt();

		System.out.print("num2> ");
		int num2 = scan.nextInt();
		
		try {
			int result = num1/num2;
			System.out.println("result : " + result);
			
			int[] numbers = {1,2,3};
			System.out.println(numbers[5]);
			
		} catch(ArithmeticException ae) {
			System.out.println("num2는 0을 입력할 수 없습니다.");
		} catch(ArrayIndexOutOfBoundsException aae) {
			System.out.println("배열의 index 범위를 넘음");
			System.out.println(aae);
		}
		
	}

}
