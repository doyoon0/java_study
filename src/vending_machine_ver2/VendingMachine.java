package vending_machine_ver2;

import commons.Menu;

public class VendingMachine {
	//Field
	String[] nameList = {"☕ 드립커피", "☕ 아메리카노", "🍋 레몬티", "🥛 바나나우유"};
	int[] priceList = {300, 400, 300, 200};
	Menu[] menuList;
	String title;
	User user;
	int totalCoin =0;
	
	static final int EXIT = 9; //클래스명.상수명
	
	//Constructor
	public VendingMachine(User user) {
		this("먘심", user);
	}
	
	public VendingMachine(String title, User user) {
		this.title = title;
		this.user = user;
		createMenuList();
		showMenuList();
		checkInsertCoin();
		
	}
	
	//Method
	//메뉴리스트 생성
	public void createMenuList() {
		menuList = new Menu[nameList.length];
		for(int i=0; i<nameList.length; i++) {
			int no = i;
			String name = nameList[i];
			int price = priceList[i];
			
			Menu menu = new Menu((i+1), name, price);
			menuList[i] = menu;
		}
	}
	
	//메뉴리스트 출력
	public void showMenuList() {
		System.out.println("***********************************");
		System.out.println("   ☕🍵🥤 " + title + " Coffee Machine");
		System.out.println("***********************************");
		
		for(Menu menu : menuList) {
			System.out.print(menu.getNo() +". ");
			System.out.print(menu.getName() +"\t\t");
			System.out.print(String.format("%,d", menu.getPrice()) +"원\n");	
		}
		System.out.println("***********************************");
	}
	
	//입력되는 동전 체크
	public void checkInsertCoin() {
		System.out.println("=> 동전을 투입해 주세요~");
		int coin = user.insertCoin();
		if(coin == 100 || coin == 500) {
			totalCoin += coin;
			System.out.println("총 투입금액 : " + totalCoin);
			
			if(totalCoin < 200) {
				System.out.println("=> 최소금액 부족");
				checkInsertCoin();
			} else {
				System.out.print("=> 메뉴선택(n), 동전투입계속(아무키) > ");
				if(user.scan.next().equals("n")) {
					//메뉴 선택하는 부분 (총 투입금액에 맞춘 메뉴가 출력되어야함)
					showMenuList(totalCoin);
					
				} else {
					checkInsertCoin();
				}
			}
		} else {
			System.out.println("=> 동전은 100원, 500원만 사용 가능합니다. 동전 반환!!!");
			checkInsertCoin();
		}
	}
	
	//총 투입금에 맞춘 메뉴 출력
	public void showMenuList(int totalCoin) {
		System.out.println("***********************************");
		System.out.println("   ☕🍵🥤 " + title + " Coffee Machine");
		System.out.println("***********************************");
		
		for(Menu menu : menuList) {
			if(menu.getPrice() <= totalCoin) {
				System.out.print(menu.getNo() +". ");
				System.out.print(menu.getName() +"\t\t");
				System.out.print(String.format("%,d", menu.getPrice()) +"원\n");	
			}
		}
		System.out.println("***********************************");
		selectMenu();
	}
	
	//메뉴 선택 (User에도 있음. 선택하는 주체니까)
	public void selectMenu() {
		int menuNo = user.selectMenu();
		
		
	}
	
	//메뉴 체크 
	//주문
	//결제
	//종료
	//종료 후 객체 초기화
}
