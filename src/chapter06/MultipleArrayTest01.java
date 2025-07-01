package chapter06;

public class MultipleArrayTest01 {

	public static void main(String[] args) {
		// 3*3 => 3행 3열의 배열 생성
		int[][] matrix = new int[3][3];
		int[][] matrix2 = new int[3][];
		matrix2[0] = new int[3];
		matrix2[1] = new int[3];
		matrix2[2] = new int[3];
		
		int matrix3[][] = {{10,20,30}, {40,50,60}, {70,80,90}};
		
		matrix[0][0] = 10;
		matrix[2][1] = 50;
		
		//matrix
		for(int i=0 ; i<matrix.length ; i++) {
			for(int j=0 ; j<matrix[i].length ; j++) {
				System.out.print("["+i+","+j+"] = " + matrix[i][j]+"\t");
			}
			System.out.println();
		}
		
		//matrix2
		System.out.println("-------------------");
		for(int i=0 ; i<matrix2.length ; i++) {
			for(int j=0 ; j<matrix2[i].length ; j++) {
				System.out.print("["+i+","+j+"] = " + matrix2[i][j]+"\t");
			}
			System.out.println();
		}
		
		//matrix3
		System.out.println("-------------------");
		for(int i=0 ; i<matrix3.length ; i++) {
			for(int j=0 ; j<matrix3[i].length ; j++) {
				System.out.print("["+i+","+j+"] = " + matrix3[i][j]+"\t");
			}
			System.out.println();
		}
		

	}

}