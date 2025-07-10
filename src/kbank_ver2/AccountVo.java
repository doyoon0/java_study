package kbank_ver2;

public class AccountVo {
	//Field
	private String name;
	private int accountNum;
	private int pwd;
	private int have;
	
	//Constructor
	public AccountVo(String name, int accountNum, int pwd, int have) {
		this.name = name;
		this.accountNum = accountNum;
		this.pwd = pwd;
		this.have = 500;
	}
	
	//Method
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
	public int getHave() {
		return have;
	}
	public void setHave(int have) {
		this.have = have;
	}
}
