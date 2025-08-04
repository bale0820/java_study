package chapter21_mini_project;

import java.util.List;
import java.util.Scanner;

import chapter21_mini_project.model.Book;
import chapter21_mini_project.pay_book.Pay;
import chapter21_mini_project.service.Service;
import chapter21_mini_project.service.ServiceImpl;

public class BookMgmSystem {
	public static final int CHECK = 1;
	public static final int LIST = 2;
	public static final int EMPTY= 3;
	public static final int INSERT = 4;
	public static final int REDUCE = 5;
	public static final int DELETE = 6;
	public static final int RECEIPT = 7;
	public static final int EXIT = 8;
	public Scanner scan;
	Service service;
	public List<Book> list;
	Pay pay;
	public BookMgmSystem() {
		scan = new Scanner(System.in);
		service = new ServiceImpl(this);
		showMainMenu();
		

	}
	
	public void showMainMenu() {
		System.out.println("********************************");
		System.out.println("Welcome to Shopping Mall");
		System.out.println("Welcome to Book Market!");
		System.out.println("1. 고객 정보 확인하기 \t 4. 바구니에 항목 추가하기");
		System.out.println("2. 장바구니 상품 목록 보기 \t 5. 장바구니의 항목 수량 줄이기");
		System.out.println("3. 장바구니 비우기 \t 6. 장바구니의 항목 삭제하기");
		System.out.println("7. 영수증 표시하기 \t 8. 종료");
		System.out.println("********************************");
		list = service.getBooks();
		System.out.println("Bid\tauthor\ttitle\tprice\tisbn\tbate");
		list.forEach((book) -> {
			System.out.print(book.getBid()+'\t');
			System.out.print(book.getAuthor()+'\t');
			System.out.print(book.getTitle()+'\t');
			System.out.print(book.getPrice());
			System.out.print("\t"+book.getIsbn()+'\t');
			System.out.print(book.getBdate()+'\n');
		});
		selectMenu();	
	}

	
	public void selectMenu() {
		System.out.println("메뉴 번호를 선택해주세요");
		switch(scan.nextInt()) {
		case CHECK :
			service.menuGuestInfo();;
			break;
		case LIST :
			service.menuCaruItemList();
			break;
		case EMPTY :
			service.menuCartClear();
			break;
		case INSERT :
			service.menuCartAddItem();
			break;
		case REDUCE:
			service.menuCartRemoveItemCount();
			break;
		case DELETE :
			service.menuCartRemoveItem();
			break;
		case RECEIPT :
			pay = new Pay(this);
			pay.pay(service.getGid());
			break;
		case EXIT :
			break;
			
		}
		
		
	}

	public static void main(String[] args) {
		new BookMgmSystem();

	}

}
