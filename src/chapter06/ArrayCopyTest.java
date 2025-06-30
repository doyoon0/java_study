package chapter06;

import java.util.Arrays;

/*
 * 배열 복사 : for, System.arrayCopy(), Arrays.copyOf()
 */
public class ArrayCopyTest {

	public static void main(String[] args) {
		// 1. for
		int[] arrInt = {1, 2, 3};
		int[] arrInt2 = new int[5];
		int[] arrInt3 = new int[3]; //System.arrayCopy()
		
		for(int i=0; i<arrInt.length; i++) {
			arrInt2[i] = arrInt[i];
		}
		
		for(int i=0; i<arrInt2.length; i++) System.out.print(arrInt2[i] + "\t");
		
		System.out.println();
		
		// 2. System.arrayCopy()
//		System.arraycopy(원본배열, 원본시작인덱스, 대상배열, 대상시작인덱스, 복사할개수);
		System.arraycopy(arrInt2, 0, arrInt3, 0, arrInt.length); // (length+1) 메모리주소는 미리 알수없어서 syntax error는 안나지만 실행시 에러남
		for(int i=0; i<arrInt3.length; i++) System.out.print(arrInt3[i] + "\t");
		
		System.out.println();
		
		// 3. Arrays.copyOf()
//		Arrays.copyOf(원본, 대상배열크기) - 전체복사
		int[] arrInt4 = Arrays.copyOf(arrInt, arrInt.length); // 원본과 같은 크기로 복사.
		for(int i=0; i<arrInt4.length; i++) System.out.print(arrInt4[i] + "\t");
	}

}
