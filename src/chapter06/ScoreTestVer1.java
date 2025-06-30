package chapter06;

import java.util.Scanner;

/*
 * 학생 한명의 국어, 영어, 수학 점수를 입력받아 출력하는 로직
 */
public class ScoreTestVer1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String name = null;
		int[] scoreList = new int[5];
		String[] subjectList = {"국어", "영어", "수학"};
		
		// 1. 데이터 입력
		System.out.print("학생명> ");
		name = scan.next();
		double tot = 0.0;
		double avg = 0.0;
		
		for(int i=0; i<scoreList.length; i++) { // 데이터를 입력받으니 기존 for문, 출력할때는 향상된 for문이 유리
			if(i<scoreList.length-2) { // 인덱스 0부터 n-2까지 
				System.out.print(subjectList[i] + "점수 > ");
				scoreList[i] = scan.nextInt();
				tot += scoreList[i];
				
			} else { // 마지막 두 인덱스 도달했을때 (총점과 평균)
				scoreList[scoreList.length-2] = (int)tot;
				scoreList[scoreList.length-1] = (int)(avg = tot/subjectList.length);
				i = scoreList.length; //break 대신 for문을 자연스럽게 종료하기 위한 장치
//				break;
			}
		}
		
		// 2. 데이터 출력 : 학생명, 국어, 영어, 수학 점수, 총점 평균
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.print(name + "\t");
		for(int score : scoreList) {
			System.out.print(score + "\t");
		}

	}

}
