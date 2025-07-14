package myTest;

public class WaterMachine extends Machine implements WaterMachineInterface{
	public String name;
	public  int password;
	
	public WaterMachine() {
		this("관리자",0);
	}
	public WaterMachine(String name, int password) {
		this.name = name;
 		this.password = password;
 		
	}
	
	
	public String getParentName() {
		return super.getNAME();
	}
	
	public int getParentAge() {
		return super.getAGE();
	}
	
	

	
	public void UI() {
		System.out.println("UI 보임!");
		
	}
}
