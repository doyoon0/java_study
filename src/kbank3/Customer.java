package kbank3;

import java.util.Scanner;

public class Customer {
	Scanner scan = new Scanner(System.in);
	
	//고객이 출금용지에 이름, 계좌번호, 비밀번호를 작성함.
	public AccountPaperVo write() {
		System.out.print("=> [이름]을 작성해주세요 > ");
		String name = scan.next();
		
		System.out.print("=> [계좌번호]를 작성해주세요 > ");
		int accountNum = scan.nextInt();
		
		System.out.print("=> [비밀번호]를 작성해주세요 > ");
		int pwd = scan.nextInt();
		
		AccountPaperVo paper = new AccountPaperVo(name, accountNum, pwd);
		
		return paper;
	}
	
	public int withdrawal() {
		System.out.print("=> [금액입력] > ");
		int amount = scan.nextInt();
		
		return amount;
	}
}
