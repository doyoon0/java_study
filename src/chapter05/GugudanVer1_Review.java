package chapter05;

public class GugudanVer1_Review {

	public static void main(String[] args) {
		
		for(int i=1; i<10; i++ ) {
			
			if(i == 1) {
				for(int j=2; j<10; j++) {
					System.out.print(j + "단\t\t");
				}
				System.out.println();
			}
			
			
			for(int j=2; j<10; j++ ) {
				System.out.print(j + " X " + i + " = " + (i*j) + "\t");
			}
			
			System.out.println();
		}
	}

}
