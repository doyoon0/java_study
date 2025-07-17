package chapter13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set 인터페이스
 */
public class SetTest {

	public static void main(String[] args) {
		Set<String> foods = new HashSet<String>();
		
		//1. 데이터 저장 : C(Create)
		foods.add("된장찌개");
		foods.add("김치찌개");
		foods.add("짜장면");
//		foods.add("짜장면"); //중복 데이터 저장 X
		
		
		//2. 데이터 출력 : R(Read)
		foods.forEach(System.out::println);
		System.out.println("=========");
		
		//3. 데이터 수정 : U(Update)
		//짜장면 --> 짬뽕
		if(foods.contains("짜장면")) foods.remove("짜장면"); 
		foods.add("짬뽕");
		
		foods.forEach(System.out::println);
		System.out.println("=========");
		
		//4. 데이터 삭지 : D(Delete)
		//김치찌개 삭제
//		if(foods.contains("김치찌개")) foods.remove("김치찌개"); 
		
		Iterator<String> ie = foods.iterator(); //제네릭으로 타입을 제한하지 않으면 Object 타입으로 생성됨
		while(ie.hasNext()) {
			String food = ie.next(); //제네릭 없으면 (String)ie.next()로 해줘야함.
			if(food.equals("김치찌개")) ie.remove();
		}
		foods.forEach(System.out::println);
	}
	

}
