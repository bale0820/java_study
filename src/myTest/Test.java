package myTest;

import test2.Monitor;

public class Test {

	public static void main(String[] args) {
		CoffeeMachine pMachine = new CoffeeMachine("홍길동",1111);
		Monitor monitor = new Monitor();
//		System.out.println(monitor.getNAME());
		System.out.println("기계 이름은 "+pMachine.getParentName()+"입니다 연식은 "+pMachine.getParentAge()+" 입니다 기계 관리자 이름은 "+pMachine.name+" 입니다"+"기계 관리자 이름은 "+pMachine.password+" 입니다");
		System.out.println();
		
	
		

	}

}
