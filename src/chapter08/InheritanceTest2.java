package chapter08;

public class InheritanceTest2  {
	public static void main(String[] args) {
		Circle redC = new Circle("빨강색", 12);
		Rectangle yellowR = new Rectangle("노랑색", 10, 12);
		Triangle greenT = new Triangle("초록색");
		
		
		
		redC.draw();
		System.out.println("redC.getArea : "+ redC.getArea() );
		yellowR.draw();
		System.out.println("yellowR.getArea : "+ yellowR.getArea() );
		greenT.draw();
		System.out.println("greenT.getArea : "+ greenT.getArea());
		
	}
}
