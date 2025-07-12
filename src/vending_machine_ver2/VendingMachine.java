package vending_machine_ver2;

import commons.Menu;

public class VendingMachine {
	//Field
	User user;
	String[] nameList = {"☕ 밀크커피","☕ 아메리카노","🍋 유자차 ", "🥛 초코우유 "};
	int[] priceList = {300,400,300,200};
	Menu[] menuList;
	int totalCoin;
	Menu[] orderMenuList;
	int orderMenuCount  = 0;
	Menu orderMenu;
	int change;
	public static final int EXIT = 9;
	//Constructor
	public  VendingMachine() {
	}
	public  VendingMachine(User user) {
		this.user = user;
		createMenuList();
		showMenuList();
		PleaseInsertCoin();
		
	}
	//Method

	//메뉴 생성
	public void createMenuList() {
		menuList = new Menu[nameList.length];
		for(int i=0;i<nameList.length;i++) {
			int no = i+1;
			String name = nameList[i];
			int price= priceList[i];
			
			Menu menu = new Menu(no, name, price);
			menuList[i]= menu;
		}
	}
	//메뉴 출력
	public void showMenuList() {
		System.out.println("안녕하세요 "+user.name+"님 환영합니다***************");
		System.out.println("번호\t음료명\t\t가격");
		for(Menu menu : menuList) {
			System.out.print(menu.getNo()+"\t");
			System.out.print(menu.getName()+"\t");
			System.out.println(menu.getPrice()+"\t");
		}
	}
	
	//투입한 금액것 보다 낮은 메뉴리스트 출력
		public void showOrderMenu() {
			System.out.println("번호\t음료명\t\t가격");
			for(Menu menu : orderMenuList) {
				if(menu != null) {
				System.out.print(menu.getNo()+"\t");
				System.out.print(menu.getName()+"\t");
				System.out.println(menu.getPrice()+"\t");
				}
			}
		}
	
	
	
	//동전 투입 요구
	public void PleaseInsertCoin() {
		System.out.println("동전을 넣어주세요");
		int coin = user.insertCoin();
		if(coinCheck(coin)) {
			totalCoin += coin;
			if(totalCoin < 200) {
				System.out.println("최소 투입금액 보다 작습니다");
			}
			else {
				System.out.println("더 투입하시겠습니까? 더 투입할려면 아무키: 투입 종료시 n");
				if(user.scan.next().equals("n")) {
					createOrderList();
					showOrderMenu();
					selectMenu();
				}
				else {
					PleaseInsertCoin();
				}
			}
		}
		else {
			System.out.println("100원 500원만 넣어주세요");
			user.getScanner();
		};
		PleaseInsertCoin();	
	}
	
	//코인이 100원 500원이 맞는지 확인
	public boolean coinCheck(int totalCoin) {
		boolean result = false;
		if(totalCoin == 100 || totalCoin == 500) {
			result = true;
		}
		
		return result;
	}
	
	//투입한 금액보다 낮은 메뉴 생성
	public void createOrderList() {
		orderMenuList = new Menu[menuList.length];
		for(int i=0;i<menuList.length;i++) {
			Menu menu = menuList[i];
			if(menu.getPrice() <= totalCoin) {
				orderMenuList[orderMenuCount] = menu;
				orderMenuCount++;
			}
		}
		
	}
	
	
	//메뉴 선택
	public void selectMenu() {
		System.out.println("주문하실 메뉴의 번호를 입력해주세요");
		System.out.println("구매를 원하지 않을 시 ["+EXIT+"]을 입력해주세요");
			int menuNo = user.scan.nextInt();
			if(!(menuNo == EXIT)) {
				if(menuNoCheck(menuNo)) {
					order(menuNo);
				}
				else {
					System.out.println("잘못된 주문입니다. 다시 입력해주세요");
	//				user.scan.nextInt();
					selectMenu();
					
				}
			}else {
				System.out.println("잔돈"+totalCoin+"을 반환 합니다.");
				System.exit(0);;
			}
	}
	
	//메뉴체크
	public boolean menuNoCheck(int menuNo) {
		boolean result = false;
		for(Menu menu : orderMenuList) {
			if(menu != null) {
				 if(menu.getNo() == menuNo) {
					result = true;
					break;
				 }
			}
		}
		
		return result;
	}
	
	//주문
	public void order(int menuNo) {
//		int no = menuNo;
//		String name = orderMenuList[menuNo-1].getName();
//		int price = orderMenuList[menuNo-1].getPrice();
//		Menu menu = new Menu(no, name, price);
//		orderMenu = menu;
		for(int i =0;i<orderMenuCount;i++) {
			if(orderMenuList[i].getNo() == menuNo) {
				int no = orderMenuList[i].getNo();
				String name = orderMenuList[i].getName();
				int price = orderMenuList[i].getPrice();
				orderMenu = new Menu(no, name, price);
				break;
			}
		}
		processPayment();
	}
	
	//결제
	public void processPayment() {
		System.out.println("결제할 메뉴는"+orderMenu.getName());
		System.out.println("메뉴의 가격은"+orderMenu.getPrice());
		change =  totalCoin - orderMenu.getPrice();
		finalCheck();
	}
	
	//파이널 체크
	public void finalCheck() {
		int price = menuList[menuList.length-1].getPrice();
		if(change>= price) {
			System.out.println("현재 잔돈은 "+change+" 입니다");
			System.out.println("더 결제하시겠습니까? 동전을 반환할려면 n :  아니면 아무키나");
			if(user.scan.next().equals("n")) {
				System.out.println("현재 잔돈 "+change+"을 반환 하였습니다");
			}
			else {
				System.out.println("현재 잔돈은 "+change+" 입니다");
				totalCoin = change;
				orderMenuCount =0;
				createOrderList();
				showOrderMenu();
				selectMenu();
			}
		}
		System.out.println("잔돈"+change+"를 잘 챙겨주십시오");
		System.out.println("안녕히 가십시요!");
		receiveNextClient();
		
	}
	
	public void receiveNextClient() {
		System.out.println("고객님 성함을 입력해주세요");
		User user = new User(this.user.scan.next());
		new VendingMachine(user);
		
	}
	
}
