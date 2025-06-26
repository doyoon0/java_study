package chapter05;

import java.util.Scanner;

/*
 * 변수 값을 체크하여 실행문
 * switch(변수) {
 * 	case 값1 : //변수의 값과 값1이 동일하면 실행문 실행
 * 		실행문1;
 * 		break;
 * 	case 값2 : //변수의 값과 값2가 동일하면 실행문 실행
 * 		실행문2
 * 		break;
 * 	default:
 * 		실행문; //값1, 값2 외의 다른 값인 경우 실행
 * }
 * */
public class SwitchTest {

	public static void main(String[] args) {
		// 프로그램 실행시 정수값을 입력받아 결과를 출력하시오.
		// 입력값이 1이면 사과(🍎)
		// 입력값이 2이면 오렌지(🍊)
		// 입력값이 3이면 망고(🥭)?
		// 입력값이 4이면 키위(🥝))
		// 그외의 숫자는 준비중입니다.
		Scanner scan = new Scanner(System.in);
		int number = -1;
		System.out.print("숫자> ");
		number = scan.nextInt();
		
		switch(number) {
		
			case 1:
				System.out.println("사과(🍎)");
				break;
			case 2:
				System.out.println("오렌지(🍊)");
				break;
			case 3:
				System.out.println("망고(🥭)");
				break;
			case 4:
				System.out.println("키위(🥝)");
				break;
			default:
				System.out.println("준비중입니다.");
		}
		
		System.out.println("-- 종료 --");
		
		scan.close();
	}

}
