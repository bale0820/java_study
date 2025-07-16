package chapter11;
// static 변수는 클래스 수준에서 할당되며, 모든 인스턴스가 공유하는 변수입니다. 
public class asd {

	public static void main(String[] args) {
		ExceptionObject.name = "홍길동";
		System.out.println(ExceptionObject.name);
		ExceptionObject asd = new ExceptionObject();
		asd.name = "홍길동1";
		System.out.println(asd.name);
		System.out.println(ExceptionObject.name);
	}

}
