package kbank2;

/**
 * 은행 직원 클래스
 */
public class BankMan {
	String name;
	int checkResult;
	private AccountPaperVo accountPaper; //고객정보 공유해서 쓸거니까 new 하지 않음
	private AccountVo[] accountList;	//은행 고객 리스트
	private BankSystem kbsystem;
	
	public static final int ACCOUNT_NAME = 1;
	public static final int ACCOUNT_NUMBER = 2;
	public static final int ACCOUNT_PASSWORD = 3;
	public static final int ACCOUNT_MONEY = 4;
	
	public BankMan() {};
	
	public BankMan(String name, BankSystem kbsystem) {
		this.name= "[은행직원 : " + name + "]";
		this.kbsystem = kbsystem;
		System.out.println(this.name + " 업무 시작!!");
	}
	
	/**
	 * 고객의 출금정보 유효성 체크 결과에 따라 질문
	 */
	public void ask(int status) {
		switch (status) {
			case ACCOUNT_NAME :
				System.out.println(this.name + " 이름을 입력해주세요!!");
				checkResult = ACCOUNT_NAME; 
				break;
			case ACCOUNT_NUMBER :
				System.out.println(this.name + " 계좌번호를 입력해주세요!!");
				checkResult = ACCOUNT_NUMBER; 
				break;
			case ACCOUNT_PASSWORD:
				System.out.println(this.name + " 패스워드를 입력해주세요!!");
				checkResult = ACCOUNT_PASSWORD; 
				break;
			case ACCOUNT_MONEY:
				System.out.println(this.name + " 금액을 입력해주세요!!");
				checkResult = ACCOUNT_MONEY; 
				break;
		}
	}
	
	/**
	 * 고객의 출금정보 유효성 체크 : 고객에게 전달받은 출금용지에 빈값이 있는지 체크!
	 */
	public void validateCheck() {
		System.out.println(this.name + " 고객 정보에 대한 유효성 체크를 진행한다!");
		if(accountPaper.getName() == null) {
			ask(ACCOUNT_NAME);
		} else if(accountPaper.getAccountNumber() == null) {
			ask(ACCOUNT_NUMBER);
		} else if(accountPaper.getPassword() == null) {
			ask(ACCOUNT_PASSWORD);
		}else if(accountPaper.getMoney() == 0) {
			ask(ACCOUNT_MONEY);
		} else {
			//모두 입력되어 있음
			System.out.println("모두 입력");
		}
	}
	
	/**
	 * 고객의 출금정보 유효성 체크 : 고객에게 전달받은 출금용지에 빈값이 있는지 체크! OverLoading
	 */
	public boolean validateCheck(AccountPaperVo updateAccountPaper) {
		boolean result = false;
		System.out.println(this.name + " 고객 정보에 대한 유효성 체크를 진행한다!");
		this.accountPaper = updateAccountPaper;
		
		if(accountPaper.getName() == null) {
			ask(ACCOUNT_NAME);
		} else if(accountPaper.getAccountNumber() == null) {
			ask(ACCOUNT_NUMBER);
		} else if(accountPaper.getPassword() == null) {
			ask(ACCOUNT_PASSWORD);
		}else if(accountPaper.getMoney() == 0) {
			ask(ACCOUNT_MONEY);
		} else {
			//모두 입력되어 있음
			System.out.println("모두 입력");
			result = true;
		}
		return result;
	}
	
	/**
	 * 출금 요청 처리
	 */
	public void processWithdrawal() {
		System.out.println(this.name + " 출금요청 처리 진행중입니다. 잠시만 기다려 주세요.");
		//고객계정 검색 - BankSystem > 계정있다! > 잔고 - 출금액
		int accountIdx = kbsystem.searchAccount(accountPaper);
		System.out.println(accountIdx + "  우아아아아아앙아~~~~~~~~~~~");
		if(accountIdx != -1) {
			//출금진행
			AccountVo account = kbsystem.accountList[accountIdx];
			if(account.getBalance() >= accountPaper.getMoney()) {
				// === 테스트 출력 시작 ===
	            System.out.println("🧪 테스트: 출금 전 잔액");
	            System.out.println("account 잔액: " + account.getBalance()); //account 잔액: 500
	            System.out.println("배열 잔액: " + kbsystem.accountList[accountIdx].getBalance()); //배열 잔액: 500
	            System.out.println("같은 객체? " + (account == kbsystem.accountList[accountIdx])); //같은 객체? true
	            
				//출금 진행 후 계좌 업데이트!!!!!!!!!!!!!!!!!!
				int money = account.getBalance() - accountPaper.getMoney();
				account.setBalance(money); // 여기까지만하면 account 변수만 업데이트 되고 실제 값은 업데이트 안된다???
//				kbsystem.accountList[accountIdx] = account; // 없어도 될거같은디..
				
				System.out.println("🧪 테스트: 출금 후 잔액");
	            System.out.println("account 잔액: " + account.getBalance()); //account 잔액: 300
	            System.out.println("배열 잔액: " + kbsystem.accountList[accountIdx].getBalance()); //배열 잔액: 300
	            //테스트 출력 끝
				
				processCompleted();
			} else {
				//잔액이 부족
				System.out.println(this.name + " 잔액이 부족합니다.");
			}
			
		} else {
			//고객정보가 일치하지 않음
			System.out.println(this.name + " 계좌정보가 일치하지 않습니다. 확인후 다시 진행해주세요.");
		}
	}
	
	/**
	 * 
	 */
	public void processCompleted() {
		System.out.println(this.name + " 출금처리가 완료되었습니다.");
		System.out.println(this.name + " 출금액은 " + accountPaper.getMoney() + " 입니다.");
		
	}

	public AccountPaperVo getAccountpaper() {
		return accountPaper;
	}

	public void setAccountPaper(AccountPaperVo accountpaper) { //주소를 받아서 넣는것
		this.accountPaper = accountpaper;
		System.out.println(this.name + " 고객에게 출금용지 받음!");
	}

	public AccountVo[] getAccountList() {
		return accountList;
	}

	public void setAccountList(AccountVo[] accountList) {
		this.accountList = accountList;
	}

	public BankSystem getKbsystem() {
		return kbsystem;
	}

	public void setKbsystem(BankSystem kbsystem) {
		this.kbsystem = kbsystem;
	};
	
	
	
}//class
