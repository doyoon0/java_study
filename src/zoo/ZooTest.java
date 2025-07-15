package zoo;

import java.util.ArrayList;
import java.util.List;

public class ZooTest {

	public static void main(String[] args) {
		List<Lion> list = new ArrayList<Lion>();
		List<AnimalInterface> list2 = new ArrayList<AnimalInterface>(); //인터페이스 상속받은애 다들어감
		
		Lion lion1 = new Lion();
		Tiger tiger1 = new Tiger();
		
		list.add(lion1);
//		list.add(tiger1); //list는 Lion 클래스 객체만 저장 가능
		
		list2.add(lion1); //자동(묵시적) 형변환을 통해 list2에 저장
		list2.add(tiger1);//자동(묵시적) 형변환을 통해 list2에 저장
		
		list.get(0).sleep();;
		list.get(0).eat();;
		
		System.out.println(list2.get(0).getName()); 
		System.out.println(list2.get(1).getName()); 
		
		list2.get(0).eat();
		list2.get(1).sleep();
		list2.get(1).eat();
		
		
		
		Lion lion2 = (Lion)list2.get(0); //객체의 저장된 속성(값)은 강제(명시적) 형변환을 통해 진행
		System.out.println("lion2.name --> " + lion2.name);
		
	}

}
