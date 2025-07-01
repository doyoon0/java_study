package chapter06;

import java.util.Scanner;

/*
 * ScoreTestVer3의 점수 저장을 2차원 배열 구조로 수정함
 */
public class ScoreTestVer4 {

	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		boolean menuFlag = true;
		
		System.out.print("크기 입력 > ");
		final int MAX_SIZE = scan.nextInt(); 
		
		String[] nameList = new String[MAX_SIZE];
		int[][] scoreList = new int[MAX_SIZE][];

		int count = 0; //등록된 학생수 저장
		
		while(menuFlag) {
			System.out.println("-------------------------------------------");
			System.out.println("\t더조은 고등학교 성적관리 프로그램");
			System.out.println("-------------------------------------------");
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 리스트 출력");
			System.out.println("3. 학생 성적 검색");
			System.out.println("9. 프로그램 종료");
			System.out.println("-------------------------------------------");
			
			System.out.print("\n메뉴선택(숫자)> ");
			menu = scan.nextInt();
			
			if(menu == 1) { //학생 등록
				String[] subjectList = {"국어", "영어", "수학"};
				for(int i=count; i<nameList.length; i++) { //쌓이지않고 0번째에만 들어가서 문제.
					System.out.print("학생명 > ");
					nameList[i] = scan.next();
					
					//학생의 점수를 입력할 배열을 생성함
					scoreList[i]= new int[5];
					int tot = 0;
					int avg = 0;
					for(int j=0; j<subjectList.length; j++) {
						System.out.print(subjectList[j] + "> ");
						scoreList[i][j] = scan.nextInt();
						tot += scoreList[i][j];
						avg = tot/3;
					}
					
					scoreList[i][scoreList[i].length-2] = tot; //총점
					scoreList[i][scoreList[i].length-1] = avg; //평균
					
					count++;
					
					System.out.print("계속하시려면 아무키나 눌러주세요, 종료를 원할시 n입력.");
					if((scan.next()).equals("n")) {
						//종료 break;
						i = nameList.length; //자연스럽게 종료
						System.out.println("=> 등록 완료!");
					}
				}
				
			} else if(menu == 2) { //학생 리스트 출력
				if(count != 0) { //nameList[0] != null
					//Step3 : 데이터 출력
					System.out.println("-------------------------------------------");
					System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
					System.out.println("-------------------------------------------");
					
					for(int i=0; i<count; i++) {
						System.out.print(nameList[i] + "\t");
						
						for(int j=0; j<scoreList[i].length; j++) { //5번 돌아야함
							System.out.print(scoreList[i][j] + "\t");
						}
						System.out.println(); // 줄바꿈
					}
					System.out.println("-------------------------------------------");
				} else {
					System.out.println("=> 등록된 데이터가 없습니다. 등록을 진행해주세요.");
				}
			} else if (menu == 3) { //학생 성적 검색
				boolean searchFlag = true;
				while(searchFlag) {
					System.out.print("학생명 검색 > ");
					String searchName = scan.next();
					int searchIdx = -1; 
					int countIdx = 0;
					for(String name : nameList)  {
						if(name != null) {
							
							if(name.equals(searchName)) {
								searchIdx = countIdx;
							}
							countIdx++; ///////////////////////////////////////////////////////// 나 여기 왜 다르지
						
						}
					}
					if(searchIdx != -1) {
						System.out.println("-------------------------------------------");
						System.out.println("검색결과");
						System.out.println("-------------------------------------------");
						System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
						System.out.println("-------------------------------------------");	
						
						for(int score: scoreList[searchIdx]) {
							System.out.print(score + "\t");
						}
						System.out.println();
						System.out.println("-------------------------------------------");
						
						System.out.print("계속 검색하시겠습니까? > ");
						if((scan.next()).equals("n")) {
							searchFlag = false;
						}
					} else {
						System.out.println("=> 검색한 데이터가 없음.");
					}
				}//while
				
			} else if (menu == 9) { //프로그램 종료
				System.out.println("-- 프로그램 종료 --");
				System.exit(0); // 나머지 while문 실행하지않고 그냥 나옴
			} else {
				System.out.println("메뉴 준비중입니다.");
			}
			
		}//while
		
		System.out.println("-- 프로그램 종료 --");
	}//main

}//class
