package vending_machine_ver2;

import java.util.Scanner;

public class User {
	//이름, 입력을 위한 스캐너 객체
	String name;
	Scanner scan;
	
	
	public User() {
		this("일반 사용자");
	}
	public User(String name) {
		this.name = name;
		scan = new Scanner(System.in);
	
	}
	
	
	
	//getter 메소드 생성
	public String getName() {return name;}
	public Scanner getScanner() {return scan;}
	
	public int insertCoin() {
		int result = scan.nextInt();
		return result;
	}
}
