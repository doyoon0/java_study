package chapter06;

import java.util.Scanner;

public class ScoreTestVer4_Review {

	public static void main(String[] args) {
		
		//0. 변수 선언
		Scanner scan = new Scanner(System.in);
		System.out.print("등록할 총 인원수를 입력해주세요. > ");
		final int MAX_SIZE = scan.nextInt(); 
		int[][] scoreList = new int[MAX_SIZE][];
		String[] subjectList = {"국어", "영어", "수학"};
		String[] nameList = new String[MAX_SIZE];
		int count = 0; //등록된 학생 수 저장
		
		//1. 메뉴
		System.out.println("-------------------------------------------");
		System.out.println("\t더조은 고등학교 성적관리 프로그램");
		System.out.println("-------------------------------------------");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 리스트 출력");
		System.out.println("3. 학생 성적 검색");
		System.out.println("9. 프로그램 종료");
		System.out.println("-------------------------------------------");
		
		//2. 메뉴선택		
		System.out.print("\n메뉴선택(숫자)> ");
		int menu = scan.nextInt();
		
		if(menu == 1) {
			for(int i=count; i<nameList.length; i++) {
				System.out.print("학생명 > ");
				nameList[i] = scan.next();
				
				scoreList[i] = new int[5];
				int tot = 0;
				int avg = 0;
				for(int j=0; j<subjectList.length; j++) {
					System.out.print(subjectList[j] + " > ");
					scoreList[i][j] = scan.nextInt();
					tot += scoreList[i][j];
					avg = tot/3;
				}
				
				scoreList[i][scoreList[i].length-2] = tot; //총점
				scoreList[i][scoreList[i].length-1] = avg; //평균
				
				count++;
				
			}
			
		} else if(menu == 2) {
			
		} else if(menu == 3) {
			
		} else if(menu == 9) {
			
		} else {
			
		}
		
		
		
	}//main

}//class
