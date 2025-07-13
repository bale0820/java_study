package kbank3;

public class AccountPaperVo {
	private String name;
	private String account;
	private String password;
	private int money;
	
	private static AccountPaperVo accountPaper = new AccountPaperVo();
	
	
	private AccountPaperVo() {}
	public AccountPaperVo getInstance() {
		System.out.println("종이가 생성됨");
		return accountPaper;
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


	public static AccountPaperVo getAccountPaper() {
		return accountPaper;
	}


	public static void setAccountPaper(AccountPaperVo accountPaper) {
		AccountPaperVo.accountPaper = accountPaper;
	}
	

}
