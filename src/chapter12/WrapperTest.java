package chapter12;

public class WrapperTest {

	public static void main(String[] args) {
		int num1 = 100;
		Integer num2 = new Integer(num1);//Deprecated
		Integer num3  = Integer.valueOf(num1);
		int num4 = Integer.parseInt("123");
		double dnum = Double.valueOf("123.60");
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(dnum);
	}

}
