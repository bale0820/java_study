package chapter08;
//추상메소드들 없애면 이제 일반클래스로 사용가능
 public class Shape {
	String color;
	
	protected Shape(String color) {
		this.color = color;
	} //protected는 상속받은놈들만 접근가능하다
}
