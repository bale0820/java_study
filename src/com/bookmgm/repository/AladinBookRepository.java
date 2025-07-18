package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bookmgm.model.Book;

public class AladinBookRepository implements BookRepository {
	
	List<Book> library = new ArrayList<>();
	
	public AladinBookRepository() {
		System.out.println("**알라딘 도서관 생성 완료 **");
	}
	
	Scanner scan = new Scanner(System.in);
	@Override
	public boolean insert(Book book) {
		if(book != null) {
			return library.add(book);
		}
		return false;
	};

	@Override
	public List<Book> selectAll() {
		return library;
	};

	@Override
	public Book select(String id) {
		Book book = null;
		for(Book b : library) {
			if(b.getId().equals(id)) {
				book = b;
				break;
			}
		}
		return book;
	};

	@Override
	public void update(Book book) {
		int idx = -1;
		int i=0;
		for(Book b:library) {
			if(book.getId().equals(b.getId())) {
				idx = i;
				break;
			}
			i++;
		}
		library.set(idx, book); //해당 객체로 바꾼다
	};

	@Override
	public void remove(String id) {
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext()) {
			Book book = ie.next();
			if(book.getId().equals(id)) ie.remove(); 
		}
	};
	
	@Override
	public void remove(Book book) {
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext()) {
			Book b = ie.next();
			if(b == book) ie.remove(); 
		}
	};

	@Override
	public int getCount() {
		
		return library.size();
	};

}
