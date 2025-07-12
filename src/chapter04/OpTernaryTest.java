package chapter04;

import java.util.Scanner;

public class OpTernaryTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);// ctrl + shift + o 하면 임포트 되어진다
		
		System.out.print("점수> ");
		int score  = input.nextInt();
		
		//score가 60점 이상이면 "합격", 이하면 "불합격"임. 해당 결과를 result 변수에 대입함 
		
		String result = (score >= 60) ? "합격" : "불합격";
		System.out.println("result : " + result);
	}

}
