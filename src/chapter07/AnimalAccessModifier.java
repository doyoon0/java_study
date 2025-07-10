package chapter07;

public class AnimalAccessModifier {
	//Field

	String name;		//같은 패키지에서만 접근 가능
	int age;			//같은 패키지에서만 접근 가능
	
	private String pname; //같은 클래스 내부에서만 접근 가능
	private int page;	  //같은 클래스 내부에서만 접근 가능
	
	static String sname;	//static 변수, 클래스변수
	static int sage;
	
	final String fname = "홍길동";	//final 키워드 적용 => 외부에서 값을 변경할 수 없음!!
	final int fage = 10;
	
	//상수 정의
	public static final int START = 0;
	public static final int CONTINUE = 1;
	public static final int END = -1;
	
	//Constructor
	public AnimalAccessModifier() {
		
	}
	
	public AnimalAccessModifier(String pname, int page) {
		this.pname = pname;
		this.page = page;
	}
	
	//static Method
	void getInfo() {System.out.println(pname + "," + page);};
	public void getInfo2() {System.out.println(pname + "," + page);};
	public static void getInfo3() {System.out.println(sname + "," + sage);};
	
	//getter/setter
	public String getPname() {
		return pname;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
}
