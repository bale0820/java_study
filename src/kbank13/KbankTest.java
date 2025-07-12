package kbank13;

public class KbankTest {

	public static void main(String[] args) {
		System.out.println("환영합니다 고객님 k뱅크입니다");
		InputInformation.createInput();
		AccountVo1 clientInfo = InputInformation.getClinetInfo();
		
		
		Customer customer = new Customer(clientInfo.getName(),clientInfo.getAccount(),clientInfo.getPassword(),clientInfo.getMoney());
		Bankman man = new Bankman("카이도");
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();
	
		customer.setAccountPaper(accountPaper);
		man.checkWell(accountPaper, customer);
		Kbank kbank = new Kbank();
		kbank.createAccountVo(man.saveAccountVo(customer.getPassword()));
		kbank.setAccountPaper(man.getAccountPaper());
		kbank.compareInformation();
		
//		man.compareInformation();
		
		

	}

}
