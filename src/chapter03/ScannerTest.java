package chapter03;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("안녕하세요? 이름을 입력해주세요 > ");	
		String name = scan.next();
		System.out.println("이름 : " + name);		
		
		System.out.print("감사합니다. 나이도 입력해주세요 > ");	
		int age = scan.nextInt();
		System.out.println("나이 : " + age);

		System.out.print("감사합니다. 과목도 입력해주세요 > ");
		String subject = scan.next();
		System.out.println("과목 : " + subject);		
		
		scan.close();
		
	}

}
