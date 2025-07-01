package chapter06;

import java.util.Scanner;

/*
 * 더조은 고등학교 1학년 1반 학생들의 성적관리 프로그램
 * - 학생은 홍길동, 이순신, 김유신, 강감찬, 홍길순
 * - 과목은 국어, 영어, 수학 3과목의 점수를 입력
 * - 입력받은 과목의 총점과 평균을 구함
 * - 학생명, 과목별 점수, 총점, 평균은 각각 1차원 배열로 생성하여 관리
 * - 입출력을 위해서 각 배열의 주소를 통일시킨다.
 * 
 * 프로그래밍 방식 : 구조적(Structured) 방식, 객체지향적(Object Oriented) 방식
 * 
 * - 작업순서
 * (1) 학생이름 입력/저장/출력
 * (2) 한명을 입력하면 더 진행할 것인지 여부 확인
 * (3) 과목 및 총점 평균 추가 저장
 * (4) null 값일 때 출력하지 않는 로직 추가
 * (5) 반복된 기능 grouping
 * (6) 검색 기능 
 * (7) 검색 반복, 중단(while, flag)
 * (8) 학생 여러명 등록
 */
public class ScoreTestVer2 {

	public static void main(String[] args) {
		System.out.println("-------------------------------------------");
		System.out.println("\t더조은 고등학교 성적관리 프로그램");
		System.out.println("-------------------------------------------");
		
		//Step1 : 배열, 변수 선언
		Scanner scan = new Scanner(System.in);
		System.out.print("크기 입력 > ");
		final int MAX_SIZE = scan.nextInt(); 
		
		String[] nameList = new String[MAX_SIZE];
		int[] korList = new int[MAX_SIZE];
		int[] engList = new int[MAX_SIZE];
		int[] mathList = new int[MAX_SIZE];
		int[] totList = new int[MAX_SIZE];
		int[] avgList = new int[MAX_SIZE];
		
		//Step2 : 데이터 입력 - 실행시 외부에서 입력
		for(int i=0; i<nameList.length; i++) {
			System.out.print("학생명 > ");
			nameList[i] = scan.next();
			
			System.out.print("국어 > ");
			korList[i] = scan.nextInt();
			
			System.out.print("영어 > ");
			engList[i] = scan.nextInt();
			
			System.out.print("수학 > ");
			mathList[i] = scan.nextInt();
			
			totList[i] = korList[i] + engList[i] + mathList[i]; //총점
			avgList[i] = totList[i]/3; //평균
			
			System.out.print("계속하시려면 아무키나 눌러주세요, 종료를 원할시 n입력.");
			if((scan.next()).equals("n")) {
				//종료 break;
				i = nameList.length; //자연스럽게 종료
			}
		}
		
		//Step3 : 데이터 출력
		System.out.println("-------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------");
		
		for(int i=0; i<nameList.length; i++) {
			if(nameList[i] != null) { //주소가 없는 상태를 비교			
				System.out.print(nameList[i] + "\t");
				System.out.print(korList[i] + "\t");
				System.out.print(engList[i] + "\t");
				System.out.print(mathList[i] + "\t");
				System.out.print(totList[i] + "\t");
				System.out.print(avgList[i] + "\n");
			}
		}
		System.out.println("-------------------------------------------");
		
		boolean searchFlag = true;
		while(searchFlag) {
			//Step4 : 데이터 조회
			//조회할 학생명 입력
			System.out.print("학생명 검색 > ");
			String searchName = scan.next();
			int count = 0;
			int searchIdx = -1; //못찾았을 경우 첫번째 결과값이 나오면 안되니까.
			//nameList에서 입력한 학생명 검색 --> 학생의 nameList 주소를 변수에 저장한다.
			for(String name : nameList)  {
				if(name != null) {
					
					if(name.equals(searchName)) {
						searchIdx = count;
					}
					count++;
				
				}
			}
			//System.out.println("검색결과 주소 : " + searchIdx);
			
			//Step5 : 데이터 조회 결과 출력
			System.out.println("-------------------------------------------");
			System.out.println("검색결과");
			System.out.println("-------------------------------------------");
			System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
			System.out.println("-------------------------------------------");	
				
			System.out.print(nameList[searchIdx] + "\t");
			System.out.print(korList[searchIdx] + "\t");
			System.out.print(engList[searchIdx] + "\t");
			System.out.print(mathList[searchIdx] + "\t");
			System.out.print(totList[searchIdx] + "\t");
			System.out.print(avgList[searchIdx] + "\n");
	
			System.out.println("-------------------------------------------");
			
			System.out.print("계속 검색하시겠습니까? > ");
			if((scan.next()).equals("n")) {
				searchFlag = false;
			}
			
		}//while - searchFlag : Step4, Step5 반복
		
		System.out.println("--프로그램 종료--");
		
	}//main

}//class
