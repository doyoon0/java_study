package chapter11;

public class ExceptionTest3 {

	public static void main(String[] args) {
		
		String name1 = "홍길동";
		String name2 = null;
		ExceptionObject eo = null;
		eo = new ExceptionObject();
		eo.name = "홍길동";
		
		try {
			if(name1.equals(eo.name)) {
				System.out.println("동일!!");
			} else {
				System.out.println("다름!!");
			}
		} catch(Exception e) {
			System.out.println("Catching Error");
			e.printStackTrace();
		}
	}//main

}//class
