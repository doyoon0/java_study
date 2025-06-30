package chapter06;

import java.util.Scanner;

public class ArrayTest04 {

	public static void main(String[] args) {
		// 배열 객체 생성 후 크기 확인 : 기본형 데이터를 저장하는 객체 생성
		int[] numberList = new int[5];
		String[] nameList = {"홍길동", "이순신", "김유신"};
		boolean[] flagList = new boolean[2];
		
		// 배열 객체 생성 후 크기 확인 : 참조 데이터를 저장하는 객체 생성
		Scanner[] scanList = new Scanner[3]; // Scanner 클래스의 객체를 3개 저장
		
		// scanList 0번지에 Scanner 객체 생성후 주소 저장
		scanList[0] = new Scanner(System.in);
		scanList[1] = new Scanner(System.in);
		scanList[2] = new Scanner(System.in);
		
		System.out.println(numberList.length);
		System.out.println(nameList.length);
		System.out.println(flagList.length);
		System.out.println(scanList[0].hashCode());
		System.out.println(scanList[1].hashCode());
		System.out.println(scanList[2].hashCode());
		
		scanList[0] = scanList[2];
		System.out.println(scanList[0].hashCode());
		System.out.println(scanList[1].hashCode());
		System.out.println(scanList[2].hashCode());
		
		int[] nList = new int[3];
		nList[0] = 10;
		nList[1] = 20;
		nList[2] = 30;
		
		nList[0] = nList[2];
		System.out.println(nList[0]); // hashCode()는 주소가 들어가야하는데 얘는 객체 자체라서 에러남
		System.out.println(nList[1]);
		System.out.println(nList[2]);
		
		
	}

}
