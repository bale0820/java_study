package chapter07;

public class AnimalTest {
	String name = "홍길동";
	public static void main(String[] args) {
		System.out.println("-- AnimalTest 클래스 실행!!! --");

		//사자, 호랑이 객체 생성
		Animal lion = new Animal();
		Animal tiger = new Animal();
		Animal giraffe =  new Animal();
		Animal elephant =  new Animal();
		
		Animal2 lion2 = new Animal2("심바", 5);
		Animal2 tiger2 = new Animal2("호돌이");
		Animal2 elephant2 =  new Animal2();
		
		Animal3 lion3 = new Animal3("심바");
		lion3.info();
		
		
		lion.name = "심바"; //라이온에 주소를 따라가서 거기에 name전역변수를 삼바로 변경
		lion.age = 5;
		
		tiger.name = "호돌이"; //라이온에 주소를 따라가서 거기에 name전역변수를 삼바로 변경
		tiger.age = 3;
		
		
		System.out.println("lion.name = "+lion.name);
		System.out.println("lion.age = "+lion.age);
		System.out.println("tiger.name = "+tiger.name);
		System.out.println("tiger.age = "+tiger.age);
		
		lion.sleep();
		tiger.sleep();
		
		
		giraffe.name = "기린이";
		elephant.name = "코순이";
		
		System.out.println("giraffe.name = "+giraffe.name);
		System.out.println("elephant.name = "+elephant.name);
		
		System.out.println("--> 생성자 초기화");
		System.out.println("lion2.name = "+lion2.name);
		System.out.println("lion2.age = "+lion2.age);
		System.out.println("tiger2.name = "+tiger2.name);
		System.out.println("tiger2.age = "+tiger2.age);
		System.out.println("elephant2.name = "+elephant2.name);
	}

}
