package chapter07;
//Object는 모든 클래스의 부모다

public class Animal2 {
	//Field : 전역변수 / 할당안해도 javac이 알아서 할당해준다
	String name;
	int age;
	
	//constructor //처음 한번만 실행하고 메모리에서삭제(메소드영역에 안들어간다)
	//지역변수는 메소드영역안에 있는것 
	//constructor : 생성자는 오버로딩이 가능함!!
	public Animal2() { //기본 생성자 하나만있을때는 생략가능 그러니까 오버로딩이 되면 기본생성자는 만들어주지않기때문에 꼭 넣어줘야한다
		//생성자 호출시 실행되는 내용 => new Animal()코드 실행 시 실행됨!!!
		System.out.println("객체를 생성한다.");
		
	}
	
	public Animal2(String name) { //field의 name만 초기화 이 name은 이 메소드안이라는 스코프를 가지기때문에 중복이름가능.
		this.name = name;			//this는 재귀변수 레퍼런스한다 주소를 참조한다 Animal2에 주소
		System.out.println("객체를 생성한다.");
	}

	public Animal2(String name, int age) { 
		this.name = name;		
		this.age = age;
		System.out.println("객체를 생성한다.");		
	}
	
	//Method // Method area에 들어간다
	//[반환타입=리턴타입]
	public void sleep() {
		String date = "2023년";
		System.out.println(date+" -> 잠을 잔다.");
	}
	
	//메인 메소드
	public static void main(String[] args) {
		Animal2 giraffe =  new Animal2();
		Animal2 elephant =  new Animal2();
		
		giraffe.name = "기린이";
		elephant.name = "코순이";
		
		System.out.println("giraffe.name = "+giraffe.name);
		System.out.println("elephant.name = "+elephant.name);
	}
}
