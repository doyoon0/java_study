package vending_machine_ver2;

public class RestArea {
	String name;
	User user;
	VendingMachine machine;
	
	public RestArea() {
		this("더조은");
	}
	
	public RestArea(String name) {
		this.name = name;
		user = new User("더조은");
		welcome();
		machine = new VendingMachine(user);
	}
	
	public void welcome() {
		System.out.println("------------------------------------------");
		System.out.println(" " + name + " ☕🍵🥤 휴게소에 오신것을 환영합니다");
		System.out.println("------------------------------------------");
	}
	
}
