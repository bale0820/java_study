package kbank3;

public class KbankSystem {
	private String name;
	private AccountVo[] accountList;
	private static AccountPaperVo accountPaper;

	public KbankSystem() {
		this("sh");
	}

	public KbankSystem(String name) {
		this.name = name;
		accountList = createAccountList();
	}

	public AccountVo[] createAccountList() {
		String[] names = { "홍길동", "강감찬", "홍길순" };
		String[] accounts = { "kb-1234", "kb-5678", "kb-9012" };
		String[] passwords = { "1234", "5678", "9012" };
		int[] balances = { 300, 200, 300 };
		AccountVo[] accountList = new AccountVo[names.length];

		for (int i = 0; i < names.length; i++) {
			AccountVo account = new AccountVo();
			account.setName(names[i]);
			account.setAccount(accounts[i]);
			account.setPassword(passwords[i]);
			account.setBalance(balances[i]);

			accountList[i] = account;
		}

		return accountList;

	}

	public AccountVo[] getAccountList() {
		return accountList;
	}


	public  int searchAccount(AccountPaperVo accountPaper) {
		this.accountPaper =  accountPaper;
		int searchIdx = -1;
		for (int i = 0; i < accountList.length; i++) {
			AccountVo account = accountList[i];
			if (accountPaper.getName().equals(account.getName())
					&& accountPaper.getAccount().equals(account.getAccount())
					&& accountPaper.getPassword().equals(account.getPassword())) {

				searchIdx = i;
				break;
			}
		}
		System.out.println("계좌 찾음"+searchIdx);
		return searchIdx;
	}

	public boolean process(int searchIdx) {
		boolean result = false;
		if (accountPaper.getMoney() <= accountList[searchIdx].getBalance()) {
			int money = accountPaper.getMoney();
			int balance = accountList[searchIdx].getBalance();
			accountList[searchIdx].setBalance(balance - money);
			result = true;
		} else {
			System.out.println("계좌에 금액이 부족합니다");
			
			
		}

		return result;
	}
	
	public void showAccount(AccountPaperVo accountPaper) {
		for(int i=0;i<accountList.length;i++) {
			AccountVo account =  accountList[i];
			if(accountPaper.getName().equals(account.getName())&&
				accountPaper.getAccount().equals(account.getAccount())&&
				accountPaper.getPassword().equals(account.getPassword())) {
				System.out.println("고객명\t계좌번호\t총금액");
				System.out.print(account.getName());
				System.out.print(account.getAccount());
				System.out.println(account.getBalance());
			}
		}
	}
}
