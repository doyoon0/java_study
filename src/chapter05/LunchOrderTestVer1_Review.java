package chapter05;

import java.util.Scanner;

public class LunchOrderTestVer1_Review {

	public static void main(String[] args) {
		while(true) {
			//메뉴판
			System.out.println("*********************************************");
			System.out.println("\t Welcome to Food Mart!!!");
			System.out.println("*********************************************");
			System.out.println("\t 1. 햄버거(🍔):100 2. 피자(🍕):200");
			System.out.println("\t 3. 라멘(🍜):300\t 4. 샐러드(🥗):400");
			System.out.println("\t 9. 나가기");
			System.out.println("*********************************************");
			
			//0. 변수 선언
			String menuName = "";
			String testYN = "";
			int menuPrice = 0;
			int choice = 0;
			int charge = 0;
			int change = 0;
			
			Scanner scan = new Scanner(System.in);
					
			//1. 메뉴 주문
			while(true) {
				System.out.print("주문하실 메뉴를 선택해주세요.(숫자) > ");
				
				if(scan.hasNextInt()) {
					choice = scan.nextInt();
					
					switch(choice) {
					case 1:
						menuName = "햄버거(🍔)"; 
						menuPrice = 100;
					break;
					case 2:
						menuName = "피자(🍕)"; 
						menuPrice = 200;
					break;
					case 3:
						menuName = "라멘(🍜)"; 
						menuPrice = 300;
					break;
					case 4:
						menuName = "샐러드(🥗)"; 
						menuPrice = 400;
					break;
					case 9:
						System.out.println("-- 시스템을 종료합니다. --");
						System.exit(0);
					break;
					default:
						System.out.println("⚠️메뉴가 준비중 입니다. 다시 입력해주세요.");
						continue; // 루프 처음으로 돌아감
					}
					break; //정상 메뉴 선택 > 루프 탈출
				} else {
					System.out.println("⚠️잘못된 입력값 입니다. 숫자를 입력해주세요");
					scan.next();
				}
			}
			
			//2. 주문 메뉴 결제
			System.out.print("주문하신 메뉴는 " + menuName + ", 가격은 " + menuPrice + "원 입니다.");
			
			while(true) {
				System.out.print("지불하실 금액을 입력해주세요. > ");
				
				if(scan.hasNextInt()) {	
					charge += scan.nextInt(); //입력받은 금액 누적
					
					if(charge >= menuPrice) {
						change = charge - menuPrice;
						break; //지불 완료 > 루프 종료
					} else {
						System.out.println("금액이 부족합니다. 부족한 금액 : "+ (menuPrice - charge) + "원.");
					}
				} else {
					System.out.println("잘못된 입력값 입니다.");
					scan.next(); //잘못된 입력 버림
				}
			}
			
			//3. 주문 내역 출력 : 주문한 메뉴(), 결제금액(), 잔돈() 입니다.
			System.out.println("주문하신 메뉴는 " + menuName + ", 내신 금액은 " + charge + "원 이며, 잔돈은 " + change + "원 입니다." );
			System.out.println("다시 테스트 하시겠습니까? Y/N >");
			
			while(true) {
				if(scan.hasNext()) {
					testYN = scan.next();
					
					if(testYN.equalsIgnoreCase("y")) {
						break;
					} else if (testYN.equalsIgnoreCase("n")){
						System.out.println("테스트가 종료되었습니다.");
						scan.close();
						System.exit(0);
					} else {
						
					}
				} else {
					System.out.println("y/n만 입력해주십시오.");
				}
			}
		}
	}
	

}
