package chapter03;


/*
 * 변수의 범위 설정 : Global(전역), Local(지역, 로컬)
 */
public class VariableScopeTest {
	//여기에 선언되는게 전역 변수 지역변수 전역변수 색깔이 다르다 파란색이면 전역변수
	static int gnumber = 10;
	
	
	//전역 상수: START, END
	static final int START = 1; //static method area에 
	static final int END = 0;
	
//	System.out.println(gnumber); 여기서는 x 꼭 메소드안에서
	public static void main(String[] args) {
		//main method 지역 변수
		int number = 100;
		String str = new String("홍길동");// main블록이 끝나면 여기지역변수는 스택에서삭제되지만 Heap에있는 값은 
		//가 안되었다가 Heap이 어느정도 차면 Garabage collector가 Heap을 청소해줌
		String str2; // scope범위는 main블록까지  이건 선언이다 스코프는 선언할때 결정된다
		
		
		
		{
			int number2 = 200;// 중괄호안에서만 정의
			str2 = "홍길순"; //할당
			System.out.println("전역상수 : " + number2);
			System.out.println("지역변수 : " + str2); 
		}
		System.out.println("지역변수 : " + number);
		System.out.println("전역변수 : " + gnumber); // 메소드 함수가 static이면 전역변수도 static 붙여야한다
		System.out.println("전역변수 : " + gnumber); 
		System.out.println("전역상수 : " + START); 
		System.out.println("전역상수 : " + END);  
		System.out.println("참조변수 : " + str); 
		System.out.println("지역변수 : " + str2); 
	}
}
