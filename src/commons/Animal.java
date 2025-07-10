package commons;

public class Animal {
	//Field
	private String name;
	private int age;
	private String addr;
	private String color;
	private int height;
	private int weight;
	private boolean gender;
	

	//Constructor
	public Animal() {
		
	}
	
	public Animal(String name, int age, String addr, String color) {
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.color = color;
	}
	
	//Method
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	
}
