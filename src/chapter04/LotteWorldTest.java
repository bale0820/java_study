package chapter04;

import java.util.Scanner;

public class LotteWorldTest {

	public static void main(String[] args) {
		// 놀이기구 탑승 전 체크사항
		//1. 6세 이상 탑승 가능(단, 6세이하는 키가 120cm 이상이고 보호자 동반하에 탑승가능)
		//2. 키 120cm 이상 탑승 가능
		//3. 심장질환자는 탑승 불가
		
		Scanner input = new Scanner(System.in);
		//지역변수를 선언하는 경우에는 반드시 초기화를 진행함 전역변수는 알아서 초기화해줌
		String name = "";// 또는 name = null;
		int age = 0;
		int height = 0;
		boolean parent = false;
		boolean dease = false;
		
		
		System.out.print("*******************************");
		System.out.print("놀이기구 탑승전 유의사항 및 체크");
		System.out.print("*******************************");
		System.out.print("이름>");
		name = input.next();
		System.out.print("나이>");
		age = input.nextInt();
		System.out.print("신장>");
		height = input.nextInt();
		System.out.print("부모님 동반(동반o:1, x:0)>");
		parent = (input.nextInt() == 1 )? true : false;
		System.out.print("심장질환(유:1, 무:0)");
		dease = (input.nextInt() == 1)? true : false;
//		System.out.println(name +"," + age + "," + height + "," + parent + ","+ dease);
		
				
		
	//((6세 이상 키가 120cm이상) || (6세이하 키가 120 보호자)) &&(심장질환)
		String result = (((age >6) && (height>120) || (age<6) && (height>120) && (parent = true)) && (dease == false))?
				"탑승가능!!" : "탑승 불가능!";
//		String result = (((age>=6) && (height>=120)) || ((age<6) && (height>=120) && (parent == true)) && (dease == false))?
//				"탑승가능!!" : "탑승 불가능";
		
		System.out.println("result : " + result);

	}

}
