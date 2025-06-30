package chapter06;

import java.util.Scanner;

/*
 * 학생 한명의 국어, 영어, 수학 점수를 입력받아 출력하는 로직
 */
public class ScoreTestVer1_Review {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 > ");
		String name = scan.next();
		
		int scoreList[] = new int[5];
		String subjectList[] = {"국어", "영어", "수학"};
		int tot = 0;
		int avg = 0;
		
		for(int i=0; i<scoreList.length; i++) {
			if(i < scoreList.length-2) {
				System.out.print(subjectList[i] + "점수 > ");
				scoreList[i] = scan.nextInt();
				tot += scoreList[i];
			} else {
				scoreList[scoreList.length-2] = tot;
				scoreList[scoreList.length-1] = tot/subjectList.length;
				i = scoreList.length;
			}
		}
		
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.print(name + "\t");
		
		for(int score : scoreList) {
			System.out.print(score + "\t");
		}
		
		
	}

}
