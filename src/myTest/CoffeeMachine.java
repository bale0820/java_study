package myTest;

public class CoffeeMachine extends Machine implements CoffeeMachineInterface{
	public String name;
	public  int password;
	
	
	
	public CoffeeMachine() {
		this("관리자",0);
	}
	public CoffeeMachine(String name, int password) {
		this.name = name;
 		this.password = password;
	}
	
	
	public String getParentName() {
		return super.getNAME();
	}
	
	public int getParentAge() {
		return super.getAGE();
	}
	
	public void press() {
		System.out.println("프레스");
	}
	
	
}
