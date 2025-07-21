package chapter17;

public class MainThreadTest {

	public static void main(String[] args) { //mainThread (1) boss
		// 1~10 정수 출력
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
		
		ThreadExtend te = new ThreadExtend(); //te Thread (1) - intern 1 : 각자 실행 후 종료
		te.start(); //별도의 일을 진행하는 사원. 이 메소드의 실행 여부와 생관없이 main 쓰레드가 먼저 종료된다.
		
		//Thread(Runnable task); Runnable은 독립적으로 사용 불가능
		Thread t = new Thread(new RunnableImpl()); //t Thread (1) - intern 2 : 각자 실행 후 종료
		t.start();		
		
		
		System.out.println("-- main 메소드 종료 --");
		
		//intern 1/2 누가먼저 실행될지는 CPU가 알아서
	}

}
