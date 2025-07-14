package chapter08;

public class Triangle extends Shape implements ShapeInterface {
//	String color;
	
	
	
	public Triangle(String color) {
		super(color);
		this.color = color;
	
	}
	
	@Override
	public void draw() {
		 System.out.println(color + "삼각형을그린다.");
	 }
	
	@Override // 안써도 꼭 넣어줘야한다
	public double getArea() {
		return 0.00;
	}
}
