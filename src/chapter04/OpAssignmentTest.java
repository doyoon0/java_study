package chapter04;

/*
 * 대입연산자 - =, +=, *=, /*, %=
 */
public class OpAssignmentTest {

	public static void main(String[] args) {
		// 정수형 number 변수에 100을 대입
		int number = 100;		
		System.out.println(number);
		
		// number 변수에 10값을 중첩하여 대입
		number += 10;	//number = number + 10
		number += 10;	//number = number + 10
		System.out.println(number);
		
		// number 변수에 10을 중첩으로 빼기하여 대입
		number -= 10;
		System.out.println(number);
		
		// number 변수에 10을 중첩으로 곱하기하여 대입
		number *= 10;
		System.out.println(number);
		
		// number 변수에 10을 중첩으로 나누기하여 대입
		number /= 10;
		System.out.println(number);
		
		// number 변수에 10을 중첩으로 모듈러연산하여 대입
		number %= 3;
		System.out.println(number);
	}

}
