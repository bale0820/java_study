package commons;

public class Menu {
	//기본값은 같은 패키지안에서만 접근가능하다.
	 int no;
	 int price;
	 String name;
	
	
	public Menu() {}
	public Menu(int no, String name, int price) {
		this.no = no;
		this.name = name;
		this.price = price;
	}
	
	
	
	public int getNo() { return no;}
	public String getName() { return name;}
	public int getPrice() { return price;}
	
	
	
	
	
}
