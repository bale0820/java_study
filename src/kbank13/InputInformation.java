package kbank13;

import java.util.Scanner;

public class InputInformation {
	private static Scanner scan;
	private static String name ;
	private static String account;
	private static String password;
	private static int money;
	private static String smallpassword;
	private  static AccountVo1 clinetInfo;
	public InputInformation() {}
	
	
	public static void createInput() {
		scan = new Scanner(System.in);
		System.out.println("이름을 입력해주세요");
		name = scan.next();
		System.out.println("계좌를 입력해주세요");
		account = scan.next();
		System.out.println("비밀번호를 입력해주세요");
		password = scan.next();
		String firstString = password.substring(0,5);
		String stars = "*".repeat(password.length()-1);
		smallpassword = firstString+stars;
		System.out.println("출금할 금액을 입력해주세요");
		money = scan.nextInt();
		
		clinetInfo = new AccountVo1(name,account,password,money);
		
		showInformation();
	}
	
	
	public static void showInformation() {
		System.out.println("이름\t계좌\t비밀번호\t출금액");
		System.out.print(name+"\t");
		System.out.print(account+"\t");
		System.out.print(password+"\t");
		System.out.print(money+"\n");
		checkWell();
	}
	
	
	
	public static void checkWell() {
		System.out.println("정보가 맞으십니까 맞으면 y: 틀리면 n");
		if(scan.next().equals("n")) {
			createInput();
		}
		System.out.println("고객 정보 등록 완료");
		
	}


	public static AccountVo1 getClinetInfo() {
		return clinetInfo;
	}


	public static void setClinetInfo(AccountVo1 clinetInfo) {
		InputInformation.clinetInfo = clinetInfo;
	}
	
	
	
	
	
	
}
