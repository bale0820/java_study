package chapter11;

public class ExceptionTest3 {

	public static void main(String[] args) {
		String name1 = "홍길동";
		String name2 = null;
		ExceptionObject eo = null;
		eo = new ExceptionObject();
		
		
		try {
		if(name1.equals(eo.name)) { //null은 가서 빈값으로 가져온다
			System.out.println("동일!!");
		} else {
			System.out.println("다름!!");
		}
		} catch(NullPointerException ne) {
			System.out.println("NullPointerException 발생!!");
			ne.printStackTrace();
		}
		
	}
}
