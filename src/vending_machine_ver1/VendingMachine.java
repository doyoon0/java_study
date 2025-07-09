package vending_machine_ver1;

import commons.Menu;

public class VendingMachine {
	String[] nameList = {"☕ 밀크커피", "☕ 아메리카노", "🍋 유자차", "🥛 초코우유"};
	int[] priceList = {300, 400, 300, 200};
	Menu[] menuList;
	Menu[] orderMenuList; //user가 투입한 금액에 맞는 메뉴
	String title;
	User user;
	int totalCoin; //동전체크 로직에 넣으면 매번 초기화 되니까 전역변수로 선언
	int orderMenuCount = 0;
	Menu orderMenu;
	int change;
	
	static final int EXIT = 9; //클래스명.상수명
	
	public VendingMachine(User user) {
		this("막심", user); //생성자를 새로 만들지 않고 매개변수 형태로 추가함
	}
	
	public VendingMachine(String title, User user) {
		this.title = title;
		this.user = user; //외부에서 생성된 사람의 주소만 가져옴
		createMenuList();
		showMenuList();
		checkInsertCoin();
	}
	
	//종료 후 객체 초기화
	public void init() {
		orderMenuCount = 0;
		orderMenuList = null;
		orderMenu = null;
		totalCoin = 0;
	}
	
	//종료
	public void finalCheck() {
		//잔돈이 최소 주문금액보다 크면 계속 주문
		int price = menuList[menuList.length-1].getPrice();
		if(change >= price) {
		totalCoin = change;
		System.out.print("=> 잔돈 : " + change);
		createOrderMenuList(totalCoin);
		showMenuList("주문 가능 메뉴 리스트");
		selectMenu();
		} else {
			//결제 내역이 궁금하다면??
			System.out.println("=> 잔돈 : " + change);
			System.out.println("=> 이용해 주셔서 감사합니다!!");
		}
	}
	
	//결제
	public void processPayment() {
		if(orderMenu != null) {
			int price = orderMenu.getPrice();
			if(price <= totalCoin) {
				change = totalCoin - price;
				System.out.println("=> 결제완료!!");
				init();//사용한 객체 초기화 => orderMenuList, orderMenu, totalCount
				
			}
		}
		finalCheck();
	}
		
	//주문
	public void placeOrder(int menuNo) {
		//주문가능한 메뉴리스트에서 선택한 menuNo를 비교하여 메뉴주소를 orderMenu에 대입한다.
		for(Menu menu : orderMenuList) {
			//menu.getNo > 없는데 자꾸 거길 가서 뭘 찾아와라 가져와라 하니까 에러가나는것. 그래서 menu주소 값 자체 비교
			if(menu != null ) { 
				if(menu.getNo() == menuNo) {	//일치한다면
					orderMenu = menu;			//처리하고
					break; 						//break
				}
			}
		}
		System.out.println("=> 주문완료!!");
		processPayment();
		
	}
	
	
	//메뉴 체크 
	public boolean menuCheck(int menuNo) {
		boolean result = false;
		for(int i=0; i<orderMenuCount; i++) {
			Menu menu = orderMenuList[i];
			if(menu.getNo() == menuNo) {
				result = true;
			} 
		}
		return result;
	}
	
	//주문가능한 메뉴 리스트 생성
	public void createOrderMenuList(int totalCoin) {
		orderMenuList = new Menu[menuList.length];
		
		//orderMenuCount 변수를 이용하여 향상된 for문 사용
		for(Menu menu : menuList) {
			if(menu.getPrice() <= totalCoin) {
				orderMenuList[orderMenuCount] = menu;
				orderMenuCount++;
			}
		}
		
		/* 일반 for문 
		for(int i=0; i<menuList.length; i++) { 
			
			Menu menu = menuList[i]; //가독성과 명확성을 위해 지역 변수로 타입을 명시하는 것이 좋다
			
			if(menuList[i].getPrice() <= totalCoin) {
				orderMenuList[i] = menu; //같은 Menu 객체를 참조하니까
			}
		}
		*/
		
	}
	
	//메뉴 선택 (User에도 있음. 선택하는 주체니까)
	public void selectMenu() { //정확한 메뉴 선택!!
		//총 투입금액에 맞는 메뉴를 보여준다.
		System.out.println("=> 메뉴를 선택해 주세요.");
		System.out.println("=> 취소는 [" + VendingMachine.EXIT + "]번을 입력해주세요.");
		//두번 이상 사용되면 메모리 효율 상 변수 선언해서 stack에 담는게 이득
		int menuNo = user.selectMenu(); 	
		if(menuNo != VendingMachine.EXIT) {
			if(menuCheck(menuNo)) {
				placeOrder(menuNo);
			} else {
				selectMenu();
			}			
		} else {
			System.out.println("동전을 반환하고, 프로그램을 종료합니다.");
			System.out.println("반환 동전 : " + totalCoin);
			System.exit(0);
		}
	}
	
	//총 투입금액에 맞춘 메뉴 출력 overloading
	public void showMenuList(String msg) {
		System.out.println("***********************************");
		System.out.println("   ☕🍵🥤 " + title + " Coffee Machine");
		System.out.println("***********************************");
		System.out.println("\t" + msg);
		System.out.println("***********************************");
		for(int i=0; i<orderMenuCount; i++) {
			Menu menu = orderMenuList[i];
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
			
			//메뉴를 선택할수있는 최소 금액인지 체크 : 적어도 200원 이상되어야함
			if(totalCoin < 200) {
				System.out.println("=> 최소금액 부족");
				checkInsertCoin();
			} else {
				//메뉴 선택 여부 체크
				System.out.print("=> 메뉴선택(n), 동전투입계속(아무키) > ");
				if(user.scan.next().equals("n")) {
					createOrderMenuList(totalCoin);
					showMenuList("주문 가능 메뉴 리스트");
					selectMenu();
				} else {
					checkInsertCoin();
				}
			}
		} else {
			System.out.println("=> 동전은 100원, 500원만 사용 가능합니다. 동전 반환!!!");
			checkInsertCoin();
		}
		
	}
	
	//전체 메뉴 출력
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
