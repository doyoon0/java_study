package chapter04;

import java.util.Scanner;

public class LotteWorldTest {

	public static void main(String[] args) {
		// 놀이기구 탑승 전 체크사항
		//1. 6세 이상 탑승(단, 6세이하는 키가 120cm 이상이고 보호자 동반하에 탑승가능)
		//2. 키 120cm 이상 탑승 가능
		//3. 심장질환자는 탑승 불가
		
		Scanner scan = new Scanner(System.in);
		
		//지역변수를 선언하는 경우에는 반드시 초기화를 진행한다.
		String name = "";
		int age = 0;
		int height = 0;
		boolean parent = false;
		boolean heartDease = false;
		
		String result = "";
		
		System.out.println("****************************************");
		System.out.println("\t놀이기구 탑승전 유의사항 및 체크");
		System.out.println("****************************************");
		
		System.out.print("안녕하세요, 성함을 입력해주세요 > ");
		name = scan.next();
				
		System.out.println("어서오세요 " + name + "님! 놀이기구에 탑승하시려면 다음 정보를 입력하세요.");
		System.out.print("나이 > ");
		age = scan.nextInt();
		
		System.out.print("신장 > ");
		height = scan.nextInt();
		
		System.out.print("부모님 동반(동반o:1, 동반x :0) > ");
		parent = scan.nextInt() == 1 ? true : false;
		
		System.out.print("심장질환(있음o:1, 없음x :0) > ");
		heartDease = scan.nextInt() == 1 ? true : false;
		
//		System.out.println("입력한 정보 : " + name + ", " + age + ", " + height + ", " + parent + ", " + heartDease);
		result = ((age >= 6 && height >= 120) || (age <= 6 && parent == true)) && (heartDease == false) ? "\n탑승가능!" : "\n탑승불가능!!";
		
		System.out.println(result);

	}

}
