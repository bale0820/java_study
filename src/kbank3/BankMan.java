package kbank3;

public class BankMan {
	private String name;
	private AccountPaperVo accountPaper;
	private Customer customer;
	public static final int NAMENUMBER = 1;
	public static final int ACCOUNTNUMBER = 2;
	public static final int PASSWORDNUMBER = 3;
	public static final int MONEYNUMBER = 4;
	public int checkResult;
	

	public BankMan() {
		this("지점장");
	}

	public BankMan(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccountPaperVo getAccountPaper() {
		return accountPaper;
	}

	
	public void ask(int Result) {
		if(Result == NAMENUMBER ) {
			checkResult  = NAMENUMBER;
		}else if(Result == ACCOUNTNUMBER) {
			checkResult  = ACCOUNTNUMBER;
		}else if(Result == PASSWORDNUMBER) {
			checkResult  =PASSWORDNUMBER;
		}else if(Result == MONEYNUMBER) {
			checkResult  = MONEYNUMBER;
		}
	
	}
	
	public void searchAccount(KbankSystem kbankSystem) {
		int searchIdx = kbankSystem.searchAccount(accountPaper);
		
		if(searchIdx != -1) {
			if(kbankSystem.process(searchIdx)) {
				AccountVo[] accountList = kbankSystem.getAccountList();
				
				System.out.println("출금이 정상적으로 완료되었습니다 잔액은 "+accountList[searchIdx].getBalance()+ " 입니다");
			}
		}else {
			System.out.println("일치하는 계좌를 찾을수 없습니다.");
		}
			
	}
	
	
	public void setAccountPaper(AccountPaperVo accountPaper, Customer customer) {
		this.accountPaper = accountPaper;
		this.customer = customer;
	}
	
	
	public boolean checkAccountPaper() {
		boolean result = false;
		if (accountPaper.getName() == null) {
			System.out.println(customer.getName() + "님 이름이 빠졌습니다");
			ask(NAMENUMBER);

		} else if (accountPaper.getAccount() == null) {
			System.out.println(customer.getName() + "님 계좌번호가 빠졌습니다");
			ask(ACCOUNTNUMBER);
		} else if (accountPaper.getPassword() == null) {
			System.out.println(customer.getName() + "님  패스워드가 빠졌습니다");
			ask(PASSWORDNUMBER);
		} else if(accountPaper.getMoney() == 0) {
			System.out.println(customer.getName() + "님  출금액이 빠졌습니다");
			ask(MONEYNUMBER);
		}else {
			System.out.println("종이에 다 입력됨");
			result = true;
		}
		return result;
	}
}
