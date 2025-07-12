package chapter04;

/*
 * 증감 연산자: ++, --, 단항식에서
 */
public class OpincrementTest {

	public static void main(String[] args) {
		int number = 10; 
		System.out.println(++number); //1을 추가하고 찍는다
		System.out.println(number++); //찍고나서 1을 추가한다
		System.out.println(number);
		
		
		System.out.println(--number);
		System.out.println(number--); //출력 11 메모리상에서는 10
		System.out.println(number);
	}

}
