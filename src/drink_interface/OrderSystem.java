package drink_interface;

import java.util.Scanner;

public class OrderSystem {
	//Field
	String title;
	Order order;
	Payment payment; //결제 정보를 가지고 있는 아이 :)
	Scanner scan = new Scanner(System.in);
	String[] names = {"☕아메리카노", "🍵바닐라 라떼", "🥤딸기 쉐이크"};
	int[] price = {2800, 3500, 4000};
	Menu[] menuList = new MenuItem[names.length]; //new 해서 객체 만들어야
	
	//Constructor
	public OrderSystem() {
		//기본생성자 호출시 default 값
		//기본 생성자가 실행되면 아래 생성자는 실행되지 않는다.
		//매개변수 생성자에게 위임만
		//기본생성자만 있을경우에는 기본생성자에서 init();
		this("Mega");
	}
	public OrderSystem(String title) {
		this.title = title;
		//실제 초기화 되는 부분 : 가장 완전한 생성자에서만 => 실제 일하는 부분
		init();
	}
	
	//Method
	public void init() {
		payment = new Payment(); 
		createMenuList();
		showMenu();
		selectMenu();
	}
	
	//-----생성순서 내림차순-------------------------------------------------------------//
	public void processPayment() {
		//계속 초기화 되기때문에 생성자에서 미리 초기화를 시켜놓는방법이 있고
		//while 문을 이용해서 객체 생성 되기 전까지만 반복되도록 할 수 있다. 
		//payment = new Payment(); 
		System.out.print("결제 금액(숫자) > ");
		if(scan.hasNextInt()) {
			payment.setAmount(scan.nextInt());
			System.out.println("=> 총 입금 금액 : " + payment.getAmount());
			if(payment.getPayment(order.orderMenu.getPrice())) {
				//결제 완료
				System.out.println("=> 결제 완료!! 잔돈 : " + payment.getChange() + "원");
				showMenu();
				selectMenu();
			}else {
				//결제 금액 부족
				System.out.println("=> 결제 실패, 결제 금액 부족, 다시 입력!!");
				processPayment();
			}
		} else {
			System.out.println("=> 올바르지 않은 입력값 입니다. 다시 선택해주세요.");
			scan.next();
			processPayment();
		}
	}
	
	public void placeOrder(int menu) {
		//번호에 맞는 메뉴를 메뉴리스트에서 검색한다. 검색한 메뉴를 Order 생성자에 매개변수로 입력
		order = new Order(searchMenu(menu));
		if(order.orderMenu != null) order.getInfo();
		System.out.println("=> 주문완료!!");
		
		processPayment();
	}
	
	public Menu searchMenu(int menuNo) {
		Menu menu = null;
		
		for(Menu m : menuList) { //menuList[0] --> m 주소저장 --> Menu(아메리카노);
			if(m.getNo() == menuNo) {
				menu = m;
				break;
			}
		}		
		return menu;
	}
	
	public void selectMenu() {
		System.out.print("메뉴 선택(숫자) > ");
		if(scan.hasNextInt()) {
			int menu = scan.nextInt();
			
			if(menu >= 1 && menu <= 3) {
				placeOrder(menu);
			} else {
				System.out.println("=> 메뉴 준비중 입니다.");
			}
			
		} else {
			System.out.println("=> 올바르지 않은 입력값 입니다. 다시 선택해주세요.");
			scan.next();
			selectMenu();
		}
	}
	
	public void showMenu() {
		System.out.println("********************************");
		System.out.println("    ☕🍵🥤 " + title + " Coffee Menu");
		System.out.println("********************************");
		
		for(Menu menu : menuList) {
			System.out.print(" " + menu.getNo() + ".\t");
			System.out.print(menu.getName() + "\t");
			System.out.print(String.format("%,d", menu.getPrice())  + "\n");
		}
		System.out.println("********************************");
	}
	
	public void createMenuList() {
		for(int i=0; i<names.length; i++) {
			Menu menu = new MenuItem((i+1), names[i], price[i]); //Menu 껍데기를 가진 menu에 값 집어넣고
			menuList[i] = menu;								 //menuList에 대입해서 여러 menu를 저장한다.
		}
	}
	

}
