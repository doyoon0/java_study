package chapter06;

/*
 * 향상된 for - 배열이나 컬렉션(List) 객체에 사용됨
 */
public class ArrayOfForTest {

	public static void main(String[] args) {
		int[] nlist = {1, 2, 3, 4, 5};
		
		// 일반적인 for문을 이용하여 출력
		for(int i=0; i<nlist.length; i++) {
			System.out.print(nlist[i] + "\t");
		}
		
		System.out.println();
		
		// 향상된 for문을 이용하여 출력
		for(int number : nlist) {
			System.out.print(number + "\t");
		}
	}

}
