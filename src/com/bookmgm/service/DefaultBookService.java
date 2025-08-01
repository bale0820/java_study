package com.bookmgm.service;

import java.util.List;
import java.util.Random;

import com.bookmgm.application.BookManagementApplication;
import com.bookmgm.model.Book;
import com.bookmgm.repository.AladinBookRepository;
import com.bookmgm.repository.InMemoryBookRepository;
import com.bookmgm.repository.Yes24BookRepository;

import db.GenericRepositoryInterface;

public class DefaultBookService implements BookService {
	BookManagementApplication bma;
	GenericRepositoryInterface<Book> repository;
	
	
	public DefaultBookService(BookManagementApplication bma) {
		this.bma = bma;
		selectRepository();
//		repository = new InMemoryBookRepository();
	}
	
	
	/**
	 * 도서관 선택
	 * @return
	 */
	public void selectRepository() {
		System.out.println("--------------------------------------");
		System.out.println("1. 교육센터\t2. 알라딘\t3. 예스24");
		System.out.println("--------------------------------------");
		System.out.println("도서관 선택>");
		int rno = bma.scan.nextInt();
		if(rno == 1) {
			repository = new InMemoryBookRepository(1);
		}else if(rno == 2) {
			repository = new InMemoryBookRepository(2);
		}else  if(rno == 3) {
			repository = new InMemoryBookRepository(3);
		}else {
			
		}
	}
	
	public void selectRepository(int num) {
		System.out.println("--------------------------------------");
		System.out.println("1. 교육센터\t2. 알라딘\t3. 예스24");
		System.out.println("--------------------------------------");
		System.out.println("도서관 선택>");
		int rno = bma.scan.nextInt();
		if(rno == 1) {
			repository = new InMemoryBookRepository(1);
		}else if(rno == 2) {
			repository = new InMemoryBookRepository(2);
		}else  if(rno == 3) {
			repository = new InMemoryBookRepository(3);
		}else {
			
		}
		bma.showMenu();
	}

	 /**
	  * 도서 등록
	  */
//	@Override
	public void register() {
//		selectRepository()
		Book book = createBook();
		int rows =repository.insert(book);
		if(rows != 0) {
			//등록 성공
			System.out.println("✅도서가 등록되었습니다");
		} else {
			//등록 실패
			System.out.println("❌도서가 등록되지 않았습니다.");
		}
		bma.showMenu();
	};

	
	
	public Book createBook() {
		Book book = new Book();
		// id
		Random rd = new Random();
		book.setBid(String.valueOf(rd.nextInt(1000, 9999)));
		

		System.out.println("도서명>");
		book.setTitle(bma.scan.next());
		
		System.out.println("저자>");
		book.setAuthor(bma.scan.next());
		
		System.out.println("가격>");
		book.setPrice(bma.scan.nextInt());
		
		System.out.println("✅ 도서가 등록되었습니다.");
		return book;
	}
	
	/**
	 * 도서 생성
	 * @return book
	 * 도서 수정시 도서 정보를 일부 수정하여 반환
	 */
	public Book createBook(Book book) {
		System.out.println("[수정]도서명>");
		book.setTitle(bma.scan.next());
		
		System.out.println("[수정]저자>");
		book.setAuthor(bma.scan.next());
		
		System.out.println("[수정]가격>");
		book.setPrice(bma.scan.nextInt());
		
		System.out.println("✅ 도서가 등록되었습니다.");
		return book;
	}
	

	@Override
	public void list() {
		if(getCount() != 0) {
			List<Book> library = repository.findAll();
			System.out.println("--------------------------------");
			System.out.println("--------------------------------");
			library.forEach(book -> {
				System.out.print("["+book.getRno()+"]\t");
				System.out.print("["+book.getBid()+"]\t");
				System.out.print("["+book.getTitle()+"]\t");
				System.out.print("["+book.getAuthor()+"]\t");
				System.out.print("["+book.getIsbn()+"]\t");
				System.out.println("["+book.getPrice()+"]\t");
			});
		}else {
			System.out.println("등록된 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
	};

	@Override
	public void search() {
		if(getCount() != 0) {
			System.out.println("도서번호>");
			Book book = repository.find(bma.scan.next());
			if(book != null) {
				printBook(book);
			} else {
				System.out.println("❌검색한 도서가 존재하지 않습니다.");
			}
		} else {
			System.out.println("❌등록된 도서가 존재하지 않습니다.");
		}
		
		bma.showMenu();	
	};
	
	/**
	 * 도서 출력 - 검색, 수정 시 결과 출력
	 * @param book
	 */
	public void printBook(Book book) {
		System.out.println("--------------------------------");
		System.out.print("["+book.getBid()+"]\t");
		System.out.print("["+book.getTitle()+"]\t");
		System.out.print("["+book.getAuthor()+"]\t");
		System.out.println("["+book.getPrice()+"]\t");
		System.out.println("--------------------------------");
	}
	
	/**
	 * 도서 수정
	 */
	@Override
	public void update() {
		if(getCount() != 0) {
			System.out.println("도서번호>");
			Book book = repository.find(bma.scan.next());
			if(book != null) {
				int rows = repository.update(createBook(book));
				if(rows != 0) {
					printBook(book);
					System.out.println("✅도서가 수정되었습니다.");					
				}else {
					System.out.println("도서 수정 실패");	
				}
				
				
			} else {
				System.out.println("❌검색한 도서가 존재하지 않습니다");
			}
		} else {
			System.out.println("❌ 등록된 도서가 없습니다");
		}

		bma.showMenu();
	}
	
	
	@Override
	public void delete() {
		if(getCount() != 0) {
			System.out.println("도서번호>");
			Book book = repository.find(bma.scan.next());
			if(book != null) {
				int rows = repository.remove(book.getBid());
				if(rows != 0) {
					System.out.println("✅도서가 삭제되었습니다.");
				}else {
					System.out.println("도서 삭제 실패!!");
				}
			}else {
				System.out.println("❌검색한 도서가 존재하지 않습니다");
			}
		}else {
			System.out.println("❌ 등록된 도서가 없습니다");
		}
		bma.showMenu();
		
	};

	@Override
	public void exit() {
		System.out.println("✅시스템이 종료됩니다");
		repository.close();
		System.exit(0);
	};

	@Override
	public int getCount() {
		return repository.getCount();
	};
}
