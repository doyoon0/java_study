package chapter07;

import java.util.Scanner;

/*
 * 전체 프로그램 흐름 제어 (메뉴 출력, 주문, 결제, 종료)
 */
public class OrderSystem {
	//Field
	Scanner scan = new Scanner(System.in);
	Menu[] drinkMenuList = new Menu[3]; //배열로 변경💛
	Order[] drinkOrderList = new Order[3];
	String[] drinkNames = {"아메리카노(☕)","바닐라 라떼(🍵)","딸기 쉐이크(🥤)"};
	int[] drinkPrice = {2800, 3500, 4000};
	int orderCount = 0; //전체 주문 횟수

	//0.시스템메뉴판
	public void showMenu() {
		System.out.println();
		System.out.println("******************************************");
		System.out.println("\t Welcome to our Cafe!!!");
		System.out.println("******************************************");
		System.out.println("\t 1. 음료 주문");		
		System.out.println("\t 2. 주문 내역");		
		System.out.println("\t 3. 음료 결제");		
		System.out.println("\t 4. 결제 내역");		
		System.out.println("\t 9. 프로그램 종료");		
		System.out.println("******************************************");
		
		setDrinkList();
		selectMenu();
	}
	
	//0-1.시스템메뉴판 선택
	public void selectMenu() {
		System.out.print("********[숫자]몇 번 메뉴로 이동하시겠습니까?> ");
		
		if(scan.hasNextInt()) {
			checkMenu(scan.nextInt());
		} else {
			System.out.println("잘못된 입력값 입니다.");
			scan.next();
			showMenu();
		}
	}
	
	//0-2.시스템메뉴별 동작
	public void checkMenu(int menu) {
		switch(menu) {
			case 1:
				showDrinkList();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4: 
				break;
			case 9:
				System.out.println("********음료 주문 시스템을 종료합니다.********");
				System.exit(0);
			default:
				System.out.println("********메뉴 준비중입니다.********");
				selectMenu();
			
		}
	}
	
	//1-1.음료 주문 - Menu에 음료 종류와 가격 넣기
	public void setDrinkList() {
		for(int i=0; i<drinkNames.length; i++ ) {
			drinkMenuList[i] = new Menu(); //각각 새로운 객체 생성💛
			drinkMenuList[i].no = i+1;
			drinkMenuList[i].name = drinkNames[i];
			drinkMenuList[i].price = drinkPrice[i];
		}
	}
	
	//1-2.음료 주문 - 음료수 메뉴 출력하기
	public void showDrinkList() {
		System.out.println("******************************************");
		for(Menu menu : drinkMenuList) {
			System.out.print(menu.no + ".\t");
			System.out.print(menu.name + "\t");
			System.out.println(menu.price + "원");
		}
		System.out.println("******************************************");
		
		selectDrink();
	}
	
	//1-3.음료 선택 - 음료수 메뉴에서 고르기
	public void selectDrink() {
		System.out.print("********[숫자]음료를 선택해주세요 > ");
		
		if(scan.hasNext()) {
			storeDrink(scan.nextInt());		
		} else {
			System.out.println("잘못된 입력값 입니다.");
			scan.next();
			showDrinkList();
		}
		
	}
	
	//1-4.음료 선택 - 고른 음료를 주문서에 저장하기
	public void storeDrink(int drinkMenu) {
		if(drinkMenu >= 1 && drinkMenu <= 3) {
			setOrder(drinkMenu);
		} else {
			System.out.println("********메뉴 준비중입니다.********");
			showDrinkList();
		}
	}
		
	//2-1.음료 주문 - 고른 음료를 저장할 주문서
	public void setOrder(int drinkMenu) {
		int orderIdx = findOrderIdx(drinkMenu);
		if(orderIdx != -1) {
			drinkOrderList[orderIdx].qty++;
			drinkOrderList[orderIdx].totalPrice = drinkOrderList[orderIdx].qty * drinkMenuList[drinkMenu-1].price;
		} else {
			drinkOrderList[orderCount] = new Order();
			drinkOrderList[orderCount].orderNo = drinkMenu;
			drinkOrderList[orderCount].name = drinkMenuList[drinkMenu-1].name;
			drinkOrderList[orderCount].qty = 1;
			drinkOrderList[orderCount].totalPrice = drinkMenuList[drinkMenu-1].price;
		}
		
		showOrderList();
	}
	
	//2-2.음료 주문 - 이전에 주문한 음료수인지 체크
	public int findOrderIdx(int drinkMenu) {
		for(int i=0; i<orderCount; i++) {
			if(drinkOrderList[i].orderNo == drinkMenu) {
				return i;
			}
		}
		return -1;
	}
	
	//2-3.음료 주문 - 주문서를 출력한다.
	public void showOrderList() {
		System.out.println("******** 현재 주문 내역 ********");
		for(int i = 0; i < orderCount; i++) {
		    if(drinkOrderList[i] != null) {
		        System.out.println(drinkOrderList[i].name + " x" + drinkOrderList[i].qty + " = " + drinkOrderList[i].totalPrice + "원");
		    }
		}
	}
	

}
