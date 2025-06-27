package chapter05;

import java.util.Scanner;

/*
 * 반복문 : 애 { 실행문(조건식이 true인 경우에만 실행); } while(조건식)
 * 
 */
public class DoWhileTest {

	public static void main(String[] args) {
		// 1~10까지 정수의 합계를 출력
		// 시작과 종료값은 실행시 외부에서 입력을 통해 진행함
		Scanner scan = new Scanner(System.in);
		int start = 0;
		int end = 0;
		int i = 0;
		int sum = 0;
		
		System.out.print("start > ");
		i = start = scan.nextInt();
		
		System.out.print("end > ");
		end = scan.nextInt();
		
		do {
			sum += i;
			i++; //i+10
		} while(i <= end);
		System.out.println("sum = " + sum);
		
		scan.close();
	}

}
