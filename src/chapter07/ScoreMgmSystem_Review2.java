package chapter07;

import java.util.Scanner;

/*
 * - 학생 3명의 점수를 입력 받는다.
 * - 한 명 입력 후 계속 입력 여부를 메시지로 출력 후 입력 받는다.
 */
public class ScoreMgmSystem_Review2 {
	//Field
	private int MAX_SIZE;
	int currentCount =0;
	
	String admin;
	Student student;
	Scanner scan = new Scanner(System.in);
	Student[] sList;
	
	//Constructor
	public ScoreMgmSystem_Review2() {
		System.out.print("총 몇명 등록하시겠습니까? > ");
		this.MAX_SIZE = scan.nextInt();
		this.sList = new Student[MAX_SIZE];
	};
	
	//Method
	public void insert() {
		if(currentCount > MAX_SIZE) {
			System.out.println("등록 가능 인원 초과. 최대인원 : " + MAX_SIZE +"명");
			return;
		}
		
		System.out.println("-- insert --");
		student = new Student();
		
		System.out.print("학생명> ");
		student.name = scan.next();
		
		System.out.print("국어> ");
		student.kor = scan.nextInt();
		
		System.out.print("영어> ");
		student.eng = scan.nextInt();
		
		System.out.print("수학> ");
		student.math = scan.nextInt();
		
		sList[currentCount] = student;
		currentCount++;
		
		System.out.println("=> 등록 완료!(" + currentCount + "/" + MAX_SIZE + ")");
		
		if(currentCount < MAX_SIZE) {
			System.out.print("계속 등록하시겠습니까? (y/n) > ");
			String continueInsert = scan.next();
			if(continueInsert.equals("y")) {
				insert();
			}
		}
		
	}	
		
	public void show() {
		System.out.println("----------------------------------------------");
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("----------------------------------------------");
		
		for(int i =0; i < currentCount; i++) {
			Student s = sList[i];
			
			System.out.print(s.name + "\t");
			System.out.print(s.kor + "\t");
			System.out.print(s.eng + "\t");
			System.out.print(s.math + "\t");
			System.out.print(s.getTot() + "\t");
			System.out.println(s.getAvg() + "\t");
			
		}
		
		System.out.println("----------------------------------------------");
		
	}
		
	public void update() {
		System.out.println("update");
	}
	
	public void remove() {
		System.out.println("remove");
	}
	
	public void search() {
		System.out.println("search");
	}
	
	
}
