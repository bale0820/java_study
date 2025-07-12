package kbank13;

public class AccountVo1 {
	private String name;
	 private String account;
	 private String password;
	 private int money;
	 
	 
	 
	 public AccountVo1() {}
	 public AccountVo1(String name, String account, String password, int money) {
		 this.name = name;
			this.account = account;
			this.password = password;
			this.money = money;
	 }
	 


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	 
}
