package drink_interface;

public class MenuItem implements Menu{
	int no;
	int price;
	String name;
	
	public MenuItem () {}
	public MenuItem (int no, String name, int price) {
		this.no = no;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public int getNo() {
		return no;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public int getPrice() {
		return price;
	}
	
}
