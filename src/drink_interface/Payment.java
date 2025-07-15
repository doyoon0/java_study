package drink_interface;

public class Payment {
	//Field
	int amount;		//손님이 낸 금액
	int change; 	//잔돈
	
	//Constructor
	//생성자를 통해 만들면 입금금액별로 객체를 새로만드는것이다.
	//누구의 값을추가할지. amount를 추가하는거니까 setter와 getter 함수를 이용한다.
	public Payment() {}
	
	//Method
	public void setAmount(int amount) {
		this.amount += amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public int getChange() {
		return change;
	}
	
	public boolean getPayment(int total) {
		boolean result = false;
		if(amount >= total) {
			change = amount - total;
			result = true;
		}
		
		return result; 
	}
}
