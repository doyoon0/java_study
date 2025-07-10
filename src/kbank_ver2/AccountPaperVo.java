package kbank_ver2;

public class AccountPaperVo {
	//Field
	private String name;
	private int accountNum;
	private int pwd;
	private int amount;
	
	//Constructor
	
	//Method
	public AccountPaperVo(String name, int accountNum, int pwd) {
		this.name = name;
		this.accountNum = accountNum;
		this.pwd = pwd;
		this.amount = 0;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
