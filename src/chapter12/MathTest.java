package chapter12;
//클래스에 붙은 final은 상속을 안한다
public class MathTest {

	public static void main(String[] args) {
		//모든 메소드가 static으로 정의되어 있음 : 클래스명.메소드명()
		System.out.println(Math.abs(-100));
		System.out.println(Math.floor(123.4567)); //반올림은 안됨
		System.out.println(Math.max(100,200));
		System.out.println(Math.min(100,200));
		System.out.println(Math.random()); //정수 2자리 랜덤 호출
		System.out.println(Math.random() * 100);
		System.out.println((int)Math.floor(Math.random() * 100));
		System.out.println(Math.round(123.567)); //반올림해서
	}

}
