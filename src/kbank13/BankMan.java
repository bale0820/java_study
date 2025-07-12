package kbank13;

import java.util.Scanner;

public class Bankman {
	String name;
	Scanner scan;
	AccountPaperVo accountPaper;
	
	
	
	
	public Bankman() {
		this("지점장");
	}
	public Bankman(String name) {
		this.name = name;
	}
	
	public AccountPaperVo getAccountPaper() {
		return accountPaper;
	}
	public void setAccountPaper(AccountPaperVo accountPaper) {
		this.accountPaper = accountPaper;
	}
	
	
	public void checkWell(AccountPaperVo accountPaper,Customer customer) {
		this.accountPaper = accountPaper;
		
		if(accountPaper.getName() == null) {
			System.out.println("["+name+"] 이름을 입력하지 않았습니다 이름을 넣어주세요");
			accountPaper.setName(customer.getScan().next());
		}else if(accountPaper.getAccount() == null) {
			System.out.println("["+name+"] 계좌를 입력하지 않았습니다 계좌를 넣어주세요");
			accountPaper.setAccount(customer.getScan().next());
		}else if(accountPaper.getPassword() == null) {
			System.out.println("["+name+"] 비밀번호를 입력하지 않았습니다 비밀번호를 넣어주세요");
			accountPaper.setPassword(customer.getScan().next());
		}else if(accountPaper.getMoney() == 0) {
			System.out.println("["+name+"] 출금할 금액을 입력하지 않았습니다 금액을 입력해주세요");
			accountPaper.setMoney(customer.getScan().nextInt());
		}else {
			System.out.println("결제 완료");
		}
	}
	
	
	public AccountVo saveAccountVo(String password) {
		scan = new Scanner(System.in);
		System.out.println("이름을 입력해주세요");
		String name = scan.next();
		System.out.println("계좌를 입력해주세요");
		String account = scan.next();
		System.out.println("총계좌금액을 입력해주세요");
		int balance = scan.nextInt();
		
		AccountVo acc = new AccountVo(name,account,password,balance);
		
		return acc;
		
		
		
	}
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Scanner getScan() {
		return scan;
	}
	public void setScan(Scanner scan) {
		this.scan = scan;
	}
	
}
