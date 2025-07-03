package chapter07;

import java.util.Scanner;

/*
 * - 학생 3명의 점수를 입력 받는다.
 * - 한 명 입력 후 계속 입력 여부를 메시지로 출력 후 입력 받는다.
 */
public class ScoreMgmSystem_Review {
	//Field
	private int MAX_SIZE;							//[추가] 최대 입력 크기
	private int currentCount =0; 					//[추가] 현재 등록된 학생 수
	
	String admin;
	Student student;								//[유의할점] 한명의 데이터만 저장하는 객체
	Scanner scan = new Scanner(System.in);
	Student[] sList;								//[유의할점] 여러명의 데이터를 저장하는 객체
	
	//Constructor
	public ScoreMgmSystem_Review() {
		System.out.print("최대 학생 수 > ");			//[추가] insert 등의 메소드를 실행하기 전에, 초기화가 되어야함
		this.MAX_SIZE = scan.nextInt();				//[추가] 사용자에게 최대 크기 입력 받은걸로 초기화
		this.sList = new Student[MAX_SIZE];			//[추가] 최대 크기 적용된 Student 배열을 sList에 초기화
	};
	
	//Method
	public void insert() {
		if(currentCount >= MAX_SIZE) {				//[추가] 유효성 검사
			System.out.println("=> 등록 가능한 학생 수 초과. (최대 " + MAX_SIZE + "명)");
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
		
		sList[currentCount] = student; 				//[추가] 사용자가 직접 크기를 정한 상자에 사용자가 입력한 학생정보 꾸러미를 넣는다.
		currentCount++;
		
		System.out.println("=> 등록 완료! (" + currentCount + "/" + MAX_SIZE + ")");
		
		if (currentCount < MAX_SIZE) {				//[추가] 입력 여부 확인
			System.out.print("계속 입력하시겠습니까? (y/n) > ");
			String continueInput = scan.next();
			if(continueInput.equals("y")) {
				insert();
			}
		}
		
	}	
		
	public void show() {
		
		if(currentCount == 0) {
			System.out.println("=> 등록된 학생이 없습니다.");
			return;
		}
		
		System.out.println("----------------------------------------------");
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("----------------------------------------------");
		for(int i=0; i<currentCount; i++) {
			Student s = sList[i];	// 이미 생성되어있는 sList[i]를 Student 꾸러미에 담는다.
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
