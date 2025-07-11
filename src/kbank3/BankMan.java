package kbank3;

import java.util.Scanner;

public class BankMan {
	//Field
	Scanner scan = new Scanner(System.in);
	AccountPaperVo paper; 
	Customer cm = new Customer();
	
    AccountVo[] accounts = {
            new AccountVo("charlie", 123456789, 1234, 500),
            new AccountVo("tile", 987654321, 5678, 300)
    };

	
	//Constructor
	public BankMan() {
		greeting();
		info();
	
	}
	
	//Method
	//greeting
	public void greeting() {
		System.out.println("------------------------------------");
		System.out.println("\t🕌은행에 오신것을 환영합니다.");
		System.out.println("------------------------------------");
	}
	
	//정보 입력
	public void info() {
		System.out.println("============ 출금 용지 기입 ============");
		paper = cm.write();
		
		//입력 정보 확인
		checkPaper();
	}
	
	//check paper
	public void checkPaper() {
		System.out.println("------------------------------------");
		System.out.println("\t🕌입력하신 정보를 보여드리겠습니다.");
		System.out.println("------------------------------------");
		System.out.println("============ 출금 용지 정보 ============");
        System.out.println("이름: " + paper.getName());
        System.out.println("계좌번호: " + paper.getAccountNum());
        System.out.println("비밀번호: " + paper.getPwd());
        System.out.println("------------------------------------");
        System.out.println("\t🕌입력하신 정보가 맞습니까?(y/n) > ");
        System.out.println("------------------------------------");
        
        if(scan.next().equals("n")) {
    		System.out.println("------------------------------------");
    		System.out.println("\t🕌출금 용지를 재입력해주세요.");
    		System.out.println("------------------------------------");
    		info();
        } else {
    		System.out.println("------------------------------------");
    		System.out.println("\t🕌출금하실 금액을 입력해주세요.");
    		System.out.println("------------------------------------");
    		
    		withdrawal();
        }
	}
	
	//withdrawal
	public void withdrawal() {
		int withdrawalAmount = cm.withdrawal();
		
		AccountVo account = validateAccount();
		
		if(account != null) {
			processWithdrawal(account, withdrawalAmount);
		} else {
	        System.out.println("------------------------------------");
	        System.out.println("\t❌계좌 정보가 일치하지 않습니다.");
	        System.out.println("------------------------------------");
	        
	        info();
		}
	}
	
	//계좌 정보 검증
	public AccountVo validateAccount() {
        System.out.println("------------------------------------");
        System.out.println("\t🔍계좌 정보를 검증 중입니다...");
        System.out.println("------------------------------------");
        
        for(AccountVo account : accounts) {
        	if(account.getName().equals(paper.getName()) &&
        			account.getAccountNum() == paper.getAccountNum() &&
        			account.getPwd() == paper.getPwd()) {
        		System.out.println("✅ 계좌 정보가 확인되었습니다.");
                System.out.println("현재 잔액: " + account.getHave() + "만원");
                return account;
        	}
        		
        }
        
        return null;
	}
	
	// 출금 처리
    public void processWithdrawal(AccountVo account, int amount) {
        System.out.println("------------------------------------");
        System.out.println("\t💰출금 처리를 시작합니다...");
        System.out.println("------------------------------------");
        
        if(account.getHave() >= amount) {
            // 잔액에서 출금액 차감
            int newBalance = account.getHave() - amount;
            account.setHave(newBalance);
            
            System.out.println("✅ 출금이 완료되었습니다!");
            System.out.println("출금 금액: " + amount + "만원");
            System.out.println("남은 잔액: " + account.getHave() + "만원");
            System.out.println("------------------------------------");
            System.out.println("\t🕌거래가 완료되었습니다. 감사합니다!");
            System.out.println("------------------------------------");
        } else {
            System.out.println("❌ 잔액이 부족합니다!");
            System.out.println("현재 잔액: " + account.getHave() + "만원");
            System.out.println("요청 금액: " + amount + "만원");
        }
    }
	
}
