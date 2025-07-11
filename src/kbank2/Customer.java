package kbank2;

import java.util.Scanner;

public class Customer {
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	private AccountPaperVo accountPaper;
	private Scanner scan;
	
	public Customer() {}
	public Customer(String name, String accountNumber, String password, int money) {
		this.name = "[고객 : " + name + "]";
		this.accountNumber = accountNumber;
		this.password = password;
		this.money = money;
		this.scan = new Scanner(System.in);
		
		System.out.println(this.name + " 입장!");
	}
	
	/**
	 * 은행직원이 유효성 체크 후 빠진 고객정보를 물어보면, 해당하는 답변(입력)을 한다.
	 */
	public AccountPaperVo answer(int checkResult) {
		switch(checkResult) {
			case BankMan.ACCOUNT_NAME: 
				System.out.print(this.name + "고객명 > ");
				accountPaper.setName(scan.next());
				break;
			case BankMan.ACCOUNT_NUMBER: 
				System.out.print(this.name + "계좌번호 > ");
				accountPaper.setAccountNumber(scan.next());
				break;
			case BankMan.ACCOUNT_PASSWORD: 
				System.out.print(this.name + "비밀번호 > ");
				accountPaper.setPassword(scan.next());
				break;
			case BankMan.ACCOUNT_MONEY: 
				System.out.print(this.name + "금액 > ");
				accountPaper.setMoney(scan.nextInt());
				break;
		}
		return accountPaper; //맨 처음 가지고온 공유하는 종이인것
	}
	
	
	//Getter and Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public AccountPaperVo getAccountPaper() {
		System.out.println(this.name + " 은행직원에게 출금용지 전달!");
		return accountPaper;
	}
	public void setAccountPaper(AccountPaperVo accountPaper) { //고객이 용지에 정보기입
		// 지역변수에만 값 넣고 전역변수에 주소 안넣으면 안대.. 주소는 공유되지만 넣어지지만 전역변수는 null 일거임
//		accountPaper.setName(this.name);
//		accountPaper.setAccountNumber(this.accountNumber);
//		accountPaper.setPassword(this.password);
//		accountPaper.setMoney(this.money);
		
		//this.accountPaper = accountPaper; // 이 코드가 있으면 전역변수에 들어가겠지
		
		this.accountPaper = accountPaper;
		this.accountPaper.setName(this.name);
		this.accountPaper.setAccountNumber(this.accountNumber);
		this.accountPaper.setPassword(this.password);
		this.accountPaper.setMoney(this.money);
		
		System.out.println(this.name + " 출금용지에 출금정보 작성 완료!");
	}
	public Scanner getScan() {
		return scan;
	}
	public void setScan(Scanner scan) {
		this.scan = scan;
	}
	
}
