package chapter05;

import java.util.Scanner;

public class IfOverlapTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int math = 0;
		int eng = 0;
		
		System.out.println("********************");
		System.out.println("    합격여부조회");
		System.out.println("********************");
		
		System.out.print("수학 > ");
		math = scan.nextInt();
		
		System.out.print("영어 > ");
		eng = scan.nextInt();
		
		//1. 중첩 if
		if (math >= 60) {
			if (eng >= 60) {
				System.out.println("\n합격");
			} 
		} else {
			System.out.println("\n불합격");
		}
		
		//2. 논리연산자 && 
		if(math >= 60 && eng >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}

}
