package kbank2;



/**
 * 입출금 용지 
 */
public class AccountPaperVo {
	private  String name;
	private String accountNumber;
	private String password;
	private int money;
	
	
	private static AccountPaperVo accountPaper = new AccountPaperVo();
	
	
	
	private AccountPaperVo() {}
	
	
	public static void ShowInfo() {
		System.out.println("==================================");
		System.out.print(accountPaper.getName() +"\t");
		System.out.print(accountPaper.getAccountNumber() +"\t");
		System.out.print(accountPaper.getPassword() +"\t");
		System.out.print(accountPaper.getMoney() +"\n");
		System.out.println("==================================");
		
	}
	
	
	public static AccountPaperVo getInstance() {
		return accountPaper;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String pasword) {
		this.password = pasword;
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
