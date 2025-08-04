package chapter21_mini_project.pay_book;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import chapter21_mini_project.BookMgmSystem;
import chapter21_mini_project.db.DBConn;
import chapter21_mini_project.model.Book;
import chapter21_mini_project.model.GuestVo;
import chapter21_mini_project.repository.Repository;
import chapter21_mini_project.repository.RepositoryImpl;

public class Pay extends DBConn {
	int totalAmount = 0;
	int totalPayment = 0;
	int change = 0;
	Repository repository;
	BookMgmSystem bms;
	Scanner scan;
	List<Book> list;
	String gid;
	public Pay(BookMgmSystem bms) {
		this.bms = bms;
		this.scan = bms.scan;
	}
	public void pay(String gid) {
		this.gid = gid;
		repository = new RepositoryImpl();
		list = repository.menuCaruItemList(gid);
		System.out.print(list.size());
		for(int i = 0 ;i<list.size();i++) {
			Book book = list.get(i);
			totalAmount += book.getPrice()*book.getCount();
		}
		System.out.println("");
		
		
		System.out.println("결제를 진행하겠습니다.");
		System.out.println("총금액은"+totalAmount+" 입니다");
		System.out.println("금액을 넣어주세요");
		boolean flag = false;
		while(flag) {
			totalPayment += scan.nextInt();
			if(totalPayment >= totalAmount ) {
				change = totalAmount - totalPayment;
				flag = true;
				System.out.println("결제 완료!");
			} else {
				System.out.println("금액이 부족합니다");
			}
		}
		delivery();
	}
	
	
	public void delivery() {
		System.out.println("배송받을 분은 고객정보와 같습니까? Y | N");
		if(scan.next().equals("N")) {
			System.out.println("배송받을 고객명을 입력하세요");
			String name = scan.next();
			System.out.println("배송받을 고객의 연락처를 입력하세요");
			String phone = scan.next();
			System.out.println("배송받을 고객의 배송지를 입력하세요");
			String delivery = scan.next();
			
			
			System.out.println("-----------------배송받을 고객 정보----------------");
			System.out.println("고객명 : " + name+"        "+"연락처 : " +phone);
			System.out.println("배송지 : " + delivery+"        "+"발송일 : " + LocalDate.now());
			System.out.println("-----------------------------------------------" );
			System.out.println("도서ID\t\t수량\t\t합계");
			list.forEach((book)-> {
				System.out.print(book.getBid()+"\t");
				System.out.print(book.getCount()+"\t");
				System.out.print(book.getPrice()*book.getCount()+"\n");
			});
			System.out.println("-----------------------------------------------" );
		}else {
			
			List<Book> list = repository.menuCaruItemList(gid);
			GuestVo gv = repository.findGuest(gid);
			System.out.println("-----------------배송받을 고객 정보----------------");
			System.out.println("고객명 : " + gv.getName()+"        "+"연락처 : " +gv.getPhone());
			System.out.println("배송지 : " + gv.getDelivery()+"        "+"발송일 : " + LocalDate.now());
			System.out.println("-----------------------------------------------" );
			System.out.println("도서ID\t\t수량\t\t합계");
			list.forEach((book)-> {
				System.out.print(book.getBid()+"\t");
				System.out.print(book.getCount()+"\t");
				System.out.print(book.getPrice()*book.getCount()+"\n");
			});
			System.out.println("-----------------------------------------------" );
			
		}
		
		bms.showMainMenu();
	}
	
	
	
}
