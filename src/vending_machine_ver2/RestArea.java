package vending_machine_ver2;

public class RestArea {
//Field
String store;
User user;
VendingMachine machine; 
//Constructor
public RestArea() {
	this("강남");
}
public RestArea(String store) {
	this.store = store;
	welcome();
	user = new User("정국");
	machine= new VendingMachine(user);
}
//Method
public void welcome() {
	System.out.println("****************************");
	System.out.println(store+"에 오신것을 환영합니다");
	System.out.println("****************************");
}
}
