package chapter07;
//Object는 모든 클래스의 부모다

public class Animal {
	//Field : 전역변수 / 할당안해도 jvm이 알아서 할당해준다
	String name;
	int age;
	
	//constructor //처음 한번만 실행하고 메모리에서삭제(메소드영역에 안들어간다)
	//지역변수는 메소드영역안에 있는것 
	public Animal() { //기본 생성자
		//생성자 호출시 실행되는 내용 => new Animal()코드 실행 시 실행됨!!!
		System.out.println("객체를 생성한다.");
		
	}
	
	public Animal(String name) {
		this.name = name;
		System.out.println(name+"객체를 생성한다.");
		
	}
	
	//Method // Method area에 들어간다
	//[반환타입=리턴타입]
	public void sleep() {
		String date = "2023년";
		System.out.println(date+" -> 잠을 잔다.");
	}
	
	//메인 메소드
	public static void main(String[] args) {
		Animal giraffe =  new Animal();
		Animal elephant =  new Animal();
		
		giraffe.name = "기린이";
		elephant.name = "코순이";
		
		System.out.println("giraffe.name = "+giraffe.name);
		System.out.println("elephant.name = "+elephant.name);
	}
}
