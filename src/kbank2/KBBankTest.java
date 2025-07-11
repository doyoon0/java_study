package kbank2;

public class KBBankTest {
	
	public static void main(String[] args) {
		BankSystem kbsystem = new BankSystem("KB");
		kbsystem.showAccountList(); //은행시스템 확인
		
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();

		BankMan staffPark = new BankMan("박보검", kbsystem); //은행직원 생성시 고객리스트 정보 가짐.
		
		Customer hong = new Customer("홍길동", "kb-1234", null, 0);
		boolean validateFlag = true;
		hong.setAccountPaper(accountPaper);
//		hong.getAccountPaper().showInfo(); //getInstance로 가져옴 그러나 static이므로 그냥 "클래스.메소드"로 접근하는게 더 좋음
		
		//은행 직원이 고객의 용지를 받는다.
		staffPark.setAccountPaper(hong.getAccountPaper());
		staffPark.validateCheck(); //고객에게 전달받은 출금용지에 빈값이 있는지 체크

		while(validateFlag) {
			if(staffPark.validateCheck(hong.answer(staffPark.checkResult))) {
				validateFlag = false;
			}; 
		}
		
		
//		hong.answer(staffPark.checkResult); //answer 만들기전에 함 테스트 해봄
		AccountPaperVo.showInfo();
		System.out.println("출금 진행!!!!!!!!!!!!!!!!!!!");
		
		staffPark.processWithdrawal();
		
//		고객이 잔액을 확인하고 퇴장함 [종료]
		kbsystem.confirmBalance(hong.getAccountPaper()); //은행시스템을 이용하여 잔액을 확인
		
	}

}
