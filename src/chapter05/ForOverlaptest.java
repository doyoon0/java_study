package chapter05;

import java.util.Scanner;

public class ForOverlaptest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int start = 0;
		int end = 0;
		
		System.out.println("프로그램 종료: start, end 모두 0 입력");
		
		boolean flag = true;
		
		while(flag) {		
		
			System.out.print("start > ");
			start = scan.nextInt();
			
			System.out.print("end > ");
			end = scan.nextInt();
			
			// 실행여부 채크
			if(start == 0 && end == 0) {				
				// while 블록을 빠져 나간 후 종료!!
				flag = false;
			} else {
				// 2단 ~ 5단 출력
				for(int i=1; i<10; i++) {
					for(int j=start; j<=end; j++) {
						System.out.print(j + " ✖ " + i + " = " + (i*j) + "\t");
					}
					System.out.println();
				}
				System.out.println("프로그램 종료: start, end 모두 0 입력");
			}
			
		}//while
				System.out.println("-- 프로그램 종료 --");
				System.exit(0);
	}

}
