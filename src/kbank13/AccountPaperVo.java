package kbank13;



//은행 페이퍼 단 한개만 존재
public class AccountPaperVo {
 private String name;
 private String account;
 private String password;
 private int money;
 
 private static AccountPaperVo accountPaper = new AccountPaperVo();
 
 private AccountPaperVo() {}
 
 
 
 
public static AccountPaperVo getInstance() {
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
	this.money= money;
}

 
}
