package kbank3;

import java.util.Scanner;

public class Customer {
	private AccountPaperVo accountPaper;
	private String name;
	private String account;
	private String password;
	private int money;
	private Scanner scan;
	public Customer() {
	}

	public Customer(String name, String account, String password, int money) {
		this.name = name;
		this.account = account;
		this.password = password;
		this.money = money;
		scan = new Scanner(System.in);
		
	}

	public AccountPaperVo answer(AccountPaperVo accountPaper,int checkResult) {
		if(checkResult == BankMan.NAMENUMBER) {
			System.out.println("고객명>");
			accountPaper.setName(scan.next());
		}else if(checkResult == BankMan.ACCOUNTNUMBER) {
			System.out.println("계좌번호>");
			accountPaper.setAccount(scan.next());
		}else if(checkResult == BankMan.PASSWORDNUMBER) {
			System.out.println("패스워드>");
			accountPaper.setPassword(scan.next());
		}else if(checkResult == BankMan.MONEYNUMBER) {
			System.out.println("출금액>");
			accountPaper.setMoney(scan.nextInt());
		}
		this.accountPaper = accountPaper;
		return this.accountPaper;
	}
	
	
	
	public AccountPaperVo getAccountPaper() {
		return accountPaper;
	}

	public void setAccountPaper(AccountPaperVo accountPaper) {
		this.accountPaper = accountPaper;
		accountPaper.setName(name);
		accountPaper.setAccount(account);
		accountPaper.setPassword(password);
		accountPaper.setMoney(money);
		System.out.println(name+"님이 종이에 적음!");
		
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