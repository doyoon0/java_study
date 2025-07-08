package lunch;

public class LunchOrderMenuManager {
	//Field
	LunchOrderSystemOOP system;
//	String[] lunchMenuNames;
//	int[] lunchMenuPrice;
	
	//Constructor
	public LunchOrderMenuManager() {}
	public LunchOrderMenuManager(LunchOrderSystemOOP system) {
//		this.lunchMenuNames = lunchMenuNames;
//		this.lunchMenuPrice = lunchMenuPrice;
		this.system = system; //주석처리해도 에러나진 않지만 참조할 주소가 없기때문에 null pointer exception 발생
	}
	
	/*
	 * 런치메뉴 생성
	 */
	public void createLunchMenu() {
		for(int i=0; i<system.lunchMenuNames.length; i++) {
			LunchMenu menu = new LunchMenu();
			menu.no = i+1;
			menu.name = system.lunchMenuNames[i];
			menu.price = system.lunchMenuPrice[i];
			
			system.lunchMenuList[i] = menu;
		}
	}
	
	/*
	 * 런치메뉴 출력
	 */
	public void showLunchMenu() {
		System.out.println("******************************************");
		for(LunchMenu menu : system.lunchMenuList) {
			System.out.print(menu.no + ".  ");
			System.out.print(menu.name + "\t");
			System.out.println(menu.price);
		}
		System.out.println("******************************************");
		selectLunchMenu();
	}
	
	/*
	 * 런치메뉴 선택
	 */
	public void selectLunchMenu() {
		System.out.print("주문 메뉴(숫자)> ");
		
		if(system.scan.hasNextInt()) {
			checkLunchMenu(system.scan.nextInt());
		} else {
			System.out.println("=> 입력된 값이 바르지 않습니다. 숫자만 입력해주세요 !!!!!!!!!!!!!!");
			system.scan.next();
			selectLunchMenu();
		}
	}
	
	/*
	 * 런치메뉴 체크
	 */
	public void checkLunchMenu(int lunchMenu) {
		//lunchMenu : 1~4 => 주문가능, 다른번호 : 메뉴 준비중 => 다시 입력
		if(lunchMenu>=1 && lunchMenu<=4) {
			//주문 진행
			system.order(lunchMenu);
			
		} else {
			System.out.println("=> 런치 메뉴 준비중~");
			showLunchMenu();
		}
	}
	
}
