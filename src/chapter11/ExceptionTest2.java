package chapter11;

import java.util.Scanner;

public class ExceptionTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("num1> ");
		int num1 = scan.nextInt();

		System.out.println("num2> ");
		int num2 = scan.nextInt();

		try {
			int result = num1 / num2;
			System.out.println("result : " + result);

			int[] numbers = { 1, 2, 3, };
			System.out.println(numbers[0]);
//			System.out.println(numbers[5]);
		} catch (Exception e) { // e는 이거는 스택 저장
			System.out.println("num2는 0을 입력할 수 없습니다. ");
			e.printStackTrace();//에러 상세설명을 볼수있다 스택에 찍혀있던것을 불러옴
		} finally {
			scan.close();
			System.out.println("-- 프로그램 종료 --");
		}

	}

}
