package com.bookmgm.repository;


import java.util.ArrayList;
import java.util.List;

import com.bookmgm.model.Book;

import db.DBConn;
import db.GenericRepositoryInterface;

public class Yes24BookRepository extends DBConn implements GenericRepositoryInterface<Book>  {

	
	
	public Yes24BookRepository() {
		System.out.println("**예스24 도서관 생성 완료 **");
	}

	@Override
	public int  insert(Book book) {
		int rows = 0;
		String sql = """
				insert into book_yes24(title,author,price,bdate)
						values(?,?,?,now())
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2,book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			rows = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rows;
	};

	@Override
	public List<Book> findAll() {
		List<Book> list = new ArrayList();
		String sql = """
				select bid,title,author,price,isbn,bdate from book_yes24
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBid(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setIsbn(rs.getInt(5));
				book.setBdate(rs.getString(6));
				list.add(book);
				System.out.println(book.getBid());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	};

	@Override
	public Book find(String id) {
		Book book = null;
		String sql = """
				select bid,title,author,price,isbn,bdate from book_yes24 where bid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setBid(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setIsbn(rs.getInt(5));
				book.setBdate(rs.getString(6));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return book;
	};

	@Override
	public int update(Book book) {
		int rows = 0;
		String sql = """
				update book_yes24
					set title = ?,
						author = ?,
						price = ?
					where bid = ? 
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getBid());
			rows = pstmt.executeUpdate();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	};

	@Override
	public int remove(String bid) {
		int rows = 0;
		String sql = """
				delete from book_yes24 where bid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, bid);
			rows = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return rows;
	};
//	
//	@Override
//	public void remove(Book book) {
//		Iterator<Book> ie = library.iterator();
//		while(ie.hasNext()) {
//			Book b = ie.next();
//			if(b == book) ie.remove(); 
//		}
//	};
//
	@Override
	public int getCount() {
		int rows = 0;
		String sql =  """
				select count(*) from book_yes24
				""";
		try {
			getPreparedStatement(sql);
			
			rs = pstmt.executeQuery();
			rs.next();
			rows = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rows;
	};


}
