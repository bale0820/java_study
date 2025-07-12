package kbank13;

public class Kbank {
	AccountVo[] accounts = new AccountVo[100];
	AccountPaperVo accountPaper;
	int orderCount = 0;
	
	
	
	public Kbank() {}
	
	
	public AccountPaperVo getAccountPaper() {
		return accountPaper;
	}
	public void setAccountPaper(AccountPaperVo accountPaper) {
		this.accountPaper = accountPaper;
	}
	
	public void createAccountVo(AccountVo acc) {
		accounts[orderCount] = acc;
		System.out.println("저장완료");
		System.out.println(accounts[orderCount].getAccount());
		orderCount++;
	}
	
	public boolean compareInformation() {
		boolean result = false;
		for(int i=0;i<orderCount;i++) {
			if(accountPaper.getName().equals(accounts[i].getName())) {
				System.out.println("1");
				if(accountPaper.getAccount().equals(accounts[i].getAccount())) {
					System.out.println("2");
					if(accountPaper.getPassword().equals(accounts[i].getPassword())) {
						System.out.println("3");
						int rest = accounts[i].getBalance()- accountPaper.getMoney();
						accounts[i].setBalance(rest);
						result = true;
						System.out.println("승인 완료 잔액은"+rest+"입니다");
					}
				}
			}
		}
		System.out.println(accountPaper.getName());
		System.out.println(accountPaper.getAccount());
		System.out.println(accountPaper.getPassword());
		
		System.out.println(accounts[0].getName());
		System.out.println(accounts[0].getAccount());
		System.out.println(accounts[0].getPassword());
		System.out.println("하이");
		return result;
	}
	
	
}
