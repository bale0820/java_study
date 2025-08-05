package chapter21_mini_project.repository;

import java.util.List;

import chapter21_mini_project.model.Book;
import chapter21_mini_project.model.GuestVo;

public interface Repository {
	public GuestVo menuGuestInfo(GuestVo gv);
	public List<Book> menuCartItemList(String gid);
	public int menuCartClear(String gid);
	public int menuCartAddItem(Book book,String gid,int count);
	public int menuCartRemoveItemCount(String gid, String bid, int count);
	public int menuCartRemoveItem(String gid, String bid);
	public GuestVo findGuest(String gid);
	public int insert(GuestVo gv);
	public List<Book> getBooks();
	public int getCount(String bid);
}
