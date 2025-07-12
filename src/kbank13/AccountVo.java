package kbank13;

public class AccountVo {
	private String name;
	 private String account;
	 private String password;
	 private int balance;
	 
	 
	 
	 public AccountVo() {}
	 
	 public AccountVo(String name,String account,String password, int balance) {
		 this.name = name;
			this.account = account;
			this.password = password;
			this.balance = balance;
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

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
