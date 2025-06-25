package chapter03;

import java.util.Scanner;

//import java.lang.String;	자주 사용되어 굳이 import 하지 않아도 됨
//import java.lang.System;

public class ReferenceDataType {

	public static void main(String[] args) {
		//참조 데이터 타입 정의 : 배열, 클래스, 인터페이스 ..
		String name = new String("홍길동");	//주소가 저장되는 것		
		Scanner scan = new Scanner(System.in);
		
		/*중요!
		String 클래스는 기본형으로도 사용이 가능함*/		
		String name2 = "홍길동";
		
		System.out.println(name);	//주소에 저장된 값을 불러옴
		System.out.println(name2);	//주소에 저장된 값을 불러옴
		System.out.println(name == name2);	//false : 주소값이 다르다
		System.out.println(scan);
	}

}
