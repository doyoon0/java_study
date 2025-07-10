package kbank;

/**
 * 은행 직원 클래스
 */
public class BankMan {
	String name;
	AccountPaperVo accountpaper;
	AccountVo[] accountList;	//은행 고객 리스트
	Customer customer;
	
	public BankMan() {
		this("변우석");
	}
	public BankMan(String name) {
		this.name = name;
		accountList = createAccountList(); //자기가 관리하는 고객정보를 기억함
	}
	
	/**
	 * 은행직원이 관리하는 고객 리스트 생성
	 */
	public AccountVo[] createAccountList() {
		String[] names = {"홍길동", "이순신", "김유신"};
		String[] numbers = {"kb-1234", "kb-9876", "kb-3456"};
		String[] passwords = {"1234", "9876", "3456"};
		int[] balances = {500, 1000, 700};
		
		AccountVo[] list = new AccountVo[names.length];
		
		for(int i=0; i<names.length; i++) {
			AccountVo account = new AccountVo();
			account.setName(names[i]);
			account.setAccountNumber(numbers[i]);
			account.setPassword(passwords[i]);
			account.setBalance(balances[i]);
			
			list[i] = account;
		}
		return list;
		
	}
	
	/**
	 * 은행직원이 관리하는 고객 리스트 출력
	 */
	public void showAccountList() {
		System.out.println("------------------------------------");
		System.out.println("\tKB 고객 리스트");
		System.out.println("------------------------------------");
		for(int i=0; i<accountList.length; i++) {
			AccountVo account = accountList[i];
			System.out.print((i+1) +".\t");
			System.out.print(account.getName() + "\t");
			System.out.print(account.getAccountNumber() + "\t");
			System.out.print(account.getPassword() + "\t");
			System.out.println(account.getBalance() + "\t");
		}
		System.out.println("------------------------------------");
	}
	
	/**
	 * 용지 확인(출금용지 받아서 체크)
	 */
	public void check(AccountPaperVo paper, Customer customer) {
		this.customer = customer;
		
		System.out.println("[은행직원 : " + name + "] 출금 용지 정보를 확인하는 중입니다.");
		if(paper.getName() == null) {
			System.out.println("[은행직원 : " + name + "] 이름을 입력해주세요.");
			System.out.print("[고객 : " + customer.getName() + "] 이름을 입력 > ");
			String name = customer.getScan().next();
			paper.setName(name);
			System.out.println("고객명 ===>> "+paper.getName());
		} else if(paper.getAccountNumber() == null) {
			System.out.println("[은행직원 : " + name + "] 계좌번호를 입력해주세요.");
		} else if(paper.getPassword() == null) {
			System.out.println("[은행직원 : " + name + "] 패스워드를 입력해주세요.");
		} else if(paper.getMoney() == 0) {
			System.out.println("[은행직원 : " + name + "] 금액을 입력해주세요.");
		} else {
			System.out.println("[은행직원 : " + name + "] 정보 확인이 완료되었습니다.");
		}
		
	}
	
	/**
	 * 금액 문의
	 */
	public void askMoney(int Money) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class
