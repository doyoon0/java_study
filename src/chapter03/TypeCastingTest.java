package chapter03;

public class TypeCastingTest {

	/*
	 * 형변환 : 자동(묵시적) 형변환, 강제(명시적) 형변환
	 * */
	public static void main(String[] args) {
		//자동(묵시적) 형변환 : 작은 데이터 타입 > 큰 데이터 타입
		byte bdata = 1;
		short sdata = bdata;
		int idata = sdata;
		long ldata = idata;
		
		int number = 100;
		float fnumber = number;
		
		System.out.println(bdata);
		System.out.println(sdata);
		System.out.println(idata);
		System.out.println(ldata);
		System.out.println(fnumber);
		
	}

}
