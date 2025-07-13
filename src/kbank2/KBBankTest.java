package kbank2;

public class KBBankTest {

	public static void main(String[] args) {
		BankSystem kbsystem = new BankSystem("KB");
		kbsystem.showAccountList();  //은행시스템 확인
		
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();  
		
		BankMan staffPark = new BankMan("박보검", kbsystem); 		
		Customer hong = new Customer("홍길동", "kb-1234", null, 0);
		
		boolean validateFlag = true;
		hong.setAccountPaper(accountPaper);
		staffPark.setAccountPaper(hong.getAccountPaper());
		staffPark.validateCheck();
		
		while(validateFlag) {
			if(staffPark.validateCheck(hong.answer(staffPark.checkResult))) {
				validateFlag = false;
			}
		}

		staffPark.processWithdrawal();
		
		kbsystem.confirmBalance(hong.getAccountPaper()); //ATM(은행시스템)을 이용하여 잔액을 확인
		
	}

}












