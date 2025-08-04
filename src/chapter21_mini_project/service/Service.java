package chapter21_mini_project.service;

import java.util.List;

import chapter21_mini_project.model.Book;
import chapter21_mini_project.model.GuestVo;

public interface Service {
	
	public void menuGuestInfo();
	public void  menuCaruItemList();
	public void menuCartClear();
	public void menuCartAddItem();
	public void menuCartRemoveItemCount();
	public void menuCartRemoveItem();
	public int guestInsert(String name,String phone,String delivery);
	public List<Book> getBooks();
	public int getCount();
	public String getGid();
}
