package com.bookmgm.application;

import java.util.Scanner;

import com.bookmgm.service.BookService;
import com.bookmgm.service.DefaultBookService;

public class BookManagementApplication {
	public static final int RESGISTER = 1;
	public static final int LIST = 2;
	public static final int SEARCH = 3;
	public static final int UPDATE = 4;
	public static final int DELETE = 5;
	public static final int EXIT = 6;
	public static final int CHANGE = 7;
	public Scanner scan;
	public BookService service;

	public BookManagementApplication() {
		scan = new Scanner(System.in);
		service = new DefaultBookService(this);
		showMenu();
	}

	/**
	 * 메뉴 출력 조금 수정해서 많이 바꾸자
	 */
	public void showMenu() {
		String[] labels = { "도서 등록", "도서 목록 조회", "도서 검색", "도서 수정", "도서 삭제", "종료","데이터베이스 변경" };
		int count = 0;
		System.out.println("===== 📕📖📚 도서 관리 시스템 📕📖📚 =====");
		System.out.println("전체 도서수 : " + service.getCount());
		for (int i = 0; i < labels.length; i++) {
			System.out.println((i + 1) + "." + labels[i]);
		}
		System.out.println("--------------------------------------");
		selectMenu();
	}

	/**
	 * 메뉴 선택
	 */
	public void selectMenu() {
		System.out.println("메뉴를 선택해주세요");
		if(scan.hasNextInt()) {
		switch(scan.nextInt()) {
		case RESGISTER:
			service.register();
			break;
		case LIST:
			service.list();
			break;
		case SEARCH:
			service.search();
			break;
		case UPDATE:
			service.update();
			break;
		case DELETE:
			service.delete();
			break;
		case EXIT:
			service.exit();
			break;
		case CHANGE:
			service.selectRepository(CHANGE);
			break;
		default:
			System.out.println("=> 메뉴 준비중 입니다.");
			selectMenu();
		}
		}else {
			System.out.println("❌올바르지 않은 형식입니다. 다시 선택해주세요");
			scan.next();
			selectMenu();
	}
	}

	public static void main(String[] args) throws Exception{
		Thread.sleep(10000);
		new BookManagementApplication();
	}

}
