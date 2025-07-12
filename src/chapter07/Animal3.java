package chapter07;
/*
 * 생성자 오버로딩,  this() 메소드
 */
public class Animal3 {
	//Field
	int age;
	String name;
	String addr;
	//Contructor
	public Animal3() {
//		this.name = "홍길동"; //무조건 this()이거는 무조건 위에 다른생성자로 초기화를 넘기니까
		this("홍길동",5,"강남구");
	}
	public Animal3(String name) {
		this(name, 5, "강남구"); //이러면 해당 생성자로 가서 초기화해준다
	}
	public Animal3(int age) {
		this("홍길동", age, "강남구");
	}
	
	public Animal3(String name, int age) {
		 this(name, age, "강남구");
//		this.name = name;
//		this.age = age;
		
	}
//	public Animal3(String addr) {} // 타입이 같은게 두개면 안된다.
	
	public Animal3(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	} 
	
	public void info() {
		System.out.println("name = "+name);
		System.out.println("age = "+age);
		System.out.println("addr = "+addr);
	}
	//Method
}
