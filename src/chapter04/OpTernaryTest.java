package chapter04;

import java.util.Scanner;

/*
 * 삼항연산자 : (조건식) ? 결과1 : 결과2 ; 
 */
public class OpTernaryTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("점수> ");
		int score = input.nextInt();
		
		//score가 60점 이상이면 "합격", 이하면 "불합격". 해당 결과를 result 변수에 대입함
		String result = (score >= 60) ? "합격": "불합격";
		System.out.println(result);
		
		System.out.print("점수> ");
		int score2 = input.nextInt();
		
		//score가 60점 이상이면 "합격", 이하면 "불합격". 해당 결과를 result 변수에 대입함
		String result2 = (score2 >= 60) ? "합격": "불합격";
		System.out.println(result2);

		
		input.close();
	}

}
