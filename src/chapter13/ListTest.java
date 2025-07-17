package chapter13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListTest {

	public static void main(String[] args) {
		//일반적으로 제너릭<>을 통해 데이터 타입을 정의한 후 사용함!!!
		List<Integer> list1 = new ArrayList<Integer>();
		List<String> list2 = new LinkedList<String>();
		List<Double> list3 = new Vector<Double>();
		
		//1. 데이터 저장 : C(Create)
		list1.add(100);
		list1.add(200);
		
		list2.add("100");
		list2.add("홍길동");
		
		list3.add(1.23);
		list3.add(3.456);
		
		//2. 데이터 출력 : R(Read)
		for(int i=0; i<list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		for(String str : list2 ) {
			System.out.println(str);
		}
		
		//forEach의 매개변수는 람다식 메소드 호출 방식을 갖는다.
		//() -> {}
		list3.forEach((dnum) -> {
			System.out.println(dnum);
		});
		
		list3.forEach(dnum -> System.out.println(dnum));
		
		list3.forEach(System.out::println);
		
		//3. 데이터 업데이트 : U(Update)
		list1.set(0, 1000);
		list2.set(0, "이순신");
		list3.set(0, 999.987);
		
		list1.forEach(System.out::println);
		list2.forEach(System.out::println);
		list3.forEach(System.out::println);
		
		//4. 데이터 삭제 : D(Delete)
		list1.remove(0);
		list2.remove(0);
		list3.remove(0);
		
		list1.forEach(System.out::println);
		list2.forEach(System.out::println);
		list3.forEach(System.out::println);
		
		//** 데이터 삭제시 인덱스 중복으로 인한 내부 에러 발생함!!
		//Iterable 인터페이스를 통한 삭제를 권장!!! 주머니에 손을 넣어서 꺼내는데, 리스트를 싹 지우고 꺼낸순으로 재정렬함으로서 인덱스 에러 해결
		List<String> list4 = new ArrayList<String>();
		list4.add("java");
		list4.add("mysql");
		list4.add("html");
		list4.add("css");
		list4.add("java");
		list4.add("css");
		
		list4.forEach(System.out::println);
		
		System.out.println("-----------------------------------");
		
		Iterator<String> ie = list4.iterator();
		while(ie.hasNext()) {
			String element = ie.next();
//			System.out.println(element);
			if(element.equals("html")) ie.remove();
		}
		
		list4.forEach(System.out::println);
		
	}

}
