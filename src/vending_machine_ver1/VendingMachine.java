package vending_machine_ver1;

import commons.Menu;

public class VendingMachine {
	String[] nameList = {"☕ 밀크커피", "☕ 아메리카노", "🍋 유자차", "🥛 우유"};
	int[] priceList = {300, 400, 300, 200};
	Menu[] menuList;
	String title;
	
	public VendingMachine() {
		this("막심");
	}
	
	public VendingMachine(String title) {
		this.title = title;
		createMenuList();
		showMenuList();
	}
	
	//메뉴 출력
	public void showMenuList() {
		System.out.println("***********************************");
		System.out.println("   ☕🍵🥤 " + title + " Coffee Machine");
		System.out.println("***********************************");
		
		for(Menu menu : menuList) {
	        System.out.printf(" %d. %-15s %,d원%n", 
                    menu.getNo(), 
                    menu.getName(), 
                    menu.getPrice());
		}
		System.out.println("***********************************");
	}
	
	//메뉴 리스트 생성
	public void createMenuList() {
		menuList = new Menu[nameList.length];
		for(int i=0; i<nameList.length; i++) {
			int no = i+1;
			String name = nameList[i];
			int price = priceList[i];
			
			Menu menu = new Menu(no, name, price);
			menuList[i] = menu;
		}
	}
}
