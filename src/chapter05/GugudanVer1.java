package chapter05;

import java.util.Scanner;

public class GugudanVer1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int dan = 0;
//		int end = 0;

		/*
		System.out.print("몇 단을 출력하시겠습니까? > ");
		dan = scan.nextInt();
		
		//구구단 2단 출력
		for (int i = dan; i < dan+1; i++) {
			System.out.println("\n-- " + i + "단 --");
			for (int j = 1; j < 9; j ++) {
				System.out.println(i + "❌" + j + "=" + (i*j));
			}
		}
		*/

		System.out.println("출력하실 구구단을 입력해주세요.");

		while(true) {
			System.out.print("dan(종료:0)> ");
			
			dan = scan.nextInt();
			
			if(dan != 0) {
				// dan 변수값이 0이 아닌 경우 : 구구단 출력
				System.out.println("\n" + dan + "단");
				System.out.println("-------------------");
				for (int i=1; i<=9; i++) {
					System.out.println(dan + " * " + i + " = " + (i*dan));
				}
			} else {
				// dan 변수값이 0 경우 : 프로그램 종료
				System.out.println("- 프로그램 종료 -");
				System.exit(0);
			}
			
			
		}//while
		
	}//main

}//class
