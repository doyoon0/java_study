package chapter05;

import java.util.Scanner;

public class IfOverlapTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		boolean math_pass = false, eng_pass = false;
		
		System.out.println("********************");
		System.out.println("    합격여부조회");
		System.out.println("********************");
		
		System.out.print("수학 > ");
		math_pass = scan.nextInt() >= 60 ? true : false;
		
		System.out.print("영어 > ");
		eng_pass = scan.nextInt() >= 60 ? true : false;
		
		//1. 중첩 if
		if (math_pass) if (eng_pass) System.out.println("\n합격");
		else System.out.println("\n불합격");
		
		//2. 논리연산자 && 
		if(math_pass && eng_pass) System.out.println("합격");
		else System.out.println("불합격");
		
		scan.close();
	}

}
