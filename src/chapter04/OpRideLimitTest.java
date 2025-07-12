package chapter04;

import java.util.Scanner;

public class OpRideLimitTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int age=0;
		int height=0;
		boolean parent = false;
		int limit=0;
		
		
		
		
		
		
		
		System.out.print("나이를 입력하시오");
		age = scan.nextInt();
		System.out.print("키를 입력하시오");
		height = scan.nextInt();
		System.out.print("부모님 동반입니까? 있으면 1 없으면 0;");
		parent = (scan.nextInt()==1)? true : false;
		System.out.print("심장질환이 있습니까? 있으면 1 없으면 0");
		limit = scan.nextInt();
		boolean dease = (limit == 1)? true:false;
		
		String result = ((((age > 6) && (height >= 120)) || ((age<6) && (height>=120) && (parent == true)))  && (dease == false))? "탑승 가능":"탑승 불가능";
		
		System.out.print(result);
		
				
		
		
		
	}

}
