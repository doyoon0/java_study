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
		String[] subjectList = {"국어", "영어", "수학"};
		int tot = 0; //메뉴1, 4 공용으로 사용하는 변수이므로, 단계별 초기화 필요!!
		int avg = 0;

		int count = 0; //등록된 학생수 저장
		
		while(menuFlag) {
			System.out.println("-------------------------------------------");
			System.out.println("\t더조은 고등학교 성적관리 프로그램");
			System.out.println("-------------------------------------------");
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 리스트 출력");
			System.out.println("3. 학생 성적 검색");
			System.out.println("4. 학생 성적 수정");		
			System.out.println("5. 학생 삭제");	
			System.out.println("9. 프로그램 종료");
			System.out.println("-------------------------------------------");
			
			System.out.print("\n메뉴선택(숫자)> ");
			menu = scan.nextInt();
			
			if(menu == 1) { //학생 등록
//				
				for(int i=count; i<nameList.length; i++) { //쌓이지않고 0번째에만 들어가서 문제.
					System.out.print("학생명 > ");
					nameList[i] = scan.next();
					
					//학생의 점수를 입력할 배열을 생성함
					scoreList[i]= new int[5];

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
							
							if(name.equals(searchName)) searchIdx = countIdx;
							countIdx++; 
						
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
				
			} else if (menu == 4) { //학생 성적 수정
				//(1) 수정할 학생명의 존재여부 검색 : 유 -> 새로운 성적 입력 후 수정
				//(2) 수정할 학생명의 존재여부 검색 : 무 -> 검색 데이터 존재X, 반복진행
				boolean modiFlag = true;
				while(modiFlag) {
					System.out.print("[수정]학생명 검색> ");
					String modifiedName = scan.next();
					int modiIdx = -1;
					
					for(int i=0; i<count; i++) {
						if(nameList[i].equals(modifiedName)) modiIdx = i;
					}
					
					if(modiIdx == -1) {
						System.out.println("수정할 데이터가 존재X, 다시 입력해주세요");
					} else {
						//학셍 데이터 수정할 배열 생성
						scoreList[modiIdx] = new int[5];
						tot = 0;
						avg = 0;

						for(int j=0; j<subjectList.length; j++) {
							System.out.print(subjectList[j] + "> ");
							scoreList[modiIdx][j] = scan.nextInt();
							tot += scoreList[modiIdx][j];
							avg = tot/3;
						}
						
						scoreList[modiIdx][scoreList[modiIdx].length-2] = tot; //총점
						scoreList[modiIdx][scoreList[modiIdx].length-1] = avg; //평균
						
						System.out.println("=> 수정 완료!");
						System.out.println("-------------------------------------------");
						System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
						System.out.println("-------------------------------------------");
						
						System.out.print(nameList[modiIdx] + "\t");
						
						for(int score : scoreList[modiIdx]) {
							System.out.print(score + "\t");
						}
						
						System.out.println("\n-------------------------------------------");
						System.out.print("계속 수정?(계속:아무키나누르세요, 종료:n)> ");
						if(scan.next().equals("n")) {
							modiFlag = false;  //or break;
						}	
					}
				}
			} else if(menu == 5){ //학생 삭제
				if(count != 0) {
					boolean deleteFlag = true;
					while(deleteFlag) {
						System.out.print("[삭제] 학생명 검색> ");
						String deleteName = scan.next();
						int deleteIdx = -1;
						for(int i=0; i<count; i++) {
							if(nameList[i].equals(deleteName)) deleteIdx = i;
						}
						
						if(deleteIdx != -1) {
							for(int i=deleteIdx; i<count-1; i++) {
								nameList[i] = nameList[i+1];
								scoreList[i] = scoreList[i+1];	//객체 자체를 땡겨오면 된다.
							}
							count--;
							
							System.out.print("계속 삭제?(계속:아무키나누르세요, 종료:n)> ");
							if(scan.next().equals("n")) {
								deleteFlag = false;  //or break;
							}	
							
						} else {
							System.out.println("삭제할 데이터가 존재X, 다시 입력해주세요");
						}
						
					}//while-delete
				} else {
					System.out.println("=> 등록된 데이터가 없습니다. 등록을 진행해 주세요.");
				}
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
