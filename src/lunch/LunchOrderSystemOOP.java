package lunch;

import java.util.Scanner;

public class LunchOrderSystemOOP {
	//Field
	String title;
	Scanner scan;
	LunchOrderMenuManager menuManager;
	String[] lunchMenuNames = {"햄버거(🍔)","피자요(🍕)","라멘요(🍜)","샐러드(🥗)"}; //선언+할당 동시!! 이거를 생성자안에 넣을수 없다.
	int[] lunchMenuPrice = {100,200,300,400};
	LunchMenu[] lunchMenuList;//크기만 선언 값은 아직할당안했다.  	//주문할 메뉴 : LunchMenu
	LunchOrderItem[] orderItemList;
	LunchPaymentItem paymentItem; 
	int orderCount = 0;
	int amount = 0; //결제금액-사용자 입력
	int change = 0; //잔돈
	
	
	//Constructor 컴파일하기전에 생략되어있으면 만들어준다. javac가 만들어준다.
	public LunchOrderSystemOOP() {
//		this.title = title;
		scan = new Scanner(System.in);
		menuManager = new LunchOrderMenuManager(this); //여기서 this 자기자신 즉 자기자신의 주소를 보낸다
		lunchMenuList = new LunchMenu[4]; //크기만 선언하면 이안에 넣을수있다
		orderItemList = new LunchOrderItem[4];
		menuManager.createLunchMenu(); //꼭 lunchMenuList = new LunchMenu[4] 밑에 넣어야한다	
//		showMainMenu();
	}
	
	
	public LunchOrderSystemOOP(String title) {
		this.title = title;
		scan = new Scanner(System.in);
		menuManager = new LunchOrderMenuManager(this);
		lunchMenuList = new LunchMenu[4]; //크기만 선언하면 이안에 넣을수있다
		orderItemList = new LunchOrderItem[4];
		menuManager.createLunchMenu(); //런치 메뉴 생성 메소드 호출 꼭 lunchMenuList = new LunchMenu[4] 밑에 넣어야한다	
		menuManager.showMainMenu();
	}
	
	
	
	
	
	
	
	
	
	/*
	 * 주문아이템의 인덱스 검색
	 */
	public int searchOrderItemIdx(int lunchMenu) {
		int idx = -1;
		for(int i=0;i<orderCount;i++) {
			LunchOrderItem orderItem = orderItemList[i];
			if(orderItem.no == lunchMenu) {
				idx = i;
			}
		}
		return idx;
		}
	
	/*
	 * 주문리스트 초기화
	 */
	public void orderItemListInit() {
//		orderItemList = new LunchOrderItem[4];
		for(int i =0;i<orderCount;i++) {
			orderItemList[i] = null;
		}
		
//		for(LunchOrderItem orderItem: orderItemList) {
//			if(orderItem != null) {orderItem = null;} //그냥 연결이 끊어지는 거다 상관없음
//		}
		orderCount = 0;
	}
	
	/*
	 * 주문 : order()
	 */
	public void order(int lunchMenu) {
		System.out.println(lunchMenu+"주문");
		//lunchMenuList의 메뉴 번호 확인
		for(LunchMenu menu:lunchMenuList) {
			if(menu.no == lunchMenu) {
				int idx = searchOrderItemIdx(lunchMenu);
				if(idx == -1) {
					orderItemList[orderCount]= new LunchOrderItem();
					orderItemList[orderCount].no = menu.no;
					orderItemList[orderCount].name = menu.name;
					orderItemList[orderCount].price = menu.price;
					orderItemList[orderCount].qty  = 1;	
					orderCount++;
				}
				else {
					orderItemList[idx].qty  += 1;	
				}
				break;
			}
		}
		System.out.println("=> 주문 완료!!");
		menuManager.showMainMenu();
		
	}
	
	/*
	 * 주문 내역 : orderList()
	 */
	public void orderList() {
		if(orderCount == 0) {
			System.out.println("=> 주문내역 존재X, 음식을 주문해주세요");
		}
		else {
			System.out.println("-----------------------------------------");
			System.out.println("\t음식 주문 리스트");
			System.out.println("-----------------------------------------");
			System.out.println("번호\t메뉴명\t가격\t수량");
			System.out.println("-----------------------------------------");
			
			for(LunchOrderItem orderItem: orderItemList) {
				if(orderItem != null ) {
				
				System.out.print(orderItem.no+"\t");
				System.out.print(orderItem.name+"\t");
				System.out.print(orderItem.price+"\t");
				System.out.print(orderItem.qty+"\n");
				System.out.println("-----------------------------------------");
				}
			}
			System.out.println("-----------------------------------------");
		}
		
		menuManager.showMainMenu();
	}
	
	/*
	 * 결제 예정금액 산출
	 */
	public int totalPayment() {
		int sum = 0;
		for( LunchOrderItem orderItem:orderItemList) {
			if(orderItem != null ) {
			sum += orderItem.price * orderItem.qty ;
			}
		}
		return sum;
	}
	
	
	/*
	 * 결제 : payment()
	 */
	public void payment() {
		if(orderCount == 0 ) {
			System.out.print("=> 주문내역 존재x,음식을 주문해주세요");
		}
		else {
			
			int total = totalPayment();
			System.out.print("=> 결제 예정 금액 : " + total);
			System.out.print("결제할 요금 입력(숫자)> ");	
			
			if(scan.hasNextInt()) {
				amount += scan.nextInt();
				System.out.println("=> 총 입력 금액 : " + amount);				
				
				if(amount >= total) {								
					change = amount - total;
					
					paymentItem = new LunchPaymentItem();
					paymentItem.name = orderItemList[0].name+"등";
					paymentItem.totalPayment = total;
					paymentItem.amount = amount;
					paymentItem.change = change;
					System.out.println("=> 결제 성공!!");
					
					//주문리스트 초기화
					orderItemListInit();//init은 초기화다
					
				} else {
					System.out.println("=> 요금이 부족합니다. 다시 입력해 주세요");
					payment();
				}			
				
			} else {
				System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.");
				scan.next();
			}//if
		}
		menuManager.showMainMenu();
	}
	
	
	
	/*
	 * 결제 내역 : paymentList()
	 */
	public void paymentList() {
		if(paymentItem == null ) {
			System.out.println("=> 결제내역x, 주문을 진행해주세요");
		} else {
			System.out.println("-----------------------------------------");
			System.out.println("\t결제 내역");
			System.out.println("-----------------------------------------");
			System.out.println("주문명\t결제금액\t총입금액\t잔돈");
			System.out.print(paymentItem.name+"\t");
			System.out.print(paymentItem.totalPayment+"\t");
			System.out.print(paymentItem.amount+"\t");
			System.out.print(paymentItem.change+"\n");
			System.out.println("-----------------------------------------");	
		}
		menuManager.showMainMenu();
	}
	
}//class
