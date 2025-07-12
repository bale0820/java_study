package kbank2;

import java.util.Scanner;

public class Customer {
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	private AccountPaperVo  accountPaper;
	private Scanner scan;
	
	public Customer() {}	
	public  Customer(String name, String accountNumber, String password, int money) {
		this.name = "[고객 :"+ name+"]";
		this.accountNumber = accountNumber;
		this.password = password;
		this.money=   money;
		this.scan = new Scanner(System.in);
		System.out.println(this.name+" 입장!");
	}
	
	public AccountPaperVo getAccountPaper() {
		System.out.println(this.name+" 은행직원에게 출금용지 전달!");
		return accountPaper;
	}

	public void setAccountPaper(AccountPaperVo accountPaper) {
		accountPaper.setName(this.name);
		accountPaper.setAccountNumber(this.accountNumber);
		accountPaper.setPassword(this.password);
		accountPaper.setMoney(this.money);
		this.accountPaper = accountPaper;
		
		System.out.println(this.name+" 출금정보 작성 완료!");	
	}
	
	public AccountPaperVo answer(int checkResult) {
		switch(checkResult) {
			case BankMan.ACCOUNT_NAME:
				System.out.println(this.name+"고객명>");
				String name = scan.next();
				accountPaper.setName(name);
			break;
			case BankMan.ACCOUNT_NUMBER:
				System.out.println(this.name+"계좌번호>");
				accountPaper.setAccountNumber(scan.next());
			break;
			case BankMan.ACCOUNT_PASSWORD:
				System.out.println(this.name+"패스워드>");
				accountPaper.setPassword(scan.next());
			break;
			case BankMan.ACCOUNT_MONEY:
				System.out.println(this.name+"금액>");
				accountPaper.setMoney(scan.nextInt());
			break;
		}
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
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Scanner getScan() {
		return scan;
	}
	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	
	
	
	
	
	
}
