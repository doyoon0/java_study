package chapter05;

import java.util.Scanner;

/*
 * 반복문 : for(초기값선언;조건식;증감연산식) { 실행문(조건식이 true인 경우 실행);} 
 * 			조건식이 false가 되면 for 블록 종료
 * 			초기값으로 선언된 변수는 for 블록 안에서만 사용
 */
public class ForTest {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int start = 0; 
		int end = 0;
		int sum = 0;
		
		System.out.print("시작 > ");
		start = scan.nextInt();
		
		System.out.print("종료 > ");
		end = scan.nextInt() + 1;
		
		// 1~10까지 정수의 합계를 출력
		// 시작과 종료값은 실행시 외부에서 입력을 통해 진행함
		for(int i=start; i<end; i++) {	//1이상의 값을 누적합으로 대입 -> i+=값
			sum += i;
		}
		System.out.println("합계 " + sum); //for문 밖에서 사용해야 하니까 sum은 for문 밖에서 선언해야한다.
		
//		System.out.println(i);	//에러 : i의 범위는 for 블록
		System.out.println("-- for문 종료 --");
		scan.close();
	}

}

