package chapter03;
import java.util.Scanner;
public class JavaScannerTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("**************************************");
		System.out.println("");
		System.out.println("\tWelcome to Shopping Mall");
		System.out.println("\tWelcome to Food Market");
		System.out.println("**************************************");
		System.out.println("");
		System.out.println("\t1.상품보기\t2.상품구입");
		System.out.println("\t3.영수증보기\t4.종료");
		System.out.println("**************************************");
		System.out.println("");
		
		System.out.print("메뉴를 선택해주세요(숫자) >");
		int menuNumber = scan.nextInt();
		//선택 메뉴 체크 확인
		
		if(menuNumber == 1) {
			System.out.println("선택한 메뉴: 1.상품보기 ");
		}
		System.out.println("선택한 메뉴: " + menuNumber);
		
		
		

	}

}
