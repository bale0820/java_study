package chapter08;

public class Circle extends Shape implements ShapeInterface { //인터페이스는 제한이 없다 상속은 하나뿐이고 
//	String color; //웬만하면 필드는 자식에서
	int radius;
	public static final double PI = 3.14;
	
	public Circle(String color, int radius) {
		super(color);
		this.radius = radius;
	}

	@Override
	public void draw(){
		System.out.println(color + "원을 그린다.");
	}
	
	@Override
	public double getArea() {
		
		return PI*radius*radius;
	}
}
