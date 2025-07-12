package chapter07;

public class Car {
	//Field = 필드변수, 멤버변수, 전역변수
	String name;
	String company;
	int price;
	//constructor
	
	//Method
	public void showInfo()  {
		System.out.println(name +"\t");
		System.out.println("company : "+ company);
		System.out.println(price + "\t");
	}
}
