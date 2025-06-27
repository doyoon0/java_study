package chapter05;

import java.util.Scanner;

public class DrinkOrderTestVer1 {

	public static void main(String[] args) {
		/*0. 지역 변수 선언*/
		Scanner scan = new Scanner(System.in);
		int menuNum = 0;
		int menuPrice = 0;
		int charge = 0;
		String strMenuPrice = "";
		String strCharge = "";
		String strChange = "";
		String strNeed = "";
		boolean menuFlag = true;
		boolean chargeFlag = true;
		
		/*1. 메뉴판*/
		System.out.println("[시작]");
		System.out.println("===============메뉴판==================");
		System.out.println("\t1.☕아메리카노 - 2,800원");
		System.out.println("\t2.🍵바닐라 라떼 - 3,500원");
		System.out.println("\t3.🥤딸기 쉐이크 - 4,000원");
		System.out.println("=====================================");
		
		/*2. 메뉴 고르기*/		
		//사용자 입력값에 따른 가격 설정
		
		while(menuFlag) {
			System.out.print("주문하실 메뉴 번호를 입력해주세요. > ");
			
			if(scan.hasNextInt()) {
				menuNum = scan.nextInt();
				
				switch(menuNum) {
					case 1: menuPrice = 2800;
					break;
					
					case 2: menuPrice = 3500;
					break;
					
					case 3: menuPrice = 4000;
					break;
					
					default: System.out.println("메뉴 준비중 입니다. 다른 메뉴를 입력해주세요.");
					continue;
				}
				
				menuFlag = false;
				strMenuPrice = String.format("%,d", new Object[] {Integer.valueOf(menuPrice)});
				
			} else {
				System.out.println("\n올바르지 않은 입력값 입니다. 다시 입력해주세요.");
				scan.next();
			}
		}
		
		System.out.println("선택하신 메뉴는 " + menuNum + "번, 금액은 " + strMenuPrice + "원 입니다.");
		
		/*3. 계산하기*/
		System.out.print("\n결제하실 금액을 입력해주세요. >");
		
		while(chargeFlag) {
		
			if(scan.hasNextInt()) {
				charge += scan.nextInt();			
	
				if(charge < menuPrice) {
					strNeed = String.format("%,d", menuPrice-charge);
					System.out.print("금액이 " + strNeed + "원 부족합니다. 추가로 금액을 입력해주세요. > ");
					
				} else {
					strCharge = String.format("%,d", charge);
					strChange = String.format("%,d", charge - menuPrice);
					System.out.println("\n결제가 완료되었습니다.");
					System.out.println("입력하신 금액은 총 " + strCharge + "원, 잔돈은 " + strChange + "원 입니다." );
					
					chargeFlag = false;
				}
				
				
			} else {
				System.out.println("올바르지 않은 입력값 입니다. 다시 입력해주세요.");
				scan.next();
			}
		
		}
		
		System.out.println("[종료]");
		System.out.println("[이용해주셔서 감사합니다.]");
		System.exit(0);
		
		scan.close();
		
	}

}
