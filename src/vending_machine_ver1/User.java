package vending_machine_ver1;

import java.util.Scanner;

/*
 * 명사 : 정국, 휴게소, 커피자판기, 금액, 밀크커피, 동전, 거스름돈
 * 동사 : 동전을 넣는다, 메뉴 선택한다, 메뉴와 거스름돈 받는다.
 * 
 * 사용자 : User - 이름, 동전을 넣는다, 메뉴를 선택한다.
 * 자판기 : VendingMachine - 메뉴리스트, 메뉴를 보여준다. 동전을 체크한다. 선택한 메뉴를 체크한다. 등...
 * 메뉴 : Menu - 번호, 이름, 가격
 * 휴게소 : RestArea - 사용자, 자판기, 자판기 메뉴를 보여준다.
 */
public class User {
	//Field
	String name;
	Scanner scan;
	
	//Constructor
	public User() { this("아무개"); }
	public User(String name) { 
		this.name = name;
		scan = new Scanner(System.in);
	}
	
	//Method
	
	//메뉴 선택
	public int selectMenu() {
		int menu = 0;
		System.out.print("[" + name + "]메뉴선택> ");
		if(scan.hasNextInt()) {
			menu = scan.nextInt();
		} else {
			System.out.println("=> 올바르지 않은 값, 다시 입력해주세요.");
			scan.next();
			insertCoin();
		}
		return menu;
	}
	
	//동전 투입
	public int insertCoin() {
		int resultCoin = 0;
		System.out.print("[" + name + "]동전입력> ");
		if(scan.hasNextInt()) {
			//동전 체크 : 100원, 500원만 입력 가능
			int coin = scan.nextInt();
			resultCoin = coin;
		} else {
			System.out.println("=> 올바르지 않은 값, 다시 입력해주세요.");
			scan.next();
			insertCoin();
		}
		return resultCoin;
	}
	
}
