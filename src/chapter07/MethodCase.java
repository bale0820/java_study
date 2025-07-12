package chapter07;

public class MethodCase {
	//Field
	
	//Constructor
	public MethodCase() {
		System.out.println("MethodCase 객체 생성~");
	}
	
	//method
	//리턴타입 x, 매개변수 x
	public void method1() {
	 	 System.out.println("method1 --> 리턴타입x, 매개변수x");
	 	}
	
	//리턴타입o, 매개변수x
	public int method2() {
	 	int num1 = 10;
	 	int num2 = 20;
	 	
	 	return num1+num2;
	 }
	
	//리턴타입 x, 매개변수 o 오버로딩(매개변수 타입이 다름) 매개변수의 타입과 갯수에 따라 메소드 오버로딩(Overloading) 구현이 가능
	public void method3(int num1, int num2) {
	 	System.out.println("method3 --> "+(num1+num2));
	 	}
	 	
	 public void method3(String name) {
	 	System.out.println("method3 --> "+name);
	 	}
	
	 //리턴타입o, 매개변수o
	 public int method4(int num1, int num2) {
	 	return num1+num2;
	 }	
	 public String method4(String name) {
	 	return name;
	 	}
	
	
	
	
	//main method
	public static void main(String[] args) {
		MethodCase mc = new MethodCase();
		mc.method1();
		int sum = mc.method2();
		System.out.println("method2 --> "+sum);
		System.out.println("method2 --> "+sum);
		
		
		mc.method3(10,20);
		mc.method3("홍길동");
		
		System.out.println("method4 --> "+mc.method4(10,20));
		System.out.println("method4 --> "+mc.method4("홍길동"));
		mc.method4("홍길동");
	}
	
	
}
