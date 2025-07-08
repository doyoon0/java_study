package lunch;

import java.util.Scanner;

public class LunchOrderSystemOOP {
	
	//Field
	Scanner scan;
	LunchOrderMenuManager menuManager;
	String[] lunchMenuNames = {"햄버거(🍔)","피자(🍕)","라멘(🍜)","샐러드(🥗)"}; //선언+할당 동시에 
	int[] lunchMenuPrice = {100, 200, 300, 400};
	LunchMenu[] lunchMenuList; //주문할 메뉴 : LunchMenu (음식메뉴)
	LunchOrderItem[] orderItemList;
	LunchPaymentItem paymentItem;
	int orderCount = 0; //메뉴 개수
	int amount = 0; //결제금액 - 사용자 입력
	int change = 0; //잔돈
	String title;
	
	//Constructor
	public LunchOrderSystemOOP() {  //기본 생성자
		scan = new Scanner(System.in);
		menuManager = new LunchOrderMenuManager();
		lunchMenuList = new LunchMenu[4];
		orderItemList = new LunchOrderItem[4];	
		
		menuManager.createLunchMenu();
	};
	
	public LunchOrderSystemOOP(String title) {
		this.title = title;
		scan = new Scanner(System.in);
		menuManager = new LunchOrderMenuManager(this); //자기자신을 받으면 this를 입력
		lunchMenuList = new LunchMenu[4];
		orderItemList = new LunchOrderItem[4];
		
		menuManager.createLunchMenu(); //런치 메뉴 생성 메소드 호출
		showMainMenu();
	}
	
	//Method
	
	// ***************** MAIN MENU START *******************************************************//
	/*
	 * 메인메뉴 출력 메소드 : MainMenu (시스템 전체에서 사용되는 메뉴)
	 */
	public void showMainMenu() {
		System.out.println();
		System.out.println("******************************************");
		System.out.println("\t Welcome to [" + title + "] Food Mart!!!");
		System.out.println("******************************************");
		System.out.println("\t 1. 음식 주문");		
		System.out.println("\t 2. 주문 내역");		
		System.out.println("\t 3. 음식 결제");		
		System.out.println("\t 4. 결제 내역");		
		System.out.println("\t 9. 프로그램 종료");		
		System.out.println("******************************************");
		System.out.println("***** Food Mart에 오신것을 환영합니다 *****");
		
		menuManager.createLunchMenu();
		selectMainMenu();		
		
		
	}//showMainMenu method
	
	/*
	 * 메인메뉴 선택
	 */
	public void selectMainMenu() {
		System.out.print("메인 메뉴(숫자)> ");
		
		if(scan.hasNextInt()) {
			checkMainMenu(scan.nextInt());
		} else {
			System.out.println("=> 입력된 값이 바르지 않습니다. 숫자만 입력해주세요 !!!!!!!!!!!!!!");
			scan.next(); //buffer에 그대로 남아있기 때문에 한번 털어준다.
			selectMainMenu();
		}
	}
	
	/*
	 * 메인메뉴 체크
	 */
	public void checkMainMenu(int mainMenu) {
		switch(mainMenu) {
		case 1: 
			menuManager.showLunchMenu();
			break;
		case 2: 
			orderList();
			showMainMenu();
			break;
		case 3: 
			payment();
			showMainMenu();
			break;
		case 4: 
			paymentList();
			showMainMenu();
			break;
		case 5: 
			showMainMenu();
			break;
		case 9:
			System.out.println("=> 음식 주문 시스템 종료!!!!");
			System.exit(0);
			break;
		default:
			System.out.println("=> 메뉴 준비중~");
			showMainMenu();
			
		}
	}
	// ***************** MAIN MENU END *******************************************************//
	
	
	// ***************** ORDER START *******************************************************//
	/*
	 * 주문데이터 인덱스 검색
	 */
	public int searchrOrderItemIdx(int lunchMenu) {
		int idx = -1;
		
		for(int i=0; i<orderCount; i++) {
			LunchOrderItem orderItem = orderItemList[i];
			if(orderItem.no == lunchMenu) idx = i;
		}
		
		return idx;
	}
	
	
	/*
	 * 주문 리스트 초기화 
	 */
	public void orderItemListInit() {
		
//		방법 1.
//		orderItemList = new LunchOrderItem[4];
		
//		방법 2.
//		for(int i=0; i<orderCount; i++) {
//		orderItemList[i] = null;
		
//		방법 3.
	    for(LunchOrderItem orderItem : orderItemList) {
	        if(orderItem != null) orderItem = null;  
	    }	    
	    //필수
	    orderCount = 0;
	}
	
