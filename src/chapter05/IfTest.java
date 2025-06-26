package chapter05;

import java.util.Scanner;

/*
 * 단일 if문 : 조건의 결과가 true인 경우에만 실행함 
 * if ~ else : 조건의 결과가 true/false 경우에 각각 실행함
 * 형식) if(조건식) { 실행문; } else { 실행문; }
 * if ~ else if ~ ... ~ else :  여러개의 조건을 체크하여 실행, 모든 조건에 만족하지 않는 경우 else가 실행됨
 * 형식) if(조건식1) {
 * 			조건식1이 true인 경우 실행문;
 * 		} else if (조건식2) {
 * 			조건식2가 ture인 경우 실행문;
 * 		} ...
 * 		} else {
 * 			위의 모든 조건이 false인 경우 실행문;
 * 		}
 * ✔각 if문의 실행문이 한줄인 경우에는 {}(블록)을 생략할 수 있음r
 */
public class IfTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("점수 > ");
		int score = scan.nextInt();
		
		System.out.println("-- 시험 시작 --");
		
		//학점 출력 95점이상 (A+), 90점이상(A), 85점이상(B+), 80점이상(B)... 60점이하(F)
		if(score >= 95) {
			System.out.println("    A+");
		} else if (score >= 90) {
			System.out.println("    A");
		} else if (score >= 85) {
			System.out.println("    B+");
		} else if (score >= 80) {
			System.out.println("    B");
		} else if (score >= 75) {
			System.out.println("    C+");
		} else if (score >= 70) {
			System.out.println("    C");
		} else if (score >= 65) {
			System.out.println("    D+");
		} else if (score > 60) {
			System.out.println("    D");
		} else {
			System.out.println("    F");
		}
		
		System.out.println("-- 시험 종료 --");
		
		scan.close();
	}

}
