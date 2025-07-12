package kbank13;

import java.util.Scanner;

public class Customer {
private String name;
private String account;
private String password;
private int money;
private Scanner scan;
private AccountPaperVo accountPaper;



public Customer() {}

public Customer(String name,String account,String password, int money ) {
	this.name = name;
	this.account = account;
	this.password = password;
	this.money = money;
}

public AccountPaperVo getAccountPaper() {
	return accountPaper;
}

public void setAccountPaper(AccountPaperVo accountPaper) {
	this.accountPaper = accountPaper;
	accountPaper.setName(this.name);
	accountPaper.setAccount(this.account);
	accountPaper.setPassword(this.password);
	accountPaper.setMoney(this.money);
}
public Scanner getScan() {
	return scan;
}

public void setScan(Scanner scan) {
	this.scan = scan;
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