	/*
	 * 주문 : order()
	 */
	public void order(int lunchMenu) {
		
		//lunchMenuList의 메뉴 번호 확인
		for(LunchMenu menu : lunchMenuList ) {
			if(menu.no == lunchMenu) {
				int idx = searchrOrderItemIdx(lunchMenu);
				if(idx == -1) {
					orderItemList[orderCount] = new LunchOrderItem();
					orderItemList[orderCount].no = menu.no;
					orderItemList[orderCount].name = menu.name;
					orderItemList[orderCount].price = menu.price;
					orderItemList[orderCount].qty = 1;
					orderCount++;
				
				} else {
					orderItemList[idx].qty += 1;
				}
				break;
			}
		}
		
		System.out.println("=> 주문 완료!!!!!");
		showMainMenu();
	}
	
	/*
	 * 주문 내역 : orderList()
	 */
	public void orderList() {
		if(orderCount < 1) {
			System.out.println("=> 주문내역 존재X, 음식을 주문해주세요");
		} else {
			System.out.println("-----------------------------------------");
			System.out.println("\t음식 주문 리스트");
			System.out.println("-----------------------------------------");
			System.out.println("번호\t메뉴명\t\t가격\t수량");
			System.out.println("-----------------------------------------");
			for(LunchOrderItem orderItem : orderItemList) {
				
				if(orderItem!= null) {
					System.out.print(orderItem.no + "\t");
					System.out.print(orderItem.name + "\t\t");
					System.out.print(orderItem.price + "\t");
					System.out.print(orderItem.qty + "\n");
				}
			}
			System.out.println("-----------------------------------------");
		}
		showMainMenu();
	}

	// ***************** ORDER END *******************************************************//
	// ***************** PAYMENT START ***************************************************//
	/*
	 * 결제 예정금액 산출
	 */
	public int totalPayment() {
		int sum = 0;
		for(LunchOrderItem orderItem : orderItemList) {
			if(orderItem != null) {
				sum += orderItem.price * orderItem.qty;
			}
		}
		return sum;
	}
	
	/*
	 * 결제 : payment()
	 */
	public void payment() {
		if(orderCount == 0) {
			System.out.println("=> 주문내역 존재X, 음식을 주문해주세요");
		} else {
			int total = totalPayment();
			System.out.println("=> 결제 예정 금액 : " + total);
			System.out.print("결제할 요금 입력(숫자) > ");
			if(scan.hasNextInt()) {
				amount += scan.nextInt();
				System.out.println("=> 총 입력 금액 : " + amount);				
				
				if(amount >= total) {								
					change = amount - total;
					
					paymentItem = new LunchPaymentItem();
					paymentItem.name = orderItemList[0].name + " 등";
					paymentItem.totalPayment = total;
					paymentItem.amount = amount;
					paymentItem.change = change;
					System.out.println("=> 결제 성공!!");

					//주문리스트 초기화(별도의 기능)
					orderItemListInit();
					
				} else {
					System.out.println("=> 요금이 부족합니다. 다시 입력해 주세요");
					payment();
				}			
				
			} else {
				System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.");
				scan.next();
			}//if
		}
		showMainMenu();
	}
	
	/*
	 * 결제 내역 : paymentList()
	 */
	public void paymentList() {
		if(paymentItem == null) {
			System.out.println("=> 결제 내역X, 주문을 진행해주세요.");
		} else {
			System.out.println("-----------------------------------------");
			System.out.println("\t결제 내역");
			System.out.println("-----------------------------------------");
			System.out.println("주문명\t\t결제금액\t총입금액\t잔돈");
			System.out.println("-----------------------------------------");
			System.out.print(paymentItem.name + "\t");
			System.out.print(paymentItem.totalPayment +"\t");
			System.out.print(paymentItem.amount +"\t");
			System.out.print(paymentItem.change +"\n");
			System.out.println("-----------------------------------------");
		}
		showMainMenu();
	}

	// ***************** PAYMENT END ***************************************************//	
}//class
