package vending_machine_ver1;

public class RestArea {
	String name;
	User user;
	VendingMachine machine;
	 
	 public RestArea() {
		 this("만남의 광장");
	 }
	 
	 public RestArea(String name) {
		 this.name = name; //멤버 변수 초기화 작업
		  user = new User("정국"); //여러사용자를 받는작업 그리고 전국적인 기계
		  welcome();
		  machine = new VendingMachine(user); 
	 }
	 
	 public void welcome() {
		 	System.out.println("----------------------------");
		 	System.out.println(name+"☕☕🥤 휴게소에 오신것을 환영합니다");
			System.out.println("----------------------------");	
	 }
	 
}
