package drink;

public class Order {
	//Field
	Menu orderMenu; //주소
	
	//Constructor
	public Order() {}
	public Order(Menu orderMenu) {
		//만들면서 메뉴 하나가 바로 들어가는것. 주문객체가 되게 많음. 그럼 orderList에서 관리를 한다거나
		//아니면 Menu를 배열로 관리하면 메소드로 만들어서 진행하는 것. 
		//한 객체를 보고 여러개를 담아서 실행할것인가, orderMenu객체를 배열로 저장해서 처리할것인가. 
		this.orderMenu = orderMenu; 
	}
	
	//Method
	public void getInfo() {
		String price = String.format("%,d", orderMenu.price);
		System.out.println("=> 주문메뉴 : " + orderMenu.name + ", 결제 예정 금액 : " + price + "원" );
	}
	
	public String getName() {
		return orderMenu.name;
	}
	public int getTotal() {
		return orderMenu.price;
	}
}
