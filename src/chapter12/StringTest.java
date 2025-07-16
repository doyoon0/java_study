package chapter12;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		String name1 = "홍길동";
		String name2 = new String("홍길동");
		String num = String.valueOf(123);
		name2 = "welcomeToJava!!";
		String phone = "010-1234-5678";
		String[] phones = phone.split("-");
		String subject = "java, css, html, mysql";
		String[] subjects = subject.split(",");
		String jphone = String.join("-", phones);

		System.out.println(name2.substring(7));
		System.out.println(name2.substring(7, 10));
		System.out.println(name2.toUpperCase());
		System.out.println(name2.toLowerCase());
		System.out.println(System.identityHashCode(name1));
		System.out.println(System.identityHashCode(name2));
		System.out.println(num.getClass().getName().substring(num.getClass().getName().lastIndexOf('.') + 1));
		System.out.println(Arrays.toString(phones));
		System.out.println(Arrays.toString(subjects));
		System.out.println(subject.contains("html")); //true
		
		if(name1 == name2) System.out.println("홍길동");
		else System.out.println("다름");
		
		if(name1.equals(name2)) System.out.println("동일");
		else System.out.println("다름");
		
	}

}
