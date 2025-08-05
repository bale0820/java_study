package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.db.DBConn;
import chapter21_mini_project.model.Book;
import chapter21_mini_project.model.GuestVo;

public class RepositoryImpl extends DBConn implements Repository {

	public RepositoryImpl() {

	}

	public GuestVo menuGuestInfo(GuestVo gv) {
		GuestVo guestVo = new GuestVo();
		String sql = """
				Select gid,name,phone from book_market_member where name = ? limit 1;
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, gv.getName());
			rs = pstmt.executeQuery();
			rs.next();
			guestVo.setGid(rs.getString(1));
			guestVo.setName(rs.getString(2));
			guestVo.setPhone(rs.getString(3));

		} catch (Exception e) {

		}
		return guestVo;
	}

	public List<Book> menuCartItemList(String gid) {
		List<Book> list = new ArrayList<Book>();
		String sql = """
				select bmc.gid,bmc.bid,bmb.title,bmb.author,bmb.price,bmb.isbn,bmb.bdate,bmc.count 
					from book_market_cart bmc,book_market_books bmb 
				where bmc.bid = bmb.bid
				and gid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, gid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setGid(rs.getString(1));
				book.setBid(rs.getString(2));
				book.setTitle(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setPrice(rs.getInt(5));
				book.setIsbn(rs.getString(6));
				book.setBdate(rs.getString(7));
				book.setCount(rs.getInt(8));
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	public int menuCartClear(String gid) {
		int rows = 0;
		String sql = """
				delete from book_market_cart where gid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, gid);
			rows = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rows;
	}

	public int menuCartAddItem(Book book,String gid,int count) {
		int rows = 0;
		String sql1 = """
				insert into book_market_cart(gid,bid)
						values(?,?)
				""";
		
		String sql2 = """
				update book_market_cart
				 set count = ?
				 where gid = ?
				 	and bid = ?
				""";
		try {
			
			List<Book> list = menuCartItemList(gid);
			for(int i=0;i<list.size();i++) {
				Book bk= list.get(i);
				if(book.getBid().equals(bk.getBid())) {
					getPreparedStatement(sql2);
					pstmt.setInt(1,count+1);
					pstmt.setString(2, gid);
					pstmt.setString(3, book.getBid());
					rows = pstmt.executeUpdate();
					
				}
			}
			
			if(rows == 0 && count == 0) {
			getPreparedStatement(sql1);
			pstmt.setString(1, gid);
			pstmt.setString(2, book.getBid());
			rows = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rows;
	}
	
	
	public int menuCartRemoveItemCount(String gid, String bid, int count) {
		int rows = 0;
		String sql = """
				update book_market_cart
					  set count = ?
					  where gid = ?
					  and bid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setString(2, gid);
			pstmt.setString(3, bid);
			rows =pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	
	
	
	public int menuCartRemoveItem(String gid, String bid) {
		int rows = 0;
		String sql  = """
				delete from book_market_cart where gid = ? and bid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1,gid);
			pstmt.setString(2,bid);
			rows = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	
	public GuestVo  findGuest(String gid) {
		GuestVo gv=  new GuestVo();
		String sql  = """
				select gid,name,phone,delivery from book_market_member where gid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, gid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				gv.setGid(rs.getString(1));
				gv.setName(rs.getString(2));
				gv.setPhone(rs.getString(3));
				gv.setDelivery(rs.getString(4));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return gv;
	}

	public int insert(GuestVo gv) {
		int rows = 0;
		String sql = """
				insert into book_market_member(name,phone,delivery)
					values(?,?,?)
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, gv.getName());
			pstmt.setString(2, gv.getPhone());
			pstmt.setString(3, gv.getDelivery());
			rows = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	public List<Book> getBooks() {
		List<Book> list = new ArrayList();
		String sql = """
				select bid,title,author,price,isbn,bdate from book_market_books
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBid(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setIsbn(rs.getString(5));
				book.setBdate(rs.getString(6));
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	public int getCount(String bid) {
		int rows = 0;
		String sql = """
				select count from book_market_cart where bid = ?
				""";
		try {
			
			getPreparedStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rows = rs.getInt(1);				
			}else {
				System.out.println("해당 책이 존재하지않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

}
