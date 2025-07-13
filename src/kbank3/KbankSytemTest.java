package kbank3;

public class KbankSytemTest {

	public static void main(String[] args) {
		KbankSystem kbankSystem = new KbankSystem("kb");
		BankMan bankMan = new BankMan("윤효진");
		Customer customer = new Customer("홍길동", "kb-1234", "1234", 0);
		AccountPaperVo accountPaper = AccountPaperVo.getAccountPaper();
		customer.setAccountPaper(accountPaper);

		bankMan.setAccountPaper(customer.getAccountPaper(), customer);
//		bankMan.checkAccountPaper();

		boolean checkResult = true;
		while (checkResult) {
			if (bankMan.checkAccountPaper()) {
				checkResult = false;
				System.out.println("다 전부 작성하였습니다.");
			} else {
				AccountPaperVo updatePaper = customer.answer(bankMan.getAccountPaper(), bankMan.checkResult);
				bankMan.setAccountPaper(updatePaper, customer);
			}
		}

		bankMan.searchAccount(kbankSystem);
		
		kbankSystem.showAccount(customer.getAccountPaper());
	}

}
