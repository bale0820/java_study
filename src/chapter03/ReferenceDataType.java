package chapter03;
import java.util.Scanner;
public class ReferenceDataType {

	public static void main(String[] args) {
		//참조 데이터 타입 정의 : 배열, 클래스, 인터페이스 ..바이트가 정해져있지않다
		String name = new String("홍길동");//String 생성자
		
		Scanner scan = new Scanner(System.in);
		//!!!!! 중요!!
		//String 클래스는 기본형으로도 사용이 가능함
		String name2 = "홍길동";
		
		System.out.println(name);
		System.out.println(name2);
		System.out.println(name == name2);		
		System.out.println(scan) ; //이렇게하면 scan이란 객체에 정보가 나온다
		
	}

}
