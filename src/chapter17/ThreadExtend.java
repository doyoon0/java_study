package chapter17;

public class ThreadExtend extends Thread{
	
	public ThreadExtend() {
		super("쓰레드1");
	}
	
	@Override
	public void run() {
		//1~10 까지 출력
		for(int i=1; i<=10; i++) {
			try {
				sleep(1000);	//sleep 만나면 멈춤 => 1초 후 ready pool로 내려가서 실행준비. (yield, interrupt..)
				System.out.println(getName() + " --------> " + i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

}
