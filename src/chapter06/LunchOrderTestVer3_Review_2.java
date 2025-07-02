package chapter06;

import java.util.Scanner;

public class LunchOrderTestVer3_Review_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean menuFlag = true;
		
		//주문 음식 리스트
		String[] menuList = {"햄버거(🍔)", "피자(🍕)", "라멘(🍜)", "샐러드(🥗)"};
		int[] priceList = {100, 200, 300, 400};
		
		//주문 리스트 선언 및 생성
		System.out.print("주문리스트 크기> ");
		final int MAX_SIZE = scan.nextInt();
		String[] orderMenuList = new String[MAX_SIZE];
		int[] orderPriceList = new int[MAX_SIZE];
		int count = 0;
		int orderCount = 0;
		String[][] chargeList = new String[MAX_SIZE][4];
		
		//결제 리스트 선언 및 생성
		//메뉴명, 결제금액, 입금액, 잔돈
		
		while(menuFlag) {
			System.out.println("*******************************************");
			System.out.println("\t Welcome to Food Mart!!!");
			System.out.println("*******************************************");
			System.out.println("\t 1. 음식 주문");
			System.out.println("\t 2. 주문 내역");
			System.out.println("\t 3. 음식 결제");
			System.out.println("\t 4. 결제 내역");
			System.out.println("\t 9. 프로그램 종료");
			System.out.println("*******************************************");
			System.out.println("****** Food Mart에 오신것을 환영합니다");
			System.out.print("메뉴> ");
			int menu = scan.nextInt();
			
			switch(menu) {
			
				case 1: // 음식 주문
					boolean orderFlag = true;
					while(orderFlag) {
						System.out.println("*********************************************");
						System.out.println("\t 1. 햄버거(🍔):100 2. 피자(🍕):200");
						System.out.println("\t 3. 라멘(🍜):300\t 4. 샐러드(🥗):400");
						System.out.println("*********************************************");
						
						if(count == MAX_SIZE) {
							System.out.println("=> 주문은 최대 " + MAX_SIZE + "개까지 가능");
							break;
						}
						
						System.out.print("주문 메뉴(숫자로)> ");
						if(scan.hasNextInt()) {
							int menuNo = scan.nextInt();
							
							if(menuNo>=1 && menuNo<=4) {
								orderMenuList[count] = menuList[menuNo-1];
								orderPriceList[count] = priceList[menuNo-1];
								count++;
							} else {
								System.out.println("=> 메뉴 준비중 입니다.");
							}
							
							System.out.println(menuList[menuNo-1] + "주문 완료!");
							
							//주문 개수 체크
							if(count == MAX_SIZE) {
								System.out.println("=> 주문은 최대 " + MAX_SIZE + "개까지 가능");
								orderFlag = false;
							} else {
								System.out.print("계속 주문?(계속:아무키나, 종료:n)");
								if(scan.next().equals("n")) {
									orderFlag = false;
								}
							}
							
						} else {
							System.out.println("올바르지 않은 입력값입니다. 다시 입력해주세요.");
							scan.next();
						}
						
					}
					break;
				case 2: // 주문 목록
					if(count != 0) {
						System.out.println("----------------------------");
						System.out.println("번호\t메뉴명\t가격");
						System.out.println("----------------------------");
						
						for(int i=0; i<count; i++) {
							System.out.print((i+1) +". ");
							System.out.print(orderMenuList[i]+"\t");
							System.out.println(orderPriceList[i]+"\n");
						}
						System.out.println("----------------------------");
					} else {
						System.out.println("=> 주문 내역 없음!");
					}
					break;
				case 3: // 음식 결제
					int totalPayment = 0;
					int charge = 0;
					int change = 0;
					
					boolean paymentFlag = true;
					for(int price : orderPriceList) {
						totalPayment += price;
					}
					
					if(totalPayment < 1) {
						System.out.println("=> 주문 내역 없음!");
						break;
					}
					
					while(paymentFlag) {
						System.out.println("=> 결제 예정 금액 : " + totalPayment);
						System.out.print("결제할 요금 입력(숫자)> ");
						if(scan.hasNextInt()) {
							charge += scan.nextInt();
							System.out.println("총 입력 금액 : " + charge);		
							
							if(charge >= totalPayment) {
								change = charge - totalPayment;
								paymentFlag = false;
							} else {
								System.out.println("요금이" + (totalPayment-charge) +"원 부족합니다. 다시 입력해 주세요.");
							}
							
						} else {
							System.out.println("올바르지 않은 입력값입니다.");
							scan.next();
						}
					}
					
					System.out.println("----------------------------");
					System.out.println("번호\t메뉴명\t가격");
					System.out.println("----------------------------");
					for(int i=0; i<count; i++) {
						System.out.print((i+1) +". ");
						System.out.print(orderMenuList[i]+"\t");
						System.out.println(orderPriceList[i]+"\n");
					}
					System.out.println("----------------------------");
					System.out.println("총 금액\t입력 금액\t잔돈");
					System.out.println("----------------------------");
					System.out.println(totalPayment + "\t" + charge + "\t" + change);
					System.out.println("----------------------------");
					
					// 초기화 하기 저에 저장
					chargeList[orderCount][0] = orderMenuList[0]+"외 " + (count-1) + "건";
					chargeList[orderCount][1] = String.valueOf(totalPayment);
					chargeList[orderCount][2] = String.valueOf(charge);
					chargeList[orderCount][3] = String.valueOf(change);
					
					orderCount++;
					
					// 초기화
					orderMenuList = new String[MAX_SIZE];
					orderPriceList = new int[MAX_SIZE];
					
					count = 0;
					break;				
					
				case 4:	// 결제 목록
					if(orderCount > 0) {
						System.out.println("================================================================");
				        System.out.println("\t\t결제 내역");
				        System.out.println("================================================================");
				        System.out.println("번호\t메뉴명\t\t\t총금액\t입력금액\t잔돈");
				        System.out.println("================================================================");
				        
				        for(int i=0; i<orderCount; i++) {
				        	System.out.print((i+1) +". " + "\t");
				        	System.out.print(chargeList[i][0] + "\t\t");  // 메뉴명
				            System.out.print(chargeList[i][1] + "\t");    // 총금액
				            System.out.print(chargeList[i][2] + "\t");    // 입력금액
				            System.out.println(chargeList[i][3]);         // 잔돈
				        }
				        System.out.println("================================================================");
					} else {
						System.out.println("=> 결제 내역이 없습니다.");
					}
				break;
					
				case 9:
					System.out.println("-- 프로그램 종료 --");
					System.exit(0);
					break;
				default :
					System.out.println("=> 메뉴 준비중");
			}
			
		}//while-menuFlag
		
	}//main


}
