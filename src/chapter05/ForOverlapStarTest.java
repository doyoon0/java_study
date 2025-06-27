package chapter05;

/*
[시작]
 * *
 * **
 * ***
 * ****
 * *****
 * [종료]
 */
public class ForOverlapStarTest {
	public static void main(String[] args) {
		
		for(int i=1; i<=5 ; i++) {	//행
			for(int j=1; j<=i; j++) {	//열
				System.out.print("🍔");
			}
			
			System.out.println();
		}
		
		System.out.println("----------");
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5-i+1; j++) {
				System.out.print("🍟");
			}
			
			System.out.println();
		}
		
		System.out.println("---------");
		
		for(int i=1; i<=5; i++) {
			
			for(int k=1; k<=5-i; k++) {
				
				System.out.print("-");
			}
			
			for(int j=1; j<=2*i-1; j++) {
				
				System.out.print("*");
			}
			
			for(int m=1; m<5-i+1; m++) {
				System.out.print("-");
			}
			
			System.out.println();
		}
		
	}
}
