package chapter21_mini_project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import chapter21_mini_project.BookMgmSystem;
import chapter21_mini_project.model.Book;
import chapter21_mini_project.model.GuestVo;
import chapter21_mini_project.pay_book.Pay;
import chapter21_mini_project.repository.Repository;
import chapter21_mini_project.repository.RepositoryImpl;

public class ServiceImpl implements Service {
	BookMgmSystem bms;
	Repository repository;
	Scanner scan;
	public String gid;
	public Pay pay;

	public ServiceImpl(BookMgmSystem bms) {
		this.bms = bms;
		this.scan = bms.scan;
		repository = new RepositoryImpl();
	}

	public void menuGuestInfo() {
		GuestVo gv = new GuestVo();

		System.out.println("당신의 이름을 입력하세요");
		String name = scan.next();
		System.out.println("연락처를 입력하세요");
		String phone = scan.next();

		gv.setName(name);
		gv.setPhone(phone);
		GuestVo guestVo = repository.menuGuestInfo(gv);
		if (guestVo.getGid() != null) {
			System.out.print("회원번호" + guestVo.getGid() + "\t");
			System.out.print("회원이름" + guestVo.getName() + "\t");
			System.out.println("회원폰번호" + guestVo.getPhone() + "\n");
		} else {
			System.out.print("회원정보가 없습니다 등록하시겠습니까? 동의하면 n");
			if (scan.next().equals("n")) {
				System.out.print("배달지를 입력해주세요");
				String delivery = scan.next();
				int rows = guestInsert(name, phone, delivery);
				if (rows != 0) {
					System.out.print("등록완료!");
				} else {
					System.out.print("등록실패!");
				}
			}

		}
		guestVo = repository.menuGuestInfo(gv);
		gid = guestVo.getGid();
		bms.showMainMenu();

	}

	public int guestInsert(String name, String phone, String delivery) {
		GuestVo gv = new GuestVo();
		gv.setName(name);
		gv.setPhone(phone);
		gv.setDelivery(delivery);
		return repository.insert(gv);
	};

	public void menuCartItemList() {
		List<Book> list = repository.menuCartItemList(gid);

		if (list.size() != 0) {
			System.out.println("gid\tbid\tauthor\ttitle\tprice\t\tisbn\tbate\tcount");
			list.forEach((book) -> {
				System.out.print(book.getGid() + '\t');
				System.out.print(book.getBid() + '\t');
				System.out.print(book.getAuthor() + '\t');
				System.out.print(book.getTitle() + '\t');
				System.out.print(book.getPrice() + "\t");
				System.out.print(book.getIsbn() + '\t');
				System.out.print(book.getBdate() + '\t');
				System.out.println(book.getCount());
			});
		} else {
			System.out.print("조회된 책이 없습니다!");
		}

		bms.showMainMenu();
	}

	public void menuCartClear() {
		int rows = repository.menuCartClear(gid);

		if (rows != 0) {
			System.out.print("삭제완료!");
		} else {
			System.out.print("삭제실패!");
		}
		bms.showMainMenu();
	}

	public void menuCartAddItem() {
		System.out.print("추가할려는 상품의 bid를 입력해주세요");
		String bid = scan.next();
		Book bk = null;

		for (int i = 0; i < bms.list.size(); i++) {
			Book book = bms.list.get(i);
			if (book.getBid().equals(bid)) {
				bk = book;
				break;
			}
		}
		int count = getCount(bid);
		int rows = repository.menuCartAddItem(bk, gid, count);

		if (rows != 0) {
			System.out.print("장바구니 담기 완료!");
		} else {
			System.out.print("장바구니 담기 실패!");
		}
		bms.showMainMenu();

	}

	public void menuCartRemoveItemCount() {
		System.out.print("항목을 줄일려는 bid를 입력해주세요");
		String bid = scan.next();
		System.out.print("몇개로 줄이시겠습니까?");
		int count = scan.nextInt();
		int rows = repository.menuCartRemoveItemCount(gid, bid, count);
		if (rows != 0) {
			System.out.print("장바구니 갯수 수정 완료!");
		} else {
			System.out.print("장바구니 갯수 수정 실패!");
		}
		bms.showMainMenu();
	}

	public void menuCartRemoveItem() {
		System.out.print("삭제할려는 책에 bid를 입력해주세요!");
		int rows = repository.menuCartRemoveItem(gid, scan.next());

		if (rows != 0) {
			System.out.print("삭제완료!");
		} else {
			System.out.print("삭제실패!");
		}
		bms.showMainMenu();
	}

	public List<Book> getBooks() {
		return repository.getBooks();
	}

	public int getCount(String bid) {
		return repository.getCount(bid);
	}

	public String getGid() {
		return gid;
	}

}
