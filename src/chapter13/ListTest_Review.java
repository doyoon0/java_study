package chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest_Review {

	public static void main(String[] args) {
		/*
		## forEach vs Iterator 연습 문제

		### 🎯 **문제 1: forEach 기본 연습**
		```java
		List<String> fruits = Arrays.asList("사과", "바나나", "오렌지", "포도");
		```
		**과제:** 3가지 forEach 방식으로 모두 출력해보기
		1. 람다식 (블록)
		2. 람다식 (간단)  
		3. 메소드 참조

		---
		*/
		List<String> fruits = Arrays.asList("사과", "바나나", "오렌지", "포도");
		
		fruits.forEach((fruit) -> {
			System.out.println(fruit);
		});
		
		fruits.forEach(fruit -> System.out.println(fruit));
		
		fruits.forEach(System.out::println);
		/*

		### 🎯 **문제 2: Iterator 삭제 연습**
		```java
		
		```
		**과제:** Iterator로 20보다 큰 숫자들 모두 삭제하기

		---
		*/
		List<Integer> numbers = new ArrayList<>();
		numbers.add(10);
		numbers.add(15);
		numbers.add(20);
		numbers.add(25);
		numbers.add(30);
		
		Iterator<Integer> ie = numbers.iterator();
		while(ie.hasNext()) {
			if(ie.next() > 20) {
				ie.remove();
			}
		}
		
		numbers.forEach(System.out::println);
		/*
		### 🎯 **문제 3: 실무 시나리오**
		```java
		List<String> emails = new ArrayList<>();
		emails.add("user@gmail.com");
		emails.add("invalid-email");
		emails.add("test@naver.com");
		emails.add("wrong.format");
		emails.add("admin@company.co.kr");
		```
		**과제:** 
		1. forEach로 모든 이메일 출력
		2. Iterator로 "@" 없는 잘못된 이메일 삭제

		---

		### 💡 **힌트**
		- **forEach**: `list.forEach()` 사용
		- **Iterator**: `hasNext()` → `next()` → `remove()` 순서

		**한 문제씩 해보고 막히면 질문해!** 🚀
		*/
		
		List<String> emails = new ArrayList<>();
		emails.add("user@gmail.com");
		emails.add("invalid-email");
		emails.add("test@naver.com");
		emails.add("wrong.format");
		emails.add("admin@company.co.kr");
		
		emails.forEach(System.out::println);
		Iterator<String> ie2 = emails.iterator();
		
		while(ie2.hasNext()) {
			if(!ie2.next().contains("@")) {
				ie2.remove();
			}
			
			emails.forEach(System.out::println);
		}
	}

}
